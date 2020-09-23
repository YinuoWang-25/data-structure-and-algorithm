// Fraction to Recurring Decimal
/*
1. Deal with Sign
2. Deal with part bigger then zero
3. Deal with .
4. Deal with recurring part
    a. use a map to store numerator as repetition of same numerator will cause recurring
    b. for every remaining:
        1. check whether in map
            case 1: found remaining part, build solution and return
            case 2: no, put (remaining, len of result) in map
        2. deal with current digit
 */

import java.util.HashMap;
import java.util.Map;

public class L166_FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();

        // 1. Deal with Sign
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";

        // 2. Deal with part bigger then zero
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long rem = num % den;
        if (rem == 0)
            return result.toString();

        // deal with .
        result.append(".");

        // Deal with recurring part
        Map<Long, Integer> map = new HashMap();
        while (rem != 0) {
            // check whether in map
            if (!map.containsKey(rem)) {
                map.put(rem, result.length());
            } else {
                int idx = map.get(rem);
                return result.substring(0, idx) + "(" + result.substring(idx) + ")";
            }
            // deal with current digit
            rem *= 10;
            result.append(rem / den);
            rem = rem % den;
        }
        return result.toString();
    }
}
