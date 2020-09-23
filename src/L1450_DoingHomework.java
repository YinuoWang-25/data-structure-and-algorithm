// 1450. Number of Students Doing Homework at a Given Time

public class L1450_DoingHomework {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) ans++;
        }
        return ans;
    }
}
