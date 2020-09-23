// 408. Valid Word Abbreviation

public class L408_ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (abbr.charAt(j) != word.charAt(i)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else {
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    if (num == 0) return false;
                    j++;
                }
                i += num;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
