// 401. Binary Watch

import java.util.ArrayList;
import java.util.List;

public class L401_BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) | m) == num) {
                    res.add(h + ":" + ((m < 10) ? ("0" + m) : m));
                }
            }
        }
        return res;
    }
}
