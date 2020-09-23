// 294. Flip Game II

import java.util.ArrayList;
import java.util.List;

public class L294_FlipGameII {
    public boolean canWin(String s) {
        List<String> nexts = generatePossibleNextMoves(s);
        if (nexts.size() == 0) return false;
        for (String next : nexts) {
            if (!canWin(next)) return true;
        }
        return false;
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }
}
