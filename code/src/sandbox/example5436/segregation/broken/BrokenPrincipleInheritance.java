package example5436.segregation.broken;

public class BrokenPrincipleInheritance extends AbstractBrokenPrincipleInheritance {

    @Override
    public void showNumberC() {
        //no op
    }

    @Override
    public int getNumberB() {
        return 2;
    }

    @Override
    public int getNumberA() {
        return 1;
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
