package example1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2, warmups = 3)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 2)
public class InliningBenchmark {

    public List<Integer> list;
    public Map<Integer, Integer> map;
    private static final float MAXIMUM_LOAD_FACTOR = 0.95f;
    private static final int MULTIPLIER = 2;

    @Param({"120", "12000"})
    int capacity;

    @Setup
    public void init() {
        this.list = new ArrayList<>(capacity);
        this.map = new HashMap<>(capacity*MULTIPLIER, MAXIMUM_LOAD_FACTOR);
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }

    @Benchmark
    public void testIterationsWithLocalVariableListSize(Blackhole bh) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            map.put(list.get(i), listSize);
        }
        bh.consume(map);
    }

    @Benchmark
    public void testIterationsWithListSizeMethodCallStandard(Blackhole bh) {
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), list.size());
        }
        bh.consume(map);
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.INLINE)
    public void testIterationsWithListSizeMethodCallForcedInline(Blackhole bh) {
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), list.size());
        }
        bh.consume(map);
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void testIterationsWithListSizeMethodCallDisabledInline(Blackhole bh) {
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), list.size());
        }
        bh.consume(map);
    }

}
