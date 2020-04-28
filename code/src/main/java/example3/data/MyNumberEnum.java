package example3.data;

public enum MyNumberEnum {
    NR_1(1), NR_2(2), NR_3(3), NR_4(4), NR_5(5), NR_6(6), NR_7(7), NR_8(8),
    NR_9(9), NR_10(10), NR_11(11), NR_12(12), NR_13(13), NR_14(14), NR_15(15), NR_16(16);

    MyNumberEnum(int number) {
        this.myNumber = new MyNumber(number);
    }

    private MyNumber myNumber;

    public MyNumber getMyNumber() {
        return myNumber;
    }
}
