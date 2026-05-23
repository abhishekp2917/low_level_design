import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class Elevator implements Runnable {
    
    private long id;
    private volatile int currentFloor;
    private int topFloor;
    private int bottomFloor;
    private final double capacityInKg;
    private volatile double currentWeightInKg;
    private volatile ElevatorStatus status;
    private volatile Direction currentDirection;
    private final IElevatorSchedulerStrategy schedulingStrategy;
    private final Object lock = new Object();
    private static final AtomicLong incrementer = new AtomicLong();

    public Elevator(double capacityInKg, int topFloor, int bottomFloor, IElevatorSchedulerStrategy schedulingStrategy) {
        this.id = incrementer.getAndIncrement();
        this.currentFloor = bottomFloor;
        this.topFloor = topFloor;
        this.bottomFloor = bottomFloor;
        this.capacityInKg = capacityInKg;
        this.status = ElevatorStatus.STATIONARY;
        this.currentDirection = Direction.NONE;
        this.schedulingStrategy = schedulingStrategy;
    }

    public long getId() {
        return this.id;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public double getCapacityInKg() {
        return this.capacityInKg;
    }

    public double getCurrentWeightInKg() {
        return this.currentWeightInKg;
    }

    public ElevatorStatus getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public Collection<Integer> getPendingRequests() {
        synchronized(lock) {
            return List.copyOf(this.schedulingStrategy.getRequests());
        }
    }

    public void queueRequest(int floorNumber) {
        if(floorNumber>topFloor || floorNumber<bottomFloor) {
            throw new IllegalArgumentException("Invalid floor number.");
        }
        synchronized(lock) {
            if(this.currentFloor==floorNumber && this.status==ElevatorStatus.STATIONARY) return;
            this.schedulingStrategy.addFloor(floorNumber);
            lock.notify();
        }
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            Integer nextFloor = null;
            synchronized(lock) {
                while(this.schedulingStrategy.isEmpty()) {
                    try{
                        lock.wait();
                    }
                    catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                ElevatorContext context = ElevatorContext.builder()
                    .currentDirection(this.currentDirection)
                    .currentFloor(this.currentFloor)
                    .status(this.status)
                    .build();
                Optional<Integer> nextFloorOpt = this.schedulingStrategy.getNextFloor(context);
                if(nextFloorOpt.isPresent()){
                    nextFloor = nextFloorOpt.get();
                    this.schedulingStrategy.removeFloor(nextFloor);
                } 
                else nextFloor = null;
            }
            processRequest(nextFloor);
        }
    }
    
    private void processRequest(Integer nextFloor) {
        if(nextFloor==null) return;
        Integer startFloor = null;
        synchronized(lock) {
            if(this.currentFloor<nextFloor) this.currentDirection = Direction.UP;
            else if(this.currentFloor>nextFloor) this.currentDirection = Direction.DOWN;
            else this.currentDirection = Direction.NONE;
            this.status = ElevatorStatus.MOVING;
            startFloor = this.currentFloor;
        }
        try{
            Thread.sleep(5000*Math.abs(startFloor-nextFloor));
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        synchronized(lock) {
            this.status = ElevatorStatus.STATIONARY;
            this.currentFloor = nextFloor;
            if(this.schedulingStrategy.isEmpty()) this.currentDirection = Direction.NONE;
        }
    }
}
