package example2;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, warmups = 3)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 2)
public class IterationBenchmark {

    public List<Integer> list;
    public Map<Integer, Integer> map;
    private static final float MAXIMUM_LOAD_FACTOR = 0.95f;
    private static final int MULTIPLIER = 2;

    @Param({"120", "12000"})
    int capacity;

    @Param({"120", "12000"})
    int flowCounter;

    @Setup
    public void init() {
        this.list = new ArrayList<>(capacity);
        this.map = new HashMap<>(capacity * MULTIPLIER, MAXIMUM_LOAD_FACTOR);
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }

    @Benchmark
    public void testIterationWithForLoop(Blackhole bh) {
        for (int i = 0; i < flowCounter; i++) {
            map = forIteration();
        }
        bh.consume(map);
    }

    @Benchmark
    public void testIterationWithForeachLoop(Blackhole bh) {
        for (int i = 0; i < flowCounter; i++) {
            map = foreachIteration();
        }
        bh.consume(map);
    }

    @Benchmark
    public void testIterationWithStream(Blackhole bh) {
        for (int i = 0; i < flowCounter; i++) {
            map = streamIteration();
        }
        bh.consume(map);
    }

    @Benchmark
    public void testIterationWithParallelStream(Blackhole bh) {
        for (int i = 0; i < flowCounter; i++) {
            map = parallelStreamIteration();
        }
        bh.consume(map);
    }

    private Map<Integer, Integer> forIteration() {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            map.put(list.get(i), listSize);
        }
        return map;
    }

    private Map<Integer, Integer> foreachIteration() {
        for (int i : list) {
            map.put(list.get(i), list.size());
        }
        return map;
    }

    private Map<Integer, Integer> streamIteration() {
        final int listSize = list.size();
        Function<Integer, Integer> function = (element) -> listSize;
        return list.stream()
                .collect(Collectors.toMap(
                        Function.identity(), function));
    }

    private Map<Integer, Integer> parallelStreamIteration() {
        final int listSize = list.size();
        Function<Integer, Integer> function = (element) -> listSize;
        return list.stream().parallel()
                .collect(Collectors.toMap(
                        Function.identity(), function));
    }
}
