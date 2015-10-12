package calendar;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public class MonthCalendar {
    public static final int WEEK_SIZE = 7;
    public static final int WORK_WEEK_SIZE = 5;
    public static final int MONTH_WEEK_NUMBER = 5;
    public static final int SATURDAY_INDEX = 5;
    public static final int SUNDAY_INDEX = 6;
    int currentDayOfMonth;
    int[][] daysOfMonth = new int[WORK_WEEK_SIZE][WEEK_SIZE];
    int previousMonthLastDayOfWeek;
    int currentMonthSize;
    int previousMonthSize;
    String[] weekdayNames;

    public MonthCalendar() {
        initCurrentDateInfo();
        initWeekdayNames();
        calendarDays();
    }

    private void initCurrentDateInfo() {
        Calendar c = Calendar.getInstance();
        currentDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, 1);
        previousMonthLastDayOfWeek = WEEK_SIZE - c.get(Calendar.DAY_OF_WEEK);
        currentMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        previousMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private void initWeekdayNames() {
        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("en"));
        weekdayNames = symbols.getShortWeekdays();
        for (int i = 1; i < WEEK_SIZE; i++) {
            String tmp = weekdayNames[i];
            weekdayNames[i] = weekdayNames[i + 1];
            weekdayNames[i + 1] = tmp;
        }
    }

    private void calendarDays() {
        fillByPreviousMonthDays();
        fillByCurrentMonthFirstWeekDays();
        fillByElseMonthDays();

    }

    private void fillByPreviousMonthDays() {
        int[] firstWeek = daysOfMonth[0];
        firstWeek[previousMonthLastDayOfWeek] = previousMonthSize;
        for (int i = previousMonthLastDayOfWeek - 1; i >= 0; i--) {
            firstWeek[i] = firstWeek[i + 1] - 1;
        }

    }

    private void fillByCurrentMonthFirstWeekDays() {
        int[] firstWeek = daysOfMonth[0];
        firstWeek[previousMonthLastDayOfWeek + 1] = 1;
        for (int i = previousMonthLastDayOfWeek + 2; i < WEEK_SIZE; i++) {
            firstWeek[i] = firstWeek[i - 1] + 1;
        }
    }

    private void fillByElseMonthDays() {
        for (int i = 1; i < MONTH_WEEK_NUMBER; i++) {
            for (int j = 0; j < WEEK_SIZE; j++) {
                if (j != 0) {
                    if ((daysOfMonth[i][j - 1] == currentMonthSize) | (daysOfMonth[i - 1][WEEK_SIZE - 1] == currentMonthSize)) {
                        daysOfMonth[i][j] = 1;
                    } else {
                        daysOfMonth[i][j] = daysOfMonth[i][j - 1] + 1;
                    }
                } else {
                    daysOfMonth[i][j] = daysOfMonth[i - 1][WEEK_SIZE - 1] + 1;
                }
            }
        }

    }

    public boolean isOutOfMonth(int weekNumber, int dayOfWeek) {
        int dayOfMonth = daysOfMonth[weekNumber][dayOfWeek];
        boolean firstWeek = weekNumber == 0;
        return ((firstWeek && (dayOfMonth >= WEEK_SIZE) & (dayOfMonth <= previousMonthSize))
                | ((weekNumber == MONTH_WEEK_NUMBER - 1) & (dayOfMonth < WEEK_SIZE)));
    }

    public boolean isCurrentDay(int weekNumber, int dayOfWeek) {
        return daysOfMonth[weekNumber][dayOfWeek] == currentDayOfMonth;
    }

    public boolean isWeekend(int dayOfWeek) {
        return (dayOfWeek == SATURDAY_INDEX) | (dayOfWeek == SUNDAY_INDEX);
    }
}