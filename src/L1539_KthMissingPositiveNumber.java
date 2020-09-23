// 1539. Kth Missing Positive Number

public class L1539_KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - mid - 1 < k) l = mid + 1;
            else r = mid;
        }
        return l + k;
    }
}
