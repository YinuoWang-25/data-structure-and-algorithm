// 684. Redundant Connection

public class L684_RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] fathers = new int[edges.length + 1];

        for (int[] edge : edges) {
            int u = find(fathers, edge[0]);
            int v = find(fathers, edge[1]);
            if (u == v) return edge;
            fathers[u] = v;
        }

        return new int[0];
    }

    private int find(int[] fathers, int v) {

        return fathers[v] == 0 ? v : find(fathers, fathers[v]);
    }
}
