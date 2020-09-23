// 685. Redundant Connection II
/*

case 1 : redundant connection from one node to root, can delete random one edge in circle
                                                    5 <- 1 -> 2
                                                         ^    |
                                                         |    v
                                                        4  <- 3

case 2 : Redundant connection from one node to non-root ancestor. need to delete edge in circle
                                                    5 <- 1 -> 2
                                                              |
                                                              v
                                                           ->
                                                        4  <- 3

case 3: Redundant connection from one node to non-ancestor node
                                                    5 <- 1 -> 2
                                                     \        |
                                                      \       v
                                                        4  <- 3

 */

public class L685_RedundantConnectionII {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] roots = new int[edges.length + 1];
        int[] candidate1 = null;
        int[] candidate2 = null;
        for (int[] edge : edges) {
            int father = edge[0];
            int child = edge[1];
            if (roots[child] != 0) {
                candidate2 = new int[]{father, child};
                candidate1 = new int[]{roots[child], child};
                edge[1] = 0;
            } else {
                roots[child] = father;
            }
        }

        int[] fathers = new int[edges.length + 1];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }

        for (int[] edge : edges) {
            int f = find(fathers, edge[0]);
            int c = find(fathers, edge[1]);
            if (f == c) {
                // case 1 is cared
                if (candidate1 == null) {
                    return edge;
                } else {
                    // case 2 is cared when candidate1 is in circle
                    return candidate1;
                }
            }
            fathers[f] = c;
        }

        // case 3 is cared. Or case 2 is cared when candidate2 is in circle
        return candidate2;
    }

    private int find(int[] fathers, int x) {
        if (fathers[x] == x) return x;
        fathers[x] = find(fathers, fathers[x]);
        return fathers[x];
    }
}
