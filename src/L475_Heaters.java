// 475. Heaters

import java.util.Arrays;

public class L475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int left = 0;
            int right = heaters.length - 1;
            while (left < right - 1) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] == house) {
                    left = mid;
                    break;
                } else if (heaters[mid] < house) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            int cur = Math.min(Math.abs(heaters[left] - house), Math.abs(heaters[right] - house));
            res = Math.max(res, cur);
        }
        return res;
    }
}
