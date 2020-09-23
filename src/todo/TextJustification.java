package todo;

public class TextJustification {
    // 68. Text Justification
    public List<String> fullJustify(String[] words, int maxWidth) {
        String s = String.join(" ", words);
        s.substring(0, s.length() - 1);
        List<String> res = new ArrayList<>();

        int slow = 0;
        int fast = 0;
        while (fast < words.length) {
            int tentative = slow + maxWidth - 1;
            if (tentative >= s.length() - 1) {
                res.add(s.substring(slow));
                return res;
            }
            while (tentative > slow && s.charAt(tentative) != ' ') {
                tentative--;
            }
            fast = tentative + 1;
            while (tentative > slow && s.charAt(tentative) == ' ') {
                tentative--;
            }
            res.add(s.substring(slow, tentative + 1));
        }
        return res;
    }
}
