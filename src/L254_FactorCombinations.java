// 254. Factor Combinations

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L254_FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) return res;
        dfs(res, new ArrayList<>(), n, 2);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int n, int start) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                cur.add(i);
                cur.add(n / i);
                res.add(new LinkedList<>(cur));
                cur.remove(cur.size() - 1);
                dfs(res, cur, n / i, i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
