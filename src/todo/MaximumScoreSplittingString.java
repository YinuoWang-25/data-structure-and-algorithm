package todo;

public class MaximumScoreSplittingString {
    public int maxScore(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int[] zeros = new int[chs.length];
        zeros[0] = chs[0] == '0' ? 1 : 0;
        int[] ones = new int[chs.length];
        ones[ones.length - 1] = chs[ones.length - 1] == '1' ? 1 : 0;
        for (int i = 1 ; i < chs.length; i++) {
            if (chs[i] == '0') {
                zeros[i] = zeros[i-1] + 1;
            } else {
                zeros[i] = zeros[i-1] ;
            }
        }
        for (int i = chs.length - 2  ; i >= 0; i--) {
            if (chs[i] == '1') {
                ones[i] = ones[i + 1] + 1;
            } else {
                ones[i] = ones[i+1] ;
            }
        }
        int res = 0;
        for (int i = 1 ; i < chs.length; i++) {
            int cur = zeros[i-1] + ones[i];
            res = Math.max(res, cur);
        }
        return res;

    }
}
