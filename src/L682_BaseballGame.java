// 682. Baseball Game

import java.util.ArrayList;
import java.util.List;

public class L682_BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> q = new ArrayList<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int num = 0;
                    if (q.size() > 0) {
                        num += q.get(q.size() - 1);
                    }
                    if (q.size() > 1) {
                        num += q.get(q.size() - 2);
                    }
                    q.add(num);
                    break;
                case "C":
                    if (q.size() > 0) {
                        q.remove(q.size() - 1);
                    }
                    break;
                case "D":
                    if (q.size() > 0) {
                        q.add(2 * q.get(q.size() - 1));
                    }
                    break;
                default:
                    q.add(Integer.parseInt(op));
                    break;
            }
        }
        int total = 0;
        for (int s : q) {
            total += s;
        }
        return total;
    }
}
