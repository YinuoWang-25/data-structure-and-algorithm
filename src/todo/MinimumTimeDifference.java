package todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    // 539. Minimum Time Difference
    public int findMinDifference(List<String> timePoints) {
        int mm = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();

        for (String timePoint : timePoints) {
            Integer h = Integer.valueOf(timePoint.substring(0, 2));
            time.add(60 * h + Integer.parseInt(timePoint.substring(3, 5)));
        }

        Collections.sort(time);

        for(int i = 1; i < time.size(); i++){
            mm = Math.min(mm, time.get(i) - time.get(i-1));
        }

        int corner = time.get(0) + (1440 - time.get(time.size()-1));
        return Math.min(mm, corner);
    }
}
