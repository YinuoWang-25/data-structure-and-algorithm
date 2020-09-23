package todo;

public class HIndexII {
    // 275. H-Index II
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations.length - mid == citations[mid]) {
                return citations.length - mid;
            } else if (citations.length - mid > citations[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return citations.length - left;
    }
}
