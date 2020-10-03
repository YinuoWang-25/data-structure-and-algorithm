// 1100. Find K-Length Substrings With No Repeated Characters
public class L1100_KLengthSubstrings {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) return 0;
        char[] s = S.toCharArray();
        int[] hash = new int[26];
        int res = 0, count = 0;
        for (int right = 0; right < s.length; right++) {
            hash[s[right] - 'a']++;
            if (hash[s[right] - 'a'] == 2) count++;
            if (right == K - 1 && count == 0) res++;
            if (right >= K) {
                hash[s[right - K] - 'a']--;
                if (hash[s[right - K] - 'a'] == 1) count--;
                if (count == 0) res++;
            }
        }
        return res;
    }
}
