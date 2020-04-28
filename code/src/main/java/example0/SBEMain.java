package example0;

public class SBEMain {

    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Binary representation of Integer.MAX_VALUE: " +
                Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Binary representation of Integer.MIN_VALUE: " +
                Integer.toBinaryString(Integer.MIN_VALUE));

        System.out.println("Binary representation of 4 000 000 000: "
                + Long.toBinaryString(4_000_000_000L));
        System.out.println("Binary representation of -4 000 000 000: "
                + Long.toBinaryString(-4_000_000_000L));

        System.out.println("Binary representation of -294 967 296: " +
                Integer.toBinaryString(-294_967_296));

        System.out.println(Long.toBinaryString(4_000_000_000L).equals(Integer.toBinaryString(-294_967_296)));

        System.out.println("UnsignedInt value of (-294 967 296) as Java long: " + Integer.toUnsignedLong(-294967296));
        System.out.println("UnsignedInt value of (-294 967 296) as Java long: " + ((-294967296) & 0xffffffffL));

        System.out.println("UnsignedInt value of (-18) as Java long: " + Byte.toUnsignedInt((byte) -18));
        System.out.println("UnsignedInt value of (-18) as Java long: " + (((byte) (-18)) & 0xff));
        System.out.println("UnsignedInt value of (-18) as bits: " + Integer.toBinaryString((((byte) (-18)) & 0xff)));

        System.out.println(Integer.toBinaryString(Byte.toUnsignedInt((byte) -1)));
        System.out.println(Integer.toBinaryString(-128));

        System.out.println(Integer.toBinaryString(0xff));
        System.out.println("4 bytes sent over TCP : " + Integer.toUnsignedLong(-1));
        System.out.println("4 bytes sent over TCP : " + (Integer.MAX_VALUE & 0x7fffffff));
        System.out.println("4 bytes sent over TCP : " + (Integer.MIN_VALUE & 0x7fffffff));
        System.out.println("4 bytes sent over TCP : " + (Integer.toBinaryString((-1) & 0xff)));
        System.out.println("4 bytes sent over TCP : " + Integer.toUnsignedLong(-1));
        System.out.println("4 bytes sent over TCP : " + Long.toBinaryString(Integer.toUnsignedLong(-1)));
        System.out.println("4 bytes sent over TCP : " + Integer.toUnsignedLong(-294967296));
        System.out.println("4 bytes sent over TCP : " + Integer.toBinaryString(-294967296));
    }
}
