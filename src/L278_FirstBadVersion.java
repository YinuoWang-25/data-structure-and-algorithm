// 278. First Bad Version

public class L278_FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
        return -1;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        // placeholder return value
        return false;
    }
}
