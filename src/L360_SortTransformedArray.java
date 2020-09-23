// 360. Sort Transformed Array
/*
We have two pointer i = 0, j = n -1.
Every time we compare value from these two pointers, get the number and put in arr

case 1: a >= 0, we build the array from n - > 0. Every time we chose the bigger number
case 2: a < 0, we build the array from 0 -> n. Every time we chose the smaller number
 */

public class L360_SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1, index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            int left = quad(nums[i], a, b, c);
            int right = quad(nums[j], a, b, c);
            if (a >= 0) {
                if (left >= right) {
                    sorted[index--] = left;
                    i++;
                } else {
                    sorted[index--] = right;
                    j--;
                }
            } else {
                if (left >= right) {
                    sorted[index++] = right;
                    j--;
                } else {
                    sorted[index++] = left;
                    i++;
                }
            }
        }
        return sorted;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
