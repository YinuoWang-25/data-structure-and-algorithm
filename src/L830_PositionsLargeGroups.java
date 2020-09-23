// 830. Positions of Large Groups

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L830_PositionsLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        int slow = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (slow < S.length()) {
            int fast = slow;
            while (fast < S.length() && S.charAt(fast) == S.charAt(slow)) {
                fast++;
            }
            if (fast - slow >= 3) {
                res.add(Arrays.asList(slow, fast - 1));
            }
            slow = fast;
        }
        return res;
    }
}
