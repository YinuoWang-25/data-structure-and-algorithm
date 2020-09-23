// 616. Add Bold Tag in String
/*
1. maintain a boolean array to mark whether s[i] is bold or not
    for every word in dict, we find all index of it in str and update bold arr
2. for loop all character and make res
 */

public class L616_AddBoldTag {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String word : dict) {
            int start = 0;
            while (start >= 0) {
                start = s.indexOf(word, start);
                if (start < 0) break;
                int end = start + word.length();
                for (int i = start; i < end; i++) bold[i] = true;
                start++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i] && (i - 1 < 0 || !bold[i - 1])) sb.append("<b>");
            sb.append(s.charAt(i));
            if (bold[i] && (i + 1 == s.length() || !bold[i + 1])) sb.append("</b>");
        }
        return sb.toString();
    }
}
