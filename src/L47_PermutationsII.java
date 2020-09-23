// 47. Permutations II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, boolean[] visited, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                cur.add(nums[i]);
                dfs(res, cur, visited, nums);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
