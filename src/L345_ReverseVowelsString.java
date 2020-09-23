// 345. Reverse Vowels of a String

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L345_ReverseVowelsString {
    public String reverseVowels(String s) {
        if (s.length() == 0) return s;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] a = s.toCharArray();

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !set.contains(a[i])) i++;

            while (i < j && !set.contains(a[j])) j--;

            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
        return String.valueOf(a);
    }
}
