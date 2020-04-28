package example100;

import org.agrona.collections.IntArrayList;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, warmups = 3)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 2)
public class ListPresizingBenchmark {

    public List<Integer> normalArrayList;
    public List<Integer> presizedArrayList;
    public IntArrayList normalIntArrayList;
    public IntArrayList presizedIntArrayList;

    int capacity = 100;

    @Setup
    public void init() {
        this.normalArrayList = new ArrayList<>();
        this.presizedArrayList = new ArrayList<>(capacity);
        this.normalIntArrayList = new IntArrayList();
        this.presizedIntArrayList = new IntArrayList(capacity, 0);
        for (int i = 0; i < capacity; i++) {
            normalArrayList.add(i);
            normalIntArrayList.addInt(i);
            presizedArrayList.add(i);
            presizedIntArrayList.addInt(i);
        }
    }

    @Benchmark
    public void testAddWithoutPresizingToArrayList(Blackhole bh) {
        for (int i = 0; i < capacity; i++) {
            bh.consume(normalArrayList.get(i));
        }
    }

    @Benchmark
    public void testAddWithoutPresizingToIntArrayList(Blackhole bh) {
        for (int i = 0; i < capacity; i++) {
            bh.consume(normalIntArrayList.get(i));
        }
    }

   @Benchmark
    public void testAddWithPresizingToArrayList(Blackhole bh) {
        for (int i = 0; i < capacity; i++) {
            bh.consume(presizedArrayList.get(i));
        }
    }

    @Benchmark
    public void testAddWithPresizingToIntArrayList(Blackhole bh) {
        for (int i = 0; i < capacity; i++) {
            bh.consume(presizedIntArrayList.get(i));
        }
    }

}
