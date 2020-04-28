package example0;

import java.util.ArrayList;
import java.util.List;

public class BadBenchmark {

    public static void main(String[] args) {

        final int NUMBER_OF_ELEMENTS = 5000;
        List<Integer> normalList = new ArrayList<>();
        List<Integer> presizedList = new ArrayList<>(NUMBER_OF_ELEMENTS);

        long startTime = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            presizedList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Iteration for presizedList took " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            normalList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Iteration for normalList took " + (endTime - startTime) + " nanoseconds");
    }

}
