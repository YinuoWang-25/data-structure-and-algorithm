package todo;
// 678. Valid Parenthesis String

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        return dfs(s, 0, 0, 0);

    }

    private boolean dfs(String s, int left, int right, int index) {
        if (index == s.length()) {
            return left == right;
        }
        if (left < right) return false;
        if (s.charAt(index) == '(') {
            return dfs(s, left + 1, right, index + 1);
        } else if (s.charAt(index) == ')') {
            return dfs(s, left, right  +1, index + 1);
        } else {
            if (left == right) return dfs(s, left + 1, right, index + 1) || dfs(s, left, right, index + 1);
            else {
                return dfs(s, left + 1, right, index + 1) || dfs(s, left, right, index + 1) || dfs(s, left, right + 1, index + 1);
            }
        }
    }
}
