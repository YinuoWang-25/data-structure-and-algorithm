// 1066. Campus Bikes II

public class L1066_CampusBikesII {

    public int assignBikes(int[][] workers, int[][] bikes) {
        int[][] memo = new int[workers.length][1 << bikes.length];
        return solve(0, 0, workers, bikes, memo);
    }

    public int solve(int cur, int takenBits, int[][] workers, int[][] bikes, int[][] memo) {
        if (cur == workers.length) return 0;
        else if (memo[cur][takenBits] != 0) return memo[cur][takenBits];
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < bikes.length; i++) {
            if ((takenBits & 1 << i) != 0) continue;
            int dist = Math.abs(workers[cur][0] - bikes[i][0]) + Math.abs(workers[cur][1] - bikes[i][1]);
            best = Math.min(best, dist + solve(cur + 1, takenBits | (1 << i), workers, bikes, memo));
        }
        memo[cur][takenBits] = best;
        return best;
    }
}
