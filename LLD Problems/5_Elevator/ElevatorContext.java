import java.util.Collection;

public class ElevatorContext {
    
    private final long id;
    private final int currentFloor;
    private final Direction currentDirection;
    private final ElevatorStatus status;
    private final Collection<Integer> pendingRequests;

    public ElevatorContext(
        long id,
        int currentFloor, 
        Direction currentDirection,
        ElevatorStatus status,
        Collection<Integer> pendingRequests) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.currentDirection = currentDirection;
        this.status = status;
        this.pendingRequests = pendingRequests;
    }

    public long getId() {
        return this.id;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public ElevatorStatus getStatus() {
        return this.status;
    }

    public Collection<Integer> getPendingRequests() {
        return this.pendingRequests;
    }

    public static ElevatorContextBuilder builder() {
        return new ElevatorContextBuilder();
    }

    public static class ElevatorContextBuilder {

        private long id;
        private int currentFloor;
        private Direction currentDirection;
        private ElevatorStatus status;
        private Collection<Integer> pendingRequests;

        public ElevatorContextBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ElevatorContextBuilder currentFloor(int currentFloor) {
            this.currentFloor = currentFloor;
            return this;
        }

        public ElevatorContextBuilder currentDirection(Direction currentDirection) {
            this.currentDirection = currentDirection;
            return this;
        }

        public ElevatorContextBuilder status(ElevatorStatus status) {
            this.status = status;
            return this;
        }

        public ElevatorContextBuilder pendingRequests(Collection<Integer> pendingRequests) {
            this.pendingRequests = pendingRequests;
            return this;
        }

        public ElevatorContext build() {
            return new ElevatorContext(
                id,
                currentFloor,
                currentDirection,
                status,
                pendingRequests
            );
        }
    }
}
