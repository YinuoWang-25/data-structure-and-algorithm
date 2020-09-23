// 441. Arranging Coins

public class L441_ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n < 1) return 0;
        int t = 0;
        while (n > 0) {
            if (n - t - 1 < 0) break;
            t++;
            n -= t;
        }
        return t;
    }
}
