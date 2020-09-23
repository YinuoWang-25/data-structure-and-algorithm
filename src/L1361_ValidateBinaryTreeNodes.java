// 1361. Validate Binary Tree Nodes

public class L1361_ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 && inDegree[leftChild[i]]++ == 1) return false;
            if (rightChild[i] != -1 && inDegree[rightChild[i]]++ == 1) return false;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1) return false; // Multiple root
                root = i;
            }
        }
        if (root == -1) return false;
        boolean[] visited = new boolean[n];
        boolean res = dfs(root, leftChild, rightChild, visited);
        if (res) {
            for (boolean v : visited) { //check if all nodes are visited
                if (!v) return false;
            }
            return true;
        } else return false;
    }

    boolean dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (root == -1) return true;
        if (visited[root]) return false;
        visited[root] = true;
        return dfs(leftChild[root], leftChild, rightChild, visited)
                && dfs(rightChild[root], leftChild, rightChild, visited);
    }
}
