// 134. Gas Station

/*
The main idea is similar to find celebrity.
from the first gas station, we check whether it could be the answer by checking
whether we can go from this station to end.
 */

public class L134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;

        int sum = 0, total = 0, index = -1;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }
        return total < 0 ? -1 : index + 1;
    }
}
