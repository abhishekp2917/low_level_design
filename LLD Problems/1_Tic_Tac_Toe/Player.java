import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Player {

    private static final AtomicLong incrementer = new AtomicLong();
    private final long id;
    private final String name;
    private final Symbol symbol;

    private Player(String name, Symbol symbol) {
        this.id = generateId();
        this.name = name;
        this.symbol = symbol;
    }

    public long getId() { return this.id; }

    public String getName() { return this.name; }
    
    public Symbol getSymbol() { return this.symbol; }

    private static long generateId() {
        return incrementer.incrementAndGet();
    }

    public static PlayerBuilder builder() {
        return new Player.PlayerBuilder();
    }

    public static class PlayerBuilder {

        private String name;
        private Symbol symbol;

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder symbol(Symbol symbol) {
            this.symbol = symbol;
            return this;
        }

        public Player build() {
            return new Player(
                Objects.requireNonNull(this.name, "Player Name is required"),
                Objects.requireNonNull(this.symbol, "Player Symbol is required"));
        } 
    } 

    @Override
    public String toString() {
        return String.format(
            "[Id: %s, Name: %s, Symbol: %s]", 
            this.id, 
            this.name, 
            this.symbol);
    }
}

