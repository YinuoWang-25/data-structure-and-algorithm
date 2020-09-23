package todo;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentDuplicatesString {
    // 1047. Remove All Adjacent Duplicates In String
    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            boolean rep = false;
            while (!stack.isEmpty() && stack.peekFirst() == S.charAt(i)) {
                rep = true;
                stack.pollFirst();
            }
            if (!rep) stack.offerFirst(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.reverse().toString();
    }
}
