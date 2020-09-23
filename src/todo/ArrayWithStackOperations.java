package todo;

import java.util.ArrayList;
import java.util.List;

public class ArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 1;
        for (int i = 0 ; i < target.length; i++) {
            while (target[i] > index) {
                res.add("Push");
                // pop
                res.add("Pop");
                index++;
            }

            res.add("Push");
            index++;
        }
        return res;
    }
}
