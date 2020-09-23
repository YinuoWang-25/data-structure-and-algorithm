// 733. Flood Fill

public class L733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc], new boolean[image.length][image[0].length]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int originColor, boolean[][] visited) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != originColor || visited[i][j]) {
            return;
        }
        image[i][j] = newColor;
        visited[i][j] = true;
        dfs(image, i + 1, j, newColor, originColor, visited);
        dfs(image, i - 1, j, newColor, originColor, visited);
        dfs(image, i, j + 1, newColor, originColor, visited);
        dfs(image, i, j - 1, newColor, originColor, visited);
    }
}
