// 119. Pascal's Triangle II

import java.util.ArrayList;
import java.util.List;

public class L119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> latest = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            latest.add(0, 1);
            for (int j = 1; j < latest.size() - 1; j++) {
                latest.set(j, latest.get(j) + latest.get(j + 1));
            }
        }
        return latest;
    }
}
