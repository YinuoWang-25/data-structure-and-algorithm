// 1313. Decompress Run-Length Encoded List

import java.util.ArrayList;
import java.util.List;

public class L1313_DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int times = nums[i];
            while (times > 0) {
                res.add(nums[i + 1]);
                times--;
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
