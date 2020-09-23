// 415. Add Strings
/*
    The same problem as 67. Add Binary
 */
public class L415_AddStrings {
    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int i = n1.length - 1;
        int j = n2.length - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            add += i >= 0 ? (n1[i--] - '0') : 0;
            add += j >= 0 ? (n2[j--] - '0') : 0;
            sb.append(add % 10);
            add = add / 10;
        }
        if (add > 0) sb.append('1');
        return new String(sb.reverse());
    }
}
