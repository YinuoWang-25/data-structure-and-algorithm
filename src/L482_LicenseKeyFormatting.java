// 482. License Key Formatting

public class L482_LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        StringBuilder cur = new StringBuilder();

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            char c = Character.toUpperCase(S.charAt(i));
            cur.append(c);
            if (cur.length() == K) {
                sb.append(cur);
                sb.append('-');
                cur = new StringBuilder();
            }
        }
        if (cur.length() > 0) {
            sb.append(cur);
        } else {
            if (sb.length() == 0) return "";
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
