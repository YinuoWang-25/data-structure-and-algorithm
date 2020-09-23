// 455. Assign Cookies

import java.util.Arrays;

public class L455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int pointG = 0;
        int pointS = 0;

        while (pointG < g.length && pointS < s.length) {
            if (g[pointG] <= s[pointS]) {
                pointG++;
            }
            pointS++;
        }

        return pointG;
    }
}
