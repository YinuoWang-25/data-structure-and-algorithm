// 388. Longest Absolute File Path

import java.util.Deque;
import java.util.LinkedList;

public class L388_LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1;
            while (lev + 1 < stack.size()) {
                stack.pollFirst();
            }
            int len = stack.peekFirst() + s.length() - lev + 1;
            stack.offerFirst(len);
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }
}
