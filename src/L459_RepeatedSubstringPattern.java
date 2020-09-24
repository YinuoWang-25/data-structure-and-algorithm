// 459. Repeated Substring Pattern

public class L459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }
}
