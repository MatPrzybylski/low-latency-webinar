package example5.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public abstract class Pool<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Pool.class);

    private final LinkedList<T> pool;
    private final int poolSize;

    public Pool(int poolSize) {
        this.poolSize = poolSize;
        this.pool = new LinkedList<>();
        allocateObjects();
        LOGGER.info("Created Pool with " + poolSize + " objects of type " + this.getClass()) ;
    }

    abstract protected T createEmptyObject();

    private void allocateObjects() {
        for (int i = 0; i < poolSize; i++) {
            pool.addLast(createEmptyObject());
            LOGGER.debug("Allocated object in the pool: " + pool.peek());
        }
    }

    public T checkOut() {
        while (pool.isEmpty()) {
            LOGGER.warn("Object pool is empty! Waiting for available objects!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                LOGGER.warn("Exception occurred when Thread was waiting: " + ex);            }
        }
        T obj = pool.poll();
        LOGGER.debug("Checked out object: " + obj);
        return obj;
    }

    public void returnObject(T object) {
        if (object == null) {
            LOGGER.warn("Nothing to return!");
            return;
        }
        this.pool.offer(object);
        LOGGER.debug("Returned object " + object + " to the pool. Available objects: " + pool.size());
    }

    public boolean isEmpty() {
        return pool.isEmpty();
    }

}
