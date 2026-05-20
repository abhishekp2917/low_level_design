import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class SimplePoolStrategy<T extends Resettable> extends IObjectPoolStrategy<T> {

    private final ArrayDeque<T> nonReferencedObjects;
    private final Set<T> referencedObjects;
    private final Supplier<T> objectFactory;

    public SimplePoolStrategy(int poolSize, Supplier<T> objectFactory) {
        super(poolSize);
        this.objectFactory = objectFactory;
        this.nonReferencedObjects = new ArrayDeque<>();
        this.referencedObjects = new HashSet<>();
        for (int i = 0; i < poolSize; i++) {
            nonReferencedObjects.addLast(objectFactory.get());
        }
    }

    @Override
    public synchronized void restore(T object) {
        if (!referencedObjects.contains(object)) return;
        referencedObjects.remove(object);
        nonReferencedObjects.addLast(object);
        object.reset();
    }

    @Override
    public synchronized T getInstance() {
        if (nonReferencedObjects.isEmpty()) {
            return null;
        }
        T object = nonReferencedObjects.removeFirst();
        referencedObjects.add(object);
        return object;
    }
}