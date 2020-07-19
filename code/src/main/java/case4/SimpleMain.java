package case4;

public class SimpleMain {

    public static void main(String[] args) {

        StringHolder stringHolder = new StringHolder();
        System.out.println("SOUT after initialization");
        System.out.println(stringHolder);

        StringHolder.MyStringBuffer alfa = stringHolder.getAlfa();
        StringHolder.MyStringBuffer bravo = stringHolder.getBravo();
        StringHolder.MyStringBuffer charlie = stringHolder.getCharlie();
        StringHolder.MyStringBuffer delta = stringHolder.getDelta();
        StringHolder.MyStringBuffer echo = stringHolder.getEcho();

        System.out.println("First SOUT");
        System.out.println(stringHolder);
        System.out.println(alfa);
        System.out.println(bravo);
        System.out.println(charlie);
        System.out.println(echo);
        System.out.println(delta);

        System.out.println();
        Integer i_1 = 100;
        Integer i_2 = 100;
        System.out.println(i_1 == i_2);
        System.out.println(i_1.equals(i_2));

        Integer i_3 = 135;
        Integer i_4 = 135;
        System.out.println(i_3 == i_4);
        System.out.println(i_3.equals(i_4));

        System.out.println();
        System.out.println("Second SOUT");
        System.out.println(stringHolder);
        System.out.println(alfa);
        System.out.println(bravo);
        System.out.println(charlie);
        System.out.println(echo);
        System.out.println(delta);

    }
}
