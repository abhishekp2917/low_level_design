public abstract class IObjectPoolStrategy<T extends Resettable> {

    protected final int poolSize;

    public IObjectPoolStrategy(int poolSize) {
        this.poolSize = poolSize;
    }

    public abstract void restore(T object);

    public abstract T getInstance();
}
