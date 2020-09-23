// 228. Summary Ranges

import java.util.ArrayList;
import java.util.List;

public class L228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right + 1 < nums.length && nums[right + 1] == nums[right] + 1) {
                right++;
            }
            if (left == right) {
                ans.add(nums[left] + "");
            } else {
                ans.add(nums[left] + "->" + nums[right]);
            }
            left = right + 1;
            right = left;
        }
        return ans;
    }
}
