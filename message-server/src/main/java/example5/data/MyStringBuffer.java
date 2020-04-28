package example5.data;

import java.util.Arrays;
import java.util.Objects;

public class MyStringBuffer {

    private int offset;
    private int length;
    private byte[] buffer = new byte[64];

    public MyStringBuffer(byte[] buffer, int offset, int length) {
        System.arraycopy(buffer, 0, this.buffer, 0, length);
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
                compareArrays(that);
    }

    private boolean compareArrays(MyStringBuffer that) {
        byte[] smallerArray;
        byte[] biggerArray;
        int smallerLength;

        if (this.length > that.length) {
            biggerArray = this.buffer;
            smallerArray = that.buffer;
            smallerLength = that.length;
        } else {
            biggerArray = that.buffer;
            smallerArray = this.buffer;
            smallerLength = this.length;
        }

        for (int i = 0; i < smallerLength; i++) {
            if (this.buffer[i] != that.buffer[i]) {
                return false;
            }
        }

        for (int i = smallerLength; i < biggerArray.length; i++) {
            if (biggerArray[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(offset, length);
        result = 31 * result + Arrays.hashCode(buffer);
        return result;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        System.arraycopy(buffer, 0, this.buffer, 0, buffer.length);
    }

    public void reset() {
        this.offset = 0;
        this.length = 0;
        clearBuffer();
        //buffer not cleaned - that's the whole point of the example
    }

    private void clearBuffer() {
        for (int i = 0; i < this.length; i++) {
            this.buffer[i] = 0;
        }
    }
}
