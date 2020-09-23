// 953. Verifying an Alien Dictionary

/*

Step 1: build the map mapping from char and its order

Step 2: iterate all pairs of words and compare them according to map:
    a. find first character on same position but diff in two words, return comparasion value
       based on map
    b. If not found, compare length of two words

*/

public class L953_VerifyingAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (isBigger(words[i], words[i + 1], map)) return false;
        }
        return true;
    }

    private boolean isBigger(String first, String second, int[] map) {
        int m = first.length();
        int n = second.length();
        for (int i = 0; i < m && i < n; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return map[first.charAt(i) - 'a'] > map[second.charAt(i) - 'a'];
            }
        }
        return m > n;
    }
}
