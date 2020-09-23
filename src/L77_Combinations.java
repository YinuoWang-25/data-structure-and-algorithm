// 77. Combinations

import java.util.ArrayList;
import java.util.List;

public class L77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        helper(rst, new ArrayList<>(), n, k, 1);
        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> solution,
                        int n, int k, int start) {
        if (solution.size() == k) {
            rst.add(new ArrayList(solution));
            return;
        }
        for (int i = start; i <= n; i++) {
            solution.add(i);
            helper(rst, solution, n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
