// 729. My Calendar I

import java.util.ArrayList;
import java.util.List;

public class L729_MyCalendarI {

    List<int[]> books;

    public L729_MyCalendarI() {
        books = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] b : books)
            if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
        books.add(new int[]{start, end});
        return true;
    }
}
