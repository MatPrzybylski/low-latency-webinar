package case3;

import java.util.*;

public class InliningSimpleMain {

    public static void main(String[] args) {

        int capacity = 15_000;
        List<Integer> list = new ArrayList<>(capacity);
        Map<Integer, Integer> mapOne = new HashMap<>(2*capacity, 0.95f);
        Map<Integer, Integer> mapTwo = new HashMap<>(2*capacity, 0.95f);

        //prepare data
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }

        //1st case
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            mapOne.put(i, listSize );
        }

        //2nd case
        for (int i = 0; i < list.size(); i++) {
            mapTwo.put(i, list.size());
        }

        //dead code elimination avoidance
        System.out.println(mapOne);
        System.out.println(mapTwo);

    }
}


//VM args: -XX:+PrintCompilation
//VM args: -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
