package case5.pool;

import case5.data.FinanceMessage;

public class FinanceMessagePool extends Pool<FinanceMessage> {

    public FinanceMessagePool(int poolSize) {
        super(poolSize);
    }

    @Override
    protected FinanceMessage createEmptyObject() {
        return new FinanceMessage();
    }
}
