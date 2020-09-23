// 69. Sqrt(x)

public class L69_Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, ans = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x) return mid;
            else if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}
