package org.pg.march.lc.file;

/*
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-
 * times/ The read4 API is defined in the parent class Reader4. int read4(char[]
 * buf);
 */
public class ReadNCharactersGivenRead4_II {

    char[] stream = new char[5];
    private int bufferStart;
    private int bufferEnd;

    /**
     * @param buf Destination buffer
     * @param n Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int pos = readFromLocalBuffer(buf, 0, n);
        while (pos < n && readFromFile() > 0) {
            pos = readFromLocalBuffer(buf, pos, n);
        }
        return pos;
    }

    private int readFromLocalBuffer(char[] buf, int pos, int n) {
        while (bufferStart < bufferEnd && pos < n) {
            buf[pos++] = stream[bufferStart++];
        }
        if (bufferStart != 0 && bufferStart == bufferEnd) {
            bufferStart = 0;
            bufferEnd = 0;
        }
        return pos;
    }

    private int readFromFile() {
        if (bufferStart != 0 && bufferEnd != 0) {
            throw new IllegalStateException("Buffer should be reset before reading from file");
        }
        bufferEnd = read4(stream);
        return bufferEnd;
    }

    public int read4(char[] buf) {
        return 0;
    }
}
