// 1360. Number of Days Between Two Dates

public class L1360_DaysBetweenDates {
    public int daysBetweenDates(String date1, String date2) {
        int[] daysOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Math.abs(calcDaysFrom1971(date1, daysOfMonth) - calcDaysFrom1971(date2, daysOfMonth));
    }

    private int calcDaysFrom1971(String date, int[] daysOfMonth) {
        String[] dateArr = date.split("-");
        int y = Integer.parseInt(dateArr[0]), m = Integer.parseInt(dateArr[1]), d = Integer.parseInt(dateArr[2]);
        for (int iy = 1971; iy < y; iy++) d += isLeap(iy) ? 366 : 365;
        for (int i = 0; i < m - 1; i++) d += daysOfMonth[i];
        if (m > 2 && isLeap(y)) d += 1; // on Feb leap year have 29 days instead of 28
        return d;
    }

    // check whether it is leap year
    private boolean isLeap(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}
