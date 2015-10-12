package Calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public abstract class Printer {

    abstract String[] color();
    abstract void printCalendarBody();
    abstract void printCalendarHeader();

    protected String getColorHeader(int dayOfWeek, String[] color) {

        return ((dayOfWeek <= MonthCalendar.workWeekSize)) ? color[0] : color[1];
    }

    protected String getColourBody(int weekNumber, int dayOfWeek,MonthCalendar monthCalendar, String[] color) {

        if (monthCalendar.isOutOfMonth(weekNumber, dayOfWeek)) {
            return color[3];
        }

        if (monthCalendar.isWeekend(dayOfWeek) & !monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return color[1];
        }

        if (monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return  color[2];
        }

        return color[0];
    }
}