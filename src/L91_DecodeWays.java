// 91. Decode Ways

public class L91_DecodeWays {
    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int l = chs.length;
        if (l == 0) {
            return 0;
        }
        int[] f = new int[l + 1];
        f[0] = 1;

        for (int i = 1; i <= l; i++) {
            if (chs[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i >= 2) {
                int val2 = (chs[i - 2] - '0') * 10 + chs[i - 1] - '0';
                if (10 <= val2 && val2 <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[l];
    }
}
