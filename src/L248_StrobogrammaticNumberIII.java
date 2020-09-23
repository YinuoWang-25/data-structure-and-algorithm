// 248. Strobogrammatic Number III

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L248_StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        // Write your code here
        int count = 0;
        List<String> rst = new ArrayList<String>();
        for (int n = low.length(); n <= high.length(); n++) {
            rst.addAll(helper(n, n));
        }
        for (String num : rst) {
            if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }
        return count;
    }

    private List<String> helper(int cur, int max) {
        if (cur == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (cur == 1) {
            return new ArrayList<String>(Arrays.asList("1", "8", "0"));
        }

        List<String> rst = new ArrayList<String>();
        List<String> center = helper(cur - 2, max);

        for (String tmp : center) {
            if (cur != max) {
                rst.add("0" + tmp + "0");
            }
            rst.add("1" + tmp + "1");
            rst.add("6" + tmp + "9");
            rst.add("8" + tmp + "8");
            rst.add("9" + tmp + "6");
        }
        return rst;
    }
}
