// 686. Repeated String Match

/*
The least time to repeat is to make the string's length >= b's length

if it doesn't work, we can append a another time

If still no work, it can not make
 */

public class L686_RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (sb.toString().contains(b)) return count;
        if (sb.append(a).toString().contains(b)) return ++count;
        return -1;
    }
}
