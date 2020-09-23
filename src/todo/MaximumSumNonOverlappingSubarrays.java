package todo;

public class MaximumSumNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int N = A.length;
        int[] s = new int[N + 1];
        int[] firstL = new int[N + 1];
        int[] lastL = new int[N + 1];
        int[] firstM = new int[N + 1];
        int[] lastM = new int[N + 1];

        for(int i = 1; i <= A.length; i++) s[i] = s[i - 1] + A[i - 1];

        for(int i = L; i < N; i++) firstL[i] = Math.max(firstL[i - 1], s[i] - s[i - L]);
        for(int i = M; i < N; i++) firstM[i] = Math.max(firstM[i - 1], s[i] - s[i - M]);
        for(int i = N - L; i >= 0; i--) lastL[i] = Math.max(lastL[i + 1], s[i + L] - s[i]);
        for(int i = N - M; i >= 0; i--) lastM[i] = Math.max(lastM[i + 1], s[i + M] - s[i]);

        int V = 0;
        for(int i = 0; i < N; i++)
        {
            V = Math.max(V, firstL[i] + lastM[i]);
            V = Math.max(V, firstM[i] + lastL[i]);
        }

        return V;
    }
}
