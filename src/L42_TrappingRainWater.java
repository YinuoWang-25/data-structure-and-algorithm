// 42. Trapping Rain Water

public class L42_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int left = 0, right = height.length - 1, leftMost = height[0], rightMost = height[height.length - 1], res = 0;
        while (left <= right) {
            if (leftMost <= rightMost) {
                res += Math.max(leftMost - height[left], 0);
                leftMost = Math.max(leftMost, height[left]);
                left++;
            } else {
                res += Math.max(rightMost - height[right], 0);
                rightMost = Math.max(rightMost, height[right]);
                right--;
            }
        }
        return res;
    }
}
