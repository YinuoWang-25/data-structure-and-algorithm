// 394. Decode String

import java.util.Deque;
import java.util.LinkedList;

public class L394_DecodeString {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        String pre = "";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.offerFirst(pre);
                nums.offerFirst(num);
                pre = "";
                num = 0;
            } else if (c == ']') {
                String p = stack.pollFirst();
                int k = nums.pollFirst();
                for (int j = 0; j < k; j++) {
                    p = p + pre;
                }
                pre = p;
            } else if (Character.isLetter(c)) {
                pre += c;
            } else {
                num = num * 10 + (c - '0');
            }
        }

        return pre;
    }
}
