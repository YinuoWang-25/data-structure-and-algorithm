// 38. Count and Say

public class L38_CountSay {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int left = 0, right = 0;
            while (right < res.length()) {
                while (right < res.length() && res.charAt(right) == res.charAt(left)) {
                    right++;
                }
                sb.append("" + (right - left) + res.charAt(left));
                left = right;
            }
            res = sb.toString();
        }
        return res;
    }
}
