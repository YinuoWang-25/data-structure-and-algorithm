package todo;

public class KokoEatingBananas {
    // 875. Koko Eating Bananas
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = getMaxPile(piles);

        while (lo < hi) {
            int K = lo + ((hi - lo) >> 1);
            if (canEatAll(piles, K, H)) {
                hi = K;
            } else {
                lo = K + 1;
            }
        }

        return lo;
    }

    private boolean canEatAll(int[] piles, int K, int H) {
        int countHour = 0;

        for (int pile : piles) {
            countHour += pile / K;
            if (pile % K != 0)
                countHour++;
        }
        return countHour <= H;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        return maxPile;
    }
}
