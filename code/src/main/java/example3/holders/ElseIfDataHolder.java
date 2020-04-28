package example3.holders;

import example3.data.MyNumber;

public class ElseIfDataHolder {

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
        if (index == 0) {
            return myNumber_00;
        } else if (index == 1) {
            return myNumber_01;
        } else if (index == 2) {
            return myNumber_02;
        } else if (index == 3) {
            return myNumber_03;
        } else if (index == 4) {
            return myNumber_04;
        } else if (index == 5) {
            return myNumber_05;
        } else if (index == 6) {
            return myNumber_06;
        } else if (index == 7) {
            return myNumber_07;
        } else if (index == 8) {
            return myNumber_08;
        } else if (index == 9) {
            return myNumber_09;
        } else if (index == 10) {
            return myNumber_10;
        } else if (index == 11) {
            return myNumber_11;
        } else if (index == 12) {
            return myNumber_12;
        } else if (index == 13) {
            return myNumber_13;
        } else if (index == 14) {
            return myNumber_14;
        } else if (index == 15) {
            return myNumber_15;
        } else {
            return null;
        }
    }
}
