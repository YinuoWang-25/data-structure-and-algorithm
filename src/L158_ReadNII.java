// 158. Read N Characters Given Read4 II - Call multiple times

/*
    head: first character to read
    tail: no character to read
 */

import common.Reader4;

public class L158_ReadNII extends Reader4 {
    char[] cache = new char[4];
    int head = 0;
    int tail = 0;

    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            // no cache left, need to fetch data again
            if (head == tail) {
                head = 0;
                tail = read4(cache);
                if (tail == 0) break;
            }
            while (index < n && head != tail) {
                buf[index++] = cache[head++];
            }
        }
        return index;
    }
}
