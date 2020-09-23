// 983. Minimum Cost For Tickets

public class L983_MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travelDays = new boolean[366];
        for (int day : days) {
            travelDays[day] = true;
        }
        int[] minCost = new int[366];
        for (int day = 1; day <= 365; ++day) {
            if (!travelDays[day]) {
                minCost[day] = minCost[day - 1];
            } else {
                // option 1: covered by a 1-day pass
                int min = minCost[day - 1] + costs[0];
                // option 2: covered by a 7-day pass
                min = Math.min(min, minCost[Math.max(0, day - 7)] + costs[1]);
                // option 2: covered by a 30-day pass
                min = Math.min(min, minCost[Math.max(0, day - 30)] + costs[2]);
                minCost[day] = min;
            }
        }
        return minCost[365];
    }
}
