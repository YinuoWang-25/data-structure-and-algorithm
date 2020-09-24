// 491. Increasing Subsequences
/*
Because the array nums is not sorted, we use a set to keep all used number in this level
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L491_IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {

        if (cur.size() >= 2) {
            res.add(new ArrayList<>(cur));
        }
        // deduplicate
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (cur.size() == 0 || nums[i] >= cur.get(cur.size() - 1)) {
                used.add(nums[i]);
                cur.add(nums[i]);
                dfs(res, cur, nums, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
