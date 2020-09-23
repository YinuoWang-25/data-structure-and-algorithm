// 722. Remove Comments

import java.util.ArrayList;
import java.util.List;

/*
    1. If we see '//' we stop reading the current line, and add whatever characters we have seen to the result.
    2. If we see '/*' then we start the multiline comment mode and we keep on ignoring characters until we see '* /'
    3. If the current character is neither of the above two and the multiline comment mode is off,
       then we add that character to the current line.
 */

public class L722_RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean multiCmtMode = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (multiCmtMode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        multiCmtMode = false;
                        i++;        //skip '/' on next iteration of i
                    }
                } else {
                    // We meet // and ignore rest of the line
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        multiCmtMode = true;
                        i++;
                    } else sb.append(s.charAt(i));
                }
            }
            if (!multiCmtMode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
