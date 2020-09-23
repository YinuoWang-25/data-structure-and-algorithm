// 434. Number of Segments in a String

public class L434_NumberSegmentsString {
    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                res++;
        }
        return res;
    }
}
