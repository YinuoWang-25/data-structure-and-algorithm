// 839. Similar String Groups

public class L839_SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        if (A.length == 0 || A.length == 1) return A.length;
        int res = A.length;
        int[] roots = new int[A.length];
        for (int i = 0; i < roots.length; i++) roots[i] = i;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isSimilar(A[j], A[i])) {
                    int ri = find(roots, i);
                    int rj = find(roots, j);
                    if (rj != ri) res--;
                    roots[ri] = rj;
                }
            }
        }
        return res;
    }

    public int find(int[] roots, int x) {
        if (roots[x] == x) return x;
        roots[x] = find(roots, roots[x]);
        return roots[x];
    }

    public boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 2) return false;
        }
        return true;
    }
}
