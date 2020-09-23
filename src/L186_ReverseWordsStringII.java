// 186. Reverse Words in a String II

public class L186_ReverseWordsStringII {
    public void reverseWords(char[] s) {
        int slow = 0;
        int fast = 0;
        reverse(s, 0, s.length - 1);
        while (fast < s.length) {
            while (fast < s.length && s[fast] != ' ') {
                fast++;
            }
            fast--;
            reverse(s, slow, fast);
            slow = fast + 2;
            fast = slow;
        }
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
