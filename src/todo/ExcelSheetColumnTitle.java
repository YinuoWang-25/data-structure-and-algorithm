package todo;

public class ExcelSheetColumnTitle {
    // 168. Excel Sheet Column Title
    public String convertToTitle(int n) {
        String ans = "";
        while (n > 0) {
            char ch = (char) ((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            ans = ch + ans;
        }
        return ans;
    }

}
