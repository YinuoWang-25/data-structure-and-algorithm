// 787. Cheapest Flights Within K Stops

import java.util.Arrays;

public class L787_CheapestFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                if (prices[flight[0]] < Integer.MAX_VALUE) {
                    temp[flight[1]] = Math.min(temp[flight[1]], prices[flight[0]] + flight[2]);
                }
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
