// 386. Lexicographical Numbers

import java.util.ArrayList;
import java.util.List;

public class L386_LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(res, 0, n);
        return res;
    }

    private void dfs(List<Integer> res, int cur, int n) {
        if (cur > n) return;
        if (cur > 0) res.add(cur);
        for (int i = 0; i <= 9; i++) {
            if (cur == 0 && i == 0) continue;
            dfs(res, cur * 10 + i, n);
        }
    }
}
