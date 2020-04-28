package example4;

public class StringHolder {

    private AlphabetLibrary alphabetLibrary = new AlphabetLibrary();

    private class AlphabetLibrary {
        private final int ALFA_OFFSET = 0;
        private final int ALFA_LENGTH = 4;
        private final int BRAVO_OFFSET = 4;
        private final int BRAVO_LENGTH = 5;
        private final int CHARLIE_OFFSET = 9;
        private final int CHARLIE_LENGTH = 7;
        private final int DELTA_OFFSET = 16;
        private final int DELTA_LENGTH = 5;
        private final int ECHO_OFFSET = 21;
        private final int ECHO_LENGTH = 4;
        private final byte[] BUFFER = initialize();
    }

    public class MyStringBuffer {

        private int offset, length;

        MyStringBuffer(int offset, int length) {
            this.offset = offset;
            this.length = length;
        }

        @Override
        public String toString() {
            return new String(alphabetLibrary.BUFFER, offset, length);
        }
    }

    private byte[] extractBytes(byte[] buffer, int offset, int length) {
        byte[] newBuffer = new byte[length];
        for (int index = 0; index < length - 1; offset++) {
            newBuffer[index++] = buffer[offset];
        }
        return newBuffer;
    }

    public MyStringBuffer getAlfa() {
        return new MyStringBuffer(alphabetLibrary.ALFA_OFFSET, alphabetLibrary.ALFA_LENGTH);
    }

    public MyStringBuffer getBravo() {
        return new MyStringBuffer(alphabetLibrary.BRAVO_OFFSET, alphabetLibrary.BRAVO_LENGTH);
    }

    public MyStringBuffer getCharlie() {
        return new MyStringBuffer(alphabetLibrary.CHARLIE_OFFSET, alphabetLibrary.CHARLIE_LENGTH);
    }

    public MyStringBuffer getDelta() {
        return new MyStringBuffer(alphabetLibrary.DELTA_OFFSET, alphabetLibrary.DELTA_LENGTH);
    }

    public MyStringBuffer getEcho() {
        return new MyStringBuffer(alphabetLibrary.ECHO_OFFSET, alphabetLibrary.ECHO_LENGTH);
    }

    private byte[] initialize() {
        return "AlfaBravoCharlieDeltaEcho".getBytes();
    }

    @Override
    public String toString() {
        var name = "StringHolder for AlphabetLibrary{" +
                "a=" + getAlfa() +
                ", b=" + getBravo() +
                ", c=" + getCharlie() +
                ", d=" + getDelta() +
                ", e=" + getEcho() +
                '}';
        if (counter > 17)
            messWithBuffer();
        counter++;
        return name;
    }

    private void messWithBuffer() {
        for (int i = 0; i < 1; i++) {
            alphabetLibrary.BUFFER[generateRandomBufferIndex(alphabetLibrary.BUFFER)] = (byte) generateRandomAsciiCode();
        }
    }

    private int generateRandomNumberInRange(int min, int max) {
        int range = (max - min);
        return (int) (Math.random() * range) + min;
    }

    private int generateRandomBufferIndex(byte[] buffer) {
        return generateRandomNumberInRange(0, buffer.length);
    }

    private int generateRandomAsciiCode() {
        return generateRandomNumberInRange('a', 'z');
    }

    private int counter;

}
