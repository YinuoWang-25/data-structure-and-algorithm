// 216. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class L216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 1, k, n);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> cur, int start, int k, int n) {
        if (k < 0 || n < 0) {
            return;
        }
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n >= i && k > 0) {
                cur.add(i);
                dfs(ans, cur, i + 1, k - 1, n - i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
