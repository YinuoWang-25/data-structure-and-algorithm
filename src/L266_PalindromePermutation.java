// 266. Palindrome Permutation

public class L266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] hash = new int[256];
        int num = 0;
        for (char c : s.toCharArray()) {
            hash[c]++;
            if (hash[c] % 2 == 1) num++;
            else num--;
        }
        return num <= 1;
    }
}
