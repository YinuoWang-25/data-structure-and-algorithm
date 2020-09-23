// 383. Ransom Note
public class L383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] hash = new int[256];
        for (char c : magazine.toCharArray()) {
            hash[c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            hash[c]--;
            if (hash[c] < 0) return false;
        }
        return true;
    }
}
