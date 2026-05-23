import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ElevatorSystem {
    
    private final long id;
    private final int topFloor;
    private final int bottomFloor;
    private final Map<Long, Elevator> elevators;
    private IRequestDelegationStrategy requestDelegationStrategy;
    private final ExecutorService executorService;
    private static final AtomicLong incrementer = new AtomicLong();

    public ElevatorSystem(int topFloor, int bottomFloor, int elevatorCount, double elevatorCapacityInKg, IRequestDelegationStrategy delegationStrategy) {
        this.id = incrementer.getAndIncrement();
        this.topFloor = topFloor;
        this.bottomFloor = bottomFloor;
        this.requestDelegationStrategy = delegationStrategy;
        this.executorService = Executors.newFixedThreadPool(elevatorCount);
        this.elevators = new HashMap<>();
        for(int i=0; i<elevatorCount; i++) {
            Elevator elevator = new Elevator(
                elevatorCapacityInKg, 
                topFloor, 
                bottomFloor, 
                null);
            this.elevators.put(elevator.getId(), elevator);
            this.executorService.submit(elevator);
        }
    }


    public synchronized long getElevator(int currentFloor, Direction direction) {
        if(currentFloor>topFloor || currentFloor<bottomFloor) {
            throw new IllegalArgumentException("Invalid floor number.");
        }
        if(direction.equals(Direction.NONE)) {
            throw new IllegalArgumentException("Invalid direction.");
        }
        Collection<ElevatorContext> contexts = this.elevators.values()
        .stream()
        .map(elevator -> {
            return ElevatorContext.builder()
            .id(elevator.getId())
            .currentFloor(elevator.getCurrentFloor())
            .currentDirection(elevator.getCurrentDirection())
            .status(elevator.getStatus())
            .pendingRequests(elevator.getPendingRequests())
            .build();
        })
        .toList();
        Optional<Long> elevatorIdOpt = this.requestDelegationStrategy.delegateRequest(
            currentFloor, 
            direction,
            contexts);
        if(elevatorIdOpt.isEmpty()) {
            throw new IllegalStateException("No elevator is available. Please try again later.");
        } 
        if(!this.elevators.containsKey(elevatorIdOpt.get())) {
            throw new IllegalStateException("Something went wrong. Please try again.");
        }
        Elevator elevator = this.elevators.get(elevatorIdOpt.get());
        elevator.queueRequest(currentFloor);
        return elevator.getId();
    } 
    
    public void submitInternalRequest(long elevatorId, int destinationFloor) {
        if(!this.elevators.containsKey(elevatorId)) {
            throw new IllegalArgumentException("No such elevator exists");
        }
        if(destinationFloor>topFloor || destinationFloor<bottomFloor) {
            throw new IllegalArgumentException("Invalid floor number.");
        }
        Elevator elevator = this.elevators.get(elevatorId);
        elevator.queueRequest(destinationFloor);
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(10,TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } 
        catch(InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
