package calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public abstract class Printer {

    public ColorSchema colorSchema;
    public MonthCalendar monthCalendar;

    abstract void printDayOfWeekTitle(String dayName, int i);

    abstract void printWeek(MonthCalendar monthCalendar, int i, int j);

    abstract void printStartWeekSequence();

    abstract void printEndWeekSequence();

    void print(MonthCalendar monthCalendar){
        this.monthCalendar = monthCalendar;
        printCalendarHeader(this.monthCalendar);
        printCalendarBody(this.monthCalendar);
    }



    void printCalendarHeader(MonthCalendar monthCalendar) {

        for (int i = 1; i <= MonthCalendar.WEEK_SIZE; i++) {
            printDayOfWeekTitle(monthCalendar.weekdayNames[i], i);
        }
        printEndWeekSequence();
    }

    void printCalendarBody(MonthCalendar monthCalendar) {

        for (int i = 0; i < MonthCalendar.MONTH_WEEK_NUMBER; i++) {
            printStartWeekSequence();
            for (int j = 0; j < MonthCalendar.WEEK_SIZE; j++) {
                printWeek(monthCalendar, i, j);
            }
            printEndWeekSequence();
        }
    }

    protected String getHeaderColor(int dayOfWeek, ColorSchema colorSchema1) {

        return ((dayOfWeek <= MonthCalendar.WORK_WEEK_SIZE)) ? colorSchema1.getCurrentMonthColor() : colorSchema1.getWeekendColor();
    }

    protected String getBodyColor(int weekNumber, int dayOfWeek, MonthCalendar monthCalendar, ColorSchema colorSchema) {

        if (monthCalendar.isOutOfMonth(weekNumber, dayOfWeek)) {
            return colorSchema.getOtherMonthColor();
        }

        if (monthCalendar.isWeekend(dayOfWeek) & !monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return colorSchema.getWeekendColor();
        }

        if (monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return colorSchema.getCurrentDayColor();
        }

        return colorSchema.getCurrentMonthColor();
    }

    public void printCalendar() {
        print(monthCalendar);
    }
}