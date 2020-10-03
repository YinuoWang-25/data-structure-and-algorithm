// 1151. Minimum Swaps to Group All 1's Together
public class L1151_GroupAllOne {
    public int minSwaps(int[] data) {
        int count = 0, res = data.length + 1, all = 0;
        for (int d : data) if (d == 1) all++;
        if (all == 0) return 0;
        for (int right = 0; right < data.length; right++) {
            if (data[right] == 1) count++;
            if (right >= all - 1) {
                res = Math.min(res, all - count);
                if (data[right - all + 1] == 1) count--;
            }
        }
        return res;
    }
}
