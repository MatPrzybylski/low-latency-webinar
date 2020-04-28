package profiling1;

import org.agrona.collections.IntArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListPresizingProfiling {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        ListPresizingProfiling profiling = new ListPresizingProfiling();
        int increment = 0;
        int capacity = 100;

        increment = profiling.arrayList(in, increment, capacity);
        increment = profiling.intArrayList(in, increment, capacity);
        increment = profiling.presizedArrrayList(in, increment, capacity);
        increment = profiling.presizedIntArray(in, increment, capacity);

        profiling.pauseForProfiler(in);
    }

    void pauseForProfiler(Scanner in) {
        while (true) {
            String input = in.nextLine();
            if ("go".equalsIgnoreCase(input)) {
                break;
            }
        }
    }

    int arrayList(Scanner in, int increment, int capacity) throws Exception {
        pauseForProfiler(in);
        //Thread.sleep(10000);
        System.out.println("ArrayList");
        List<Integer> arrayList = new ArrayList<>();

        //ArrayList
        for (int i = increment, j = 0; j < capacity; j++, increment++) {
            arrayList.add(i);
        }
        System.out.println(increment);
        return increment;
    }

    int intArrayList(Scanner in, int increment, int capacity) throws Exception {
        //Thread.sleep(2000);
        pauseForProfiler(in);
        System.out.println("IntArrayList");
        IntArrayList intArrayList = new IntArrayList();

        //IntArrayList
        for (int i = increment, j = 0; j < capacity; j++, increment++) {
            intArrayList.addInt(i);
        }
        System.out.println(increment);
        return increment;
    }

    int presizedArrrayList(Scanner in, int increment, int capacity) throws Exception {
        //Thread.sleep(2000);
        pauseForProfiler(in);
        System.out.println("PresizedArrayList");
        List<Integer> presizedArrayList = new ArrayList<>(capacity);

        //PresizedArrayList
        for (int i = increment, j = 0; j < capacity; j++, increment++) {
            presizedArrayList.add(i);
        }
        System.out.println(increment);
        return increment;
    }

    int presizedIntArray(Scanner in, int increment, int capacity) throws Exception {
        //Thread.sleep(2000);
        pauseForProfiler(in);
        System.out.println("PresizedIntArrayList");
        IntArrayList presizedIntArrayList = new IntArrayList(capacity, 0);

        //PresizedIntArrayList
        for (int i = increment, j = 0; j < capacity; j++, increment++) {
            presizedIntArrayList.addInt(i);
        }
        System.out.println(increment);
        return increment;
    }
}
