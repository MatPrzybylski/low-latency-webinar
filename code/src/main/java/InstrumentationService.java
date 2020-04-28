import example100.ListPresizingBenchmark;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstrumentationService {

    public static void main(String[] args) {

        int i = 500;  // 4 bytes
        Integer i2 = Integer.valueOf(500);    //16 bytes

        ListPresizingBenchmark benchmark = new ListPresizingBenchmark();
        benchmark.init();

        System.out.println(InstrumentationAgent.getObjectSize(benchmark.normalArrayList));
        System.out.println(InstrumentationAgent.getObjectSize(benchmark.presizedArrayList));
        System.out.println(InstrumentationAgent.getObjectSize(benchmark.normalIntArrayList));
        System.out.println(InstrumentationAgent.getObjectSize(benchmark.presizedIntArrayList));

        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if ("RUN".equalsIgnoreCase(line)) {
                triggerCode();
            }
            if ("EXIT".equalsIgnoreCase(line)) {
                break;
            }
        }

    }

    public static void triggerCode() {
        int i_127 = 127;
        Integer i_127a = Integer.valueOf(127);
        Integer i_127b = Integer.valueOf(127);
        Integer i_129a = Integer.valueOf(129);
        Integer i_129b = Integer.valueOf(129);

        System.out.println(InstrumentationAgent.getObjectSize(Integer.MAX_VALUE));
        System.out.println(InstrumentationAgent.getObjectSize(i_127a));

        System.out.println(i_127a == i_127b);
        System.out.println(i_127a.equals(i_127b));

        System.out.println(i_129a == i_129b);
        System.out.println(i_129a.equals(i_129b));

        System.out.println(Integer.toBinaryString(i_127));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
    }

}
