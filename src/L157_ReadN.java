// 157. Read N Characters Given Read4

import common.Reader4;

public class L157_ReadN extends Reader4 {
    public int read(char[] buf, int n) {
        char[] cache = new char[4];
        int index = 0;
        while (index < n) {
            int size = read4(cache);
            if (size == 0) break;
            for (int j = 0; j < size && index < n; j++) {
                buf[index++] = cache[j];
            }
        }
        return index;
    }
}
