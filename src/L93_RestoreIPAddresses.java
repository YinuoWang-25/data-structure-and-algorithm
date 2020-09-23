// 93. Restore IP Addresses

import java.util.ArrayList;
import java.util.List;

public class L93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(ans, s, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(List<String> ans, String s, List<String> cur, int index) {
        if (cur.size() > 4) return;
        if (index == s.length()) {
            if (cur.size() == 4) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(cur.get(i));
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                ans.add(sb.toString());
            }
            return;
        }

        for (int i = index + 1; i < index + 4 && i <= s.length(); i++) {
            String p = s.substring(index, i);
            int tmp = Integer.parseInt(p);
            if (p.startsWith("0") && i != index + 1) break;
            if (tmp >= 0 && tmp <= 255) {
                cur.add(p);
                dfs(ans, s, cur, i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
