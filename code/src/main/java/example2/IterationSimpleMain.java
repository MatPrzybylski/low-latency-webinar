package example2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IterationSimpleMain {

    public static void main(String[] args) {

        int capacity = 100;
        List<Integer> list = new ArrayList<>(capacity);
        Map<Integer, Integer> mapOne = new HashMap<>(2 * capacity, 0.95f);
        Map<Integer, Integer> mapTwo = new HashMap<>(2 * capacity, 0.95f);
        Map<Integer, Integer> mapThree;
        Map<Integer, Integer> mapFour;

        //prepare data
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
        int listSize = list.size();
        Function<Integer, Integer> function = (element) -> listSize;

        //1st case
        for (int i = 0; i < listSize; i++) {
            mapOne.put(i, listSize);
        }

        //2nd case
        for (int i : list) {
            mapTwo.put(i, list.size());
        }

        //3rd case
        mapThree = list.stream()
                .collect(Collectors.toMap(
                        Function.identity(), function));

        //4th case
        mapFour = list.stream().parallel()
                .collect(Collectors.toMap(
                        Function.identity(), function));

        //dead code elimination avoidance
        System.out.println(mapOne);
        System.out.println(mapTwo);
        System.out.println(mapThree);
        System.out.println(mapFour);
    }
}
