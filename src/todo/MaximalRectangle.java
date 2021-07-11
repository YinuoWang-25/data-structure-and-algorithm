package todo;

public class MaximalRectangle {
    // 85. Maximal Rectangle
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;

                while (!stack.isEmpty() && height[j] <= height[stack.peekFirst()]) {
                    int pop = stack.pollFirst();
                    int width = stack.isEmpty() ? j : j - 1 - stack.peekFirst();
                    maxArea = Math.max(maxArea, height[pop] * width);
                }

                stack.offerFirst(j);
            }
            while (!stack.isEmpty()) {
                int pop = stack.pollFirst();
                int width = stack.isEmpty() ? height.length : height.length - 1 - stack.peekFirst();
                maxArea = Math.max(maxArea, height[pop] * width);
            }
        }
        return maxArea;
    }
}
