package Calendar;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public class MonthCalendar {
    public static final int weekSize = 7;
    public static final int workWeekSize = 5;
    public static final int monthWeekNumber = 5;
    int currentDayOfMonth;
    int[][] daysOfMonth = new int[workWeekSize][weekSize];
    int previousMonthLastDayOfWeek;
    int currentMonthSize;
    int previousMonthSize;
    String[] dayWeekName;

    public MonthCalendar() {
        getCurrentDateInfo(this);
        dayWeekName = getDayWeekName();
        calendarDays(this);
    }

    private MonthCalendar getCurrentDateInfo(MonthCalendar calendarDays) {
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        calendarDays.currentDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        calendarDays.previousMonthLastDayOfWeek = calendarDays.currentDayOfMonth - c.get(Calendar.DAY_OF_WEEK);
        calendarDays.currentMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.MONTH, -1);
        calendarDays.previousMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return calendarDays;
    }

    public String[] getDayWeekName() {
        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("en"));
        dayWeekName = symbols.getShortWeekdays();
        for (int i = 1; i < weekSize; i++) {
            String tmp = dayWeekName[i];
            dayWeekName[i] = dayWeekName[i + 1];
            dayWeekName[i + 1] = tmp;
        }
        return dayWeekName;
    }

    private void fillByPreviousMonthDays() {
        daysOfMonth[0][previousMonthLastDayOfWeek] = previousMonthSize;
        for (int i = previousMonthLastDayOfWeek - 1; i >= 0; i--) {
            daysOfMonth[0][i] = daysOfMonth[0][i + 1] - 1;
        }

    }

    public MonthCalendar fillByCurrentMonthFirstWeekDays(MonthCalendar c) {
        c.daysOfMonth[0][c.previousMonthLastDayOfWeek] = 1;
        for (int i = c.previousMonthLastDayOfWeek + 1; i < weekSize; i++) {
            c.daysOfMonth[0][i] = c.daysOfMonth[0][i - 1] + 1;
        }
        return c;
    }

    public MonthCalendar fillByElseMonthDays(MonthCalendar c) {
        for (int i = 1; i < c.monthWeekNumber; i++) {
            for (int j = 0; j < weekSize; j++) {
                if (j != 0) {
                    if ((c.daysOfMonth[i][j - 1] == c.currentMonthSize) | (c.daysOfMonth[i - 1][weekSize - 1] == c.currentMonthSize)) {
                        c.daysOfMonth[i][j] = 1;
                    } else {
                        c.daysOfMonth[i][j] = c.daysOfMonth[i][j - 1] + 1;
                    }
                } else {
                    c.daysOfMonth[i][j] = c.daysOfMonth[i - 1][weekSize - 1] + 1;
                }
            }
        }
        return c;
    }

    public MonthCalendar calendarDays(MonthCalendar c) {
        fillByPreviousMonthDays();
        c = fillByCurrentMonthFirstWeekDays(c);
        c = fillByElseMonthDays(c);
        return c;
    }

    public boolean isOutOfMonth(int weekNumber, int dayOfWeek) {
        return (((weekNumber == 0) & (daysOfMonth[weekNumber][dayOfWeek] >= MonthCalendar.weekSize) & (daysOfMonth[weekNumber][dayOfWeek] <= previousMonthSize))
                | ((weekNumber == MonthCalendar.monthWeekNumber - 1) & (daysOfMonth[weekNumber][dayOfWeek] < MonthCalendar.weekSize)));
    }

    public boolean isCurrentDay(int weekNumber, int dayOfWeek) {
        return daysOfMonth[weekNumber][dayOfWeek] == currentDayOfMonth;
    }
}
