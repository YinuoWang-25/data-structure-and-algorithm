import java.util.HashMap;
import java.util.Map;

// 788. Rotated Digits
/*
    DP solution: base case is one digit: 0 - 10
    dp[i] = 0, invalid number
    dp[i] = 1, valid and same number
    dp[i] = 2, valid and different number
 */
public class L788_RotatedDigits {

    /** DP solution [the one is most fast] */
    public int rotatedDigitsI(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if (a == 1 && b == 1) dp[i] = 1;
                else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }


    /** basic solution */
    public int rotatedDigitsII(int N) {
        int res = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('2', '5');
        map.put('5', '2');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        for (int i = 1; i<= N; i++) {
            if (isValid(i, map)) {
                res++;
            }
        }
        return res;
    }
    private boolean isValid(int num, Map<Character, Character> map) {
        char[] chs = Integer.toString(num).toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!map.containsKey(chs[i])) return false;
            chs[i] = map.get(chs[i]);
        }
        return Integer.parseInt(new String(chs)) != num;
    }
}
