// 17. Letter Combinations of a Phone Number

import java.util.LinkedList;
import java.util.List;

public class L17_LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits.length() == 0) return res;
        String[] numToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        combination(digits.toCharArray(), numToChar, 0, sb, res);
        return res;
    }

    private void combination(char[] number, String[] numToChar, int level, StringBuilder sb, List<String> ans) {
        if (level == number.length) {
            ans.add(sb.toString());
            return;
        }
        char[] chs = numToChar[number[level] - '0'].toCharArray();
        if (chs.length == 0) {
            combination(number, numToChar, level + 1, sb, ans);
        } else {
            for (char ch : chs) {
                combination(number, numToChar, level + 1, sb.append(ch), ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
