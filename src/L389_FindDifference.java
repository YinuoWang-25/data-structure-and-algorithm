public class L389_FindDifference {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }
}
