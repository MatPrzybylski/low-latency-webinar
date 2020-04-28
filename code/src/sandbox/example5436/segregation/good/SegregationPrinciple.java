package example5436.segregation.good;


import example5436.segregation.good.interfaces.*;

public class SegregationPrinciple extends AbstractSegregationPrinciple implements B, C, D, G, A, E, F  {

    @Override
    public int getNumberA() {
        return 1;
    }

    @Override
    public int getNumberB() {
        return 2;
    }

    @Override
    public int getNumberC() {
        return 3;
    }

    @Override
    public int getNumberD() {
        return 4;
    }

    @Override
    public int getNumberG() {
        return 8;
    }
}
