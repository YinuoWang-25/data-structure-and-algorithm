// 1582. Special Positions in a Binary Matrix

public class L1582_SpecialPositionsBinaryMatrix {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        if (n == 0) return 0;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) res++;
            }
        }
        return res;
    }
}
