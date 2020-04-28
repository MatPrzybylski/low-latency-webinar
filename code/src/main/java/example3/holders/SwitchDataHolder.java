package example3.holders;

import example3.data.MyNumber;

public class SwitchDataHolder {

    private MyNumber myNumber_00 = new MyNumber(0);
    private MyNumber myNumber_01 = new MyNumber(1);
    private MyNumber myNumber_02 = new MyNumber(2);
    private MyNumber myNumber_03 = new MyNumber(3);
    private MyNumber myNumber_04 = new MyNumber(4);
    private MyNumber myNumber_05 = new MyNumber(5);
    private MyNumber myNumber_06 = new MyNumber(6);
    private MyNumber myNumber_07 = new MyNumber(7);
    private MyNumber myNumber_08 = new MyNumber(8);
    private MyNumber myNumber_09 = new MyNumber(9);
    private MyNumber myNumber_10 = new MyNumber(10);
    private MyNumber myNumber_11 = new MyNumber(11);
    private MyNumber myNumber_12 = new MyNumber(12);
    private MyNumber myNumber_13 = new MyNumber(13);
    private MyNumber myNumber_14 = new MyNumber(14);
    private MyNumber myNumber_15 = new MyNumber(15);

    public MyNumber getMyNumber(int index) {
        switch (index) {
            case 0:
                return myNumber_00;
            case 1:
                return myNumber_01;
            case 2:
                return myNumber_02;
            case 3:
                return myNumber_03;
            case 4:
                return myNumber_04;
            case 5:
                return myNumber_05;
            case 6:
                return myNumber_06;
            case 7:
                return myNumber_07;
            case 8:
                return myNumber_08;
            case 9:
                return myNumber_09;
            case 10:
                return myNumber_10;
            case 11:
                return myNumber_11;
            case 12:
                return myNumber_12;
            case 13:
                return myNumber_13;
            case 14:
                return myNumber_14;
            case 15:
                return myNumber_15;
            default:
                return null;
        }
    }

    public MyNumber getMyNumberWithJDK13SwitchExpression(int index) {
        return switch (index) {
            case 0 -> myNumber_00;
            case 1 -> myNumber_01;
            case 2 -> myNumber_02;
            case 3 -> myNumber_03;
            case 4 -> myNumber_04;
            case 5 -> myNumber_05;
            case 6 -> myNumber_06;
            case 7 -> myNumber_07;
            case 8 -> myNumber_08;
            case 9 -> myNumber_09;
            case 10 -> myNumber_10;
            case 11 -> myNumber_11;
            case 12 -> myNumber_12;
            case 13 -> myNumber_13;
            case 14 -> myNumber_14;
            case 15 -> myNumber_15;
            default -> null;
        };
    }
}

