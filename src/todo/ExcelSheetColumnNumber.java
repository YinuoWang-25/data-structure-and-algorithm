package todo;

public class ExcelSheetColumnNumber {
    // 171. Excel Sheet Column Number
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num = num * 26 + (c - 'A' + 1);
        }
        return num;
    }
}
