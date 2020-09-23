// 277. Find the Celebrity

public class L277_FindCelebrity extends Relation {
    public int findCelebrity(int n) {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (!knows(i, ans)) {
                ans = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == ans) continue;
            if (knows(ans, i) || !knows(i, ans)) return -1;
        }
        return ans;
    }
}

class Relation {
    boolean knows(int a, int b) {
        // placeholder return value
        return false;
    }
}
