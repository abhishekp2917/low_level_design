import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BoardDisplayerFactory {
    
    private static final ConcurrentMap<BoardDisplayerType, IBoardDisplayer> instances = new ConcurrentHashMap<>();

    public static IBoardDisplayer get(BoardDisplayerType boardDisplayerType) {
        return instances.computeIfAbsent(boardDisplayerType, BoardDisplayerFactory::create);
    }

    private static IBoardDisplayer create(BoardDisplayerType boardDisplayerType) {
        switch (boardDisplayerType) {
            case CONSOLE:
                return new ConsoleBoardDisplayer();
            default:
                throw new IllegalArgumentException("Unsupported type: " + boardDisplayerType);
        }
    }

    public static enum BoardDisplayerType {

        CONSOLE,
        ADVANCED;
    }
}
