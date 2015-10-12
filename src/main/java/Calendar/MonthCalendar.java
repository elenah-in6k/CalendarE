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
    public static final int saturdayIndex = 5;
    public static final int sundayIndex = 6;
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
        calendarDays.currentDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, 1);
        calendarDays.previousMonthLastDayOfWeek = weekSize - c.get(Calendar.DAY_OF_WEEK);
        calendarDays.currentMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        calendarDays.previousMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return calendarDays;
    }

    private String[] getDayWeekName() {
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

    private void fillByCurrentMonthFirstWeekDays() {
        daysOfMonth[0][previousMonthLastDayOfWeek + 1] = 1;
        for (int i = previousMonthLastDayOfWeek + 2; i < weekSize; i++) {
            daysOfMonth[0][i] = daysOfMonth[0][i - 1] + 1;
        }

    }

    private void fillByElseMonthDays() {
        for (int i = 1; i < monthWeekNumber; i++) {
            for (int j = 0; j < weekSize; j++) {
                if (j != 0) {
                    if ((daysOfMonth[i][j - 1] == currentMonthSize) | (daysOfMonth[i - 1][weekSize - 1] == currentMonthSize)) {
                        daysOfMonth[i][j] = 1;
                    } else {
                        daysOfMonth[i][j] = daysOfMonth[i][j - 1] + 1;
                    }
                } else {
                    daysOfMonth[i][j] = daysOfMonth[i - 1][weekSize - 1] + 1;
                }
            }
        }

    }

    private MonthCalendar calendarDays(MonthCalendar c) {
        fillByPreviousMonthDays();
        fillByCurrentMonthFirstWeekDays();
        fillByElseMonthDays();
        return c;
    }

    public boolean isOutOfMonth(int weekNumber, int dayOfWeek) {
        return (((weekNumber == 0) & (daysOfMonth[weekNumber][dayOfWeek] >= MonthCalendar.weekSize) & (daysOfMonth[weekNumber][dayOfWeek] <= previousMonthSize))
                | ((weekNumber == MonthCalendar.monthWeekNumber - 1) & (daysOfMonth[weekNumber][dayOfWeek] < MonthCalendar.weekSize)));
    }

    public boolean isCurrentDay(int weekNumber, int dayOfWeek) {
        return daysOfMonth[weekNumber][dayOfWeek] == currentDayOfMonth;
    }

    public boolean isWeekend(int dayOfWeek) {
        return (dayOfWeek == saturdayIndex) | (dayOfWeek == sundayIndex);
    }
}