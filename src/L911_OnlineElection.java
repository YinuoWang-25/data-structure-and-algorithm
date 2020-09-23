// 911. Online Election

/*

During initialization, we store times, and leader at this time

How can we know the leader at certain time:
1. we keep a global leader and a map to counts vote
    When current person's vote >= leader's, we know it is the new leader
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L911_OnlineElection {

    Map<Integer, Integer> leaders = new HashMap<>();
    int[] time;

    public L911_OnlineElection(int[] persons, int[] times) {
        int n = persons.length, lead = -1;
        Map<Integer, Integer> count = new HashMap<>();
        time = times;
        for (int i = 0; i < n; ++i) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) lead = persons[i];
            leaders.put(times[i], lead);
        }
    }

    public int q(int t) {
        int i = Arrays.binarySearch(time, t);
        return i < 0 ? leaders.get(time[-i - 2]) : leaders.get(time[i]);
    }
}
