// 271. Encode and Decode Strings

import java.util.ArrayList;
import java.util.List;

public class L271_EncodeDecodeStrings {
    public String encode(List<String> strs) {
        // Write your code here
        StringBuilder ans = new StringBuilder();
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                if (c == ':') {
                    ans.append("::");
                } else {
                    ans.append(c);
                }
            }
            ans.append(":;");
        }
        return ans.toString();
    }

    /**
     * @param str a string
     * @return dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        char[] sc = str.toCharArray();
        StringBuilder item = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (sc[i] == ':') {
                if (sc[i + 1] == ';') {
                    ans.add(item.toString());
                    item = new StringBuilder();
                    i += 2;
                } else {
                    item.append(sc[i + 1]);
                    i += 2;
                }
            } else {
                item.append(sc[i]);
                i += 1;
            }
        }
        return ans;
    }
}
