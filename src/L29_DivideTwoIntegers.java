// 29. Divide Two Integers

public class L29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // handle corner case: dividend = -2147483648 and divisor = -1
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int res = 0, a = Math.abs(dividend), b = Math.abs(divisor);
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) {
                res += 1 << i;
                a -= b << i;
            }
        }

        // can not check dividend * divisor
        return (dividend > 0) != (divisor > 0) ? -res : res;
    }
}
