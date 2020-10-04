package todo;
// 1441. Build an Array With Stack Operations
/*
Two pointers
 */

import java.util.ArrayList;
import java.util.List;

public class L1441_BuildArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 1;
        for (int j : target) {
            while (j > index) {
                res.add("Push");
                res.add("Pop");
                index++;
            }
            res.add("Push");
            index++;
        }
        return res;
    }
}
