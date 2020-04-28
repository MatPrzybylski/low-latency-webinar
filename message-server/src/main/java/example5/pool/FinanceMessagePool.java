package example5.pool;

import example5.data.FinanceMessage;

public class FinanceMessagePool extends Pool<FinanceMessage> {

    public FinanceMessagePool(int poolSize) {
        super(poolSize);
    }

    @Override
    protected FinanceMessage createEmptyObject() {
        return new FinanceMessage();
    }
}
