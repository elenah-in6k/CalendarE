package Calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public abstract class Printer {

    abstract String[] color();

    abstract void insideOutputHeader(String dayName, int i);

    abstract void insideOutputBody(MonthCalendar monthCalendar, int i);

    public MonthCalendar monthCalendar;

    void printCalendarHeader(MonthCalendar monthCalendar) {

        for (int i = 1; i <= MonthCalendar.weekSize; i++) {
            insideOutputHeader(monthCalendar.dayWeekName[i], i);
        }
    }

    void printCalendarBody(MonthCalendar monthCalendar) {

        for (int i = 0; i < MonthCalendar.monthWeekNumber; i++) {
            insideOutputBody(monthCalendar, i);
        }
    }

    protected String getColorHeader(int dayOfWeek, String[] color) {

        return ((dayOfWeek <= MonthCalendar.workWeekSize)) ? color[0] : color[1];
    }

    protected String getColourBody(int weekNumber, int dayOfWeek, MonthCalendar monthCalendar, String[] color) {

        if (monthCalendar.isOutOfMonth(weekNumber, dayOfWeek)) {
            return color[3];
        }

        if (monthCalendar.isWeekend(dayOfWeek) & !monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return color[1];
        }

        if (monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return color[2];
        }

        return color[0];
    }
}