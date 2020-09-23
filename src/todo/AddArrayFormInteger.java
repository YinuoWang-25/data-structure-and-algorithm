package todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddArrayFormInteger {
    // 989. Add to Array-Form of Integer
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int plus = 0;
        int index = A.length - 1;
        while (K > 0) {
            int cur = K % 10;
            int sum = cur + (index < 0 ? 0 : A[index])+ plus;
            res.add(sum % 10);
            plus = sum / 10;
            K /= 10;
            index--;
        }
        while (index >= 0) {
            int sum = A[index] + plus;
            res.add(sum % 10);
            plus = sum / 10;
            index--;

        }
        if (plus == 1) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }
}
