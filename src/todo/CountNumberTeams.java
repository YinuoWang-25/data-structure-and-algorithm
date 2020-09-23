package todo;

public class CountNumberTeams {
    public int numTeams(int[] rating) {
        if (rating == null || rating.length < 3) {
            return 0;
        }
        int[][] asc = new int[rating.length][3];
        int[][] desc = new int[rating.length][3];
        asc[0][0] = 1;
        desc[0][0] = 1;
        for (int i = 1 ; i < rating.length; i++) {
            asc[i][0] = 1;
            desc[i][0] = 1;
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    asc[i][1] += 1;
                    asc[i][2] += asc[j][1];
                } else {
                    desc[i][1] += 1;
                    desc[i][2] += desc[j][1];
                }
            }
        }
        int ans = 0;
        for (int i = 0 ; i < rating.length; i++) {
            ans += asc[i][2];
            ans += desc[i][2];
        }
        return ans;
    }
}
