package example5436.segregation.broken;

import example5436.segregation.broken.interfaces.A;

public abstract class AbstractBrokenPrinciple implements A {

    @Override
    public int getNumberA() {
        return 11;
    }

    @Override
    public int getNumberAa() {
        return 22;
    }
}
