// 821. Shortest Distance to a Character

import java.util.Arrays;

public class L821_ShortestDistanceCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        Arrays.fill(res, S.length());
        int prev = -1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                prev = i;
                res[i] = 0;
            } else {
                if (prev != -1) {
                    res[i] = i - prev;
                }
            }
        }
        prev = S.length();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                prev = i;
                res[i] = 0;
            } else {
                if (prev < S.length()) {
                    res[i] = Math.min(res[i], prev - i);
                }
            }
        }
        return res;
    }
}
