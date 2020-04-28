package example5.data;

import java.util.Arrays;
import java.util.Objects;

public class MyStringBuffer {

    private int offset;
    private int length;
    private byte[] buffer = new byte[64];

    public MyStringBuffer(byte[] buffer, int offset, int length) {
        copyArray(buffer, length);
        this.offset = offset;
        this.length = length;
    }

    @Override
    public String toString() {
        return new String(buffer, offset, length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStringBuffer that = (MyStringBuffer) o;
        return offset == that.offset &&
                length == that.length &&
                Arrays.equals(buffer, that.buffer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(offset, length);
        result = 31 * result + Arrays.hashCode(buffer);
        return result;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public void setBuffer(byte[] buffer) {
        copyArray(buffer);
    }

    private void copyArray(byte[] src, int length) {
        for (int i = 0; i < length; i++) {
            this.buffer[i] = src[i];
        }
    }

    private void copyArray(byte[] src) {
        copyArray(src, this.length);
    }

    public void reset() {
        this.offset = 0;
        this.length = 0;
        clearBuffer();
    }

    private void clearBuffer() {
        for (int i = 0; i < this.length; i++) {
            this.buffer[i] = 0;
        }
    }
}
