// 836. Rectangle Overlap

/**
 * Two rectangles are overlapped with each other if:
 * 1. maxLeft < minRight
 * 2. maxBottom < minTop
 */

public class L836_RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int maxLeft = Math.max(rec1[0], rec2[0]);
        int minRight = Math.min(rec1[2], rec2[2]);
        if (maxLeft >= minRight) return false;

        int maxBottom = Math.max(rec1[1], rec2[1]);
        int minTop = Math.min(rec1[3], rec2[3]);
        return maxBottom < minTop;
    }
}
