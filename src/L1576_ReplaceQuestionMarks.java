// 1576. Replace All ?'s to Avoid Consecutive Repeating Characters

public class L1576_ReplaceQuestionMarks {
    public String modifyString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if ((i <= 0 || c != s.charAt(i - 1)) && (i >= s.length() - 1 || c != s.charAt(i + 1))) {
                        s = s.substring(0, i) + c + s.substring(i + 1);
                    }
                }
            }
        }
        return s;
    }
}
