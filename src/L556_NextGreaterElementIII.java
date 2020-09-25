// 556. Next Greater Element III
public class L556_NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length, pos = len - 1;
        while (pos > 0 && chars[pos] <= chars[pos - 1]) pos--;
        if (pos == 0) return -1;
        for (int i = len - 1; i >= pos; i--) {
            if (chars[i] > chars[pos - 1]) {
                swap(chars, i, pos - 1);
                break;
            }
        }
        reverse(chars, pos, len - 1);
        long res = Long.parseLong(new String(chars));
        if (res > Integer.MAX_VALUE)  return -1;
        return (int) res;
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
