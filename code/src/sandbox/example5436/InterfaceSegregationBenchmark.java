package example5436;

import example5436.segregation.broken.BrokenPrinciple;
import example5436.segregation.broken.BrokenPrincipleInheritance;
import example5436.segregation.broken.interfaces.A;
import example5436.segregation.good.AbstractSegregationPrinciple;
import example5436.segregation.good.SegregationPrinciple;
import example5436.segregation.good.interfaces.G;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 2)
public class InterfaceSegregationBenchmark {


    private A brokenPrincipleWithInheritance;
    private A brokenPrinciple;
    private AbstractSegregationPrinciple abstractSegregationPrinciple;
    private G interfaceGSegregationPrinciple;

    @Setup
    public void init() {
        this.brokenPrincipleWithInheritance = new BrokenPrincipleInheritance();
        this.brokenPrinciple = new BrokenPrinciple();
        this.abstractSegregationPrinciple = new SegregationPrinciple();
        this.interfaceGSegregationPrinciple = new SegregationPrinciple();
    }

    //number from abstract class
    @Benchmark()
    public void testInterfaceSegregationPrincipleValueFromAbstractClass(Blackhole bh) {
        int number = abstractSegregationPrinciple.getNumberA();
        bh.consume(number);
    }

    //number from interfaceG
    @Benchmark()
    public void testInterfaceSegregationPrincipleValueFromInterfaceG(Blackhole bh) {
        int number = interfaceGSegregationPrinciple.getNumberG();
        bh.consume(number);
    }

    //number from lowest class
    @Benchmark
    public void testBrokenInterfaceSegregationPrincipleValueFromChildClass(Blackhole bh) {
        int number = brokenPrinciple.getNumberA();
        bh.consume(number);
    }

    //number from abstract class
    @Benchmark
    public void testBrokenInterfaceSegregationPrincipleValueFromAbstractClass(Blackhole bh) {
        int number = brokenPrinciple.getNumberAa();
        bh.consume(number);
    }

    //number from child class
    @Benchmark
    public void testBrokenInterfaceSegregationPrincipleWithInterfaceInheritanceValueFromChildClass(Blackhole bh) {
        int number = brokenPrincipleWithInheritance.getNumberA();
        bh.consume(number);
    }

    //number from abstract class
    @Benchmark
    public void testBrokenInterfaceSegregationPrincipleWithInterfaceInheritanceValueFromAbstractClass(Blackhole bh) {
        int number = brokenPrincipleWithInheritance.getNumberAa();
        bh.consume(number);
    }
}
