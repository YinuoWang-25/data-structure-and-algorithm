// 13. Roman to Integer
/*
For every digit a, we just need to compare it with next digit b:
    case 1: a < b, we need to subtract a from res
    case 2: a >= b, we need to add a to res
 */

import java.util.HashMap;
import java.util.Map;

public class L13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || m.get(s.charAt(i)) >= m.get(s.charAt(i + 1))) {
                res += m.get(s.charAt(i));
            } else {
                res -= m.get(s.charAt(i));
            }
        }
        return res;
    }
}
