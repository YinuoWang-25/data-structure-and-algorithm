// 785. Is Graph Bipartite?

public class L785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if (!dfs(colors, graph, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[] colors, int[][] graph, int i, int color) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }
        colors[i] = color;
        for (int k = 0; k < graph[i].length; k++) {
            boolean cur = dfs(colors, graph, graph[i][k], -color);
            if (!cur) return false;
        }
        return true;
    }
}
