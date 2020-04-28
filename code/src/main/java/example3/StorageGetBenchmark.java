package example3;

import example3.data.MyNumber;
import example3.data.MyNumberEnum;
import example3.holders.ElseIfDataHolder;
import example3.holders.SwitchDataHolder;
import org.agrona.collections.Int2ObjectHashMap;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, warmups = 3)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 2)
public class StorageGetBenchmark {

    private EnumMap<MyNumberEnum, MyNumber> enumMap;
    private HashMap<Integer, MyNumber> hashMap;
    private Int2ObjectHashMap<MyNumber> int2ObjectHashMap;
    private ArrayList<MyNumber> arrayList;
    private MyNumber[] array;
    private ElseIfDataHolder elseIfDataHolder;
    private SwitchDataHolder switchDataHolder;
    private MyNumberEnum calculatedEnumKey;

    @Param({"1", "11", "15"})
    int index;

    @Setup
    public void init() {
        this.hashMap = prepareHashMap();
        this.int2ObjectHashMap = prepareInt2ObjHashMap();
        this.enumMap = prepareEnumMap();
        this.elseIfDataHolder = new ElseIfDataHolder();
        this.switchDataHolder = new SwitchDataHolder();
        this.arrayList = prepareArrayList();
        this.array = prepareArray();
        this.calculatedEnumKey = MyNumberEnum.values()[index];
    }

    @Benchmark
    public void testEnumMapGet(Blackhole bh) {
        MyNumber myNumber = enumMap.get(calculatedEnumKey);
        bh.consume(myNumber);
    }

    @Benchmark
    public void testHashMapGet(Blackhole bh) {
        MyNumber myNumber = hashMap.get(index);
        bh.consume(myNumber);
    }

    @Benchmark
    public void testInt2ObjHashMapGet(Blackhole bh) {
        MyNumber myNumber = int2ObjectHashMap.get(index);
        bh.consume(myNumber);
    }

    @Benchmark
    public void testElseIfGet(Blackhole bh) {
        MyNumber myNumber = elseIfDataHolder.getMyNumber(index);
        bh.consume(myNumber);
    }

    @Benchmark
    public void testSwitchGet(Blackhole bh) {
        MyNumber myNumber = switchDataHolder.getMyNumber(index);
        bh.consume(myNumber);
    }

    @Benchmark
    public void testJDK13SwitchGet(Blackhole bh) {
        MyNumber myNumber = switchDataHolder.getMyNumberWithJDK13SwitchExpression(index);
        bh.consume(myNumber);
    }

    @Benchmark
    public void testArrayListGet(Blackhole bh) {
        MyNumber myNumber = arrayList.get(index);
        bh.consume(myNumber);
    }

    @Benchmark
    public void testArrayGet(Blackhole bh) {
        MyNumber myNumber = array[index];
        bh.consume(myNumber);
    }

    private EnumMap<MyNumberEnum, MyNumber> prepareEnumMap() {
        EnumMap<MyNumberEnum, MyNumber> enumMap = new EnumMap<>(MyNumberEnum.class);
        for (MyNumberEnum myEnum : MyNumberEnum.values()) {
            enumMap.put(myEnum, myEnum.getMyNumber());
        }
        return enumMap;
    }

    private HashMap<Integer, MyNumber> prepareHashMap() {
        HashMap<Integer, MyNumber> hashMap = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            hashMap.put(i, new MyNumber(i));
        }
        return hashMap;
    }

    private Int2ObjectHashMap<MyNumber> prepareInt2ObjHashMap() {
        Int2ObjectHashMap<MyNumber> int2ObjectHashMap = new Int2ObjectHashMap<>();
        for (int i = 0; i < 16; i++) {
            int2ObjectHashMap.put(i, new MyNumber(i));
        }
        return int2ObjectHashMap;
    }

    private ArrayList<MyNumber> prepareArrayList() {
        ArrayList<MyNumber> arrayList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            arrayList.add(new MyNumber(i));
        }
        return arrayList;
    }

    private MyNumber[] prepareArray() {
        MyNumber[] array = new MyNumber[16];
        for (int i = 0; i < 16; i++) {
            array[i] = new MyNumber(i);
        }
        return array;
    }

}
