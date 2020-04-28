package example5436.segregation.broken;

public class BrokenPrinciple extends AbstractBrokenPrinciple {

    @Override
    public int getNumberAa() {
        return 2;
    }

    @Override
    public void showNumberAa() {
        //no op
    }

    @Override
    public void showNumberAaa() {
        //no op
    }
}
