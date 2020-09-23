// 151. Reverse Words in a String

public class L151_ReverseWordsString {
    public String reverseWords(String str) {
        char[] s = str.toCharArray();
        reverse(s, 0, s.length - 1);
        int slow = 0;
        while (slow < s.length && s[slow] == ' ') slow++;
        int fast = slow;
        while (fast < s.length) {
            while (fast < s.length && s[fast] != ' ') {
                fast++;
            }
            reverse(s, slow, fast - 1);
            while (fast < s.length && s[fast] == ' ') {
                fast++;
            }
            slow = fast;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length) {
            while (index < s.length && s[index] == ' ') {
                index++;
            }
            if (index == s.length) break;
            int last = index;
            while (last < s.length && s[last] != ' ')
                sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
