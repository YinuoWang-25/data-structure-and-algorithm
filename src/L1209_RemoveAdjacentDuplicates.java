// 1209. Remove All Adjacent Duplicates in String II

import java.util.Deque;
import java.util.LinkedList;

public class L1209_RemoveAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != (char) (stack.peekFirst()[0] + 'a')) {
                stack.offerFirst(new int[]{c - 'a', 1});
            } else {
                int[] top = stack.pollFirst();
                if (top[1] + 1 < k) {
                    stack.offerFirst(new int[]{c - 'a', top[1] + 1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] cur = stack.pollLast();
            for (int i = 0; i < cur[1]; i++) {
                sb.append((char) (cur[0] + 'a'));
            }
        }
        return sb.toString();
    }
}
