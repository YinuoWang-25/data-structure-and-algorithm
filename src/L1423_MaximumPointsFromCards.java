// 1423. Maximum Points You Can Obtain from Cards
/*
Intuition: we grab k continuous card from beginning and end

 */

public class L1423_MaximumPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int max, sum = 0;
        for (int i = 0; i < k; i++) sum += cardPoints[i];
        max = sum;
        for (int i = 1; i <= k; i++) {
            sum = sum + cardPoints[cardPoints.length - i] - cardPoints[k - i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
