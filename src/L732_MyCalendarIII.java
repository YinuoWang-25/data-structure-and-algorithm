// 732. My Calendar III

import java.util.TreeMap;

/*
Similar to meeting room II

 */
public class L732_MyCalendarIII {
    private TreeMap<Integer, Integer> timeline;

    public L732_MyCalendarIII() {
        timeline = new TreeMap<>();
    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int ongoing = 0, max = 0;
        for (int v : timeline.values())
            max = Math.max(max, ongoing += v);
        return max;
    }
}
