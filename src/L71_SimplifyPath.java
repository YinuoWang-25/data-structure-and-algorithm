// 71. Simplify Path

import java.util.Deque;
import java.util.LinkedList;

public class L71_SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals("")) stack.pollFirst();
            else if (!s.equals("") && !s.equals(".")) stack.offerFirst(s);
        }
        StringBuilder sb = new StringBuilder();
        if (stack.size() == 0) return "/";
        while (stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
