// 886. Possible Bipartition

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L886_PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) map.put(i, new ArrayList<>());
        for (int[] dislike : dislikes) {
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        int[] group = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (group[i] == 0 && !dfs(group, i, map, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int[] groups, int index, Map<Integer, List<Integer>> map, int group) {
        if (groups[index] != 0) return groups[index] == group;
        groups[index] = group;
        for (Integer next : map.get(index)) {
            if (!dfs(groups, next, map, -group)) return false;
        }
        return true;
    }
}
