import java.util.concurrent.atomic.AtomicLong;

public class Request {
    
    private static final AtomicLong incrementer = new AtomicLong();
    private final long id;
    private final String ipAddress;
    private final String username;

    public Request(String ipAddress, String username) {
        this.id = incrementer.getAndIncrement();
        this.ipAddress = ipAddress;
        this.username = username;
    }
    
    public long getId() {
        return this.id;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getUsername() {
        return this.username;
    }
    
}
