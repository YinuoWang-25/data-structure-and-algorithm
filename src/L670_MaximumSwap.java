// 670. Maximum Swap

/**
 * 1. map every number's last index to buckets. We use last index here because for the bigger digit, we always
 * want to swap the last one to make the change minimum
 * 2. from left to right, find the first digit d who:
 * a. has a bigger digit
 * b. the digit's index > d's index
 */
public class L670_MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) buckets[digits[i] - '0'] = i;

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
