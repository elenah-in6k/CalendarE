package calendar;

import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Locale;

/**
 * Created by employee on 10/13/15.
 */
abstract class AbstractPrinter {

    public static final int WORK_WEEK_SIZE = 5;
    public static final int WEEK_SIZE = 7;
    PrintStream printStream;
    String[] weekdayNames;

    AbstractPrinter(PrintStream printStream) {

        this.printStream = printStream;

    }

    protected abstract void printOpenWeekToken();

    protected abstract void printCloseWeekToken();

    protected abstract void printOpenMonthToken();

    protected abstract void printCloseMonthToken();

    protected abstract void printDay(Day day);

    protected abstract void printDayOfWeekTitle(String weekdayName, int i);

    void printCalendar(Month month) {
        printOpenMonthToken();

        printCalendarHeader();

        printCalendarBody(month);

        printCloseMonthToken();
    }

    private void printCalendarBody(Month month) {
        for (Week week : month.getWeeks()) {
            printOpenWeekToken();
            printWeek(week);
            printCloseWeekToken();
        }
    }

    private void printWeek(Week week) {
        for (Day day : week.getDays()) {
            printDay(day);
        }
    }

    public String getHeaderColor(int dayOfWeek, ColorSchema colorSchema1) {

        return ((dayOfWeek <= WORK_WEEK_SIZE)) ? colorSchema1.getCurrentMonthColor() : colorSchema1.getWeekendColor();
    }

    void printCalendarHeader() {
        initWeekdayNames();
        printOpenWeekToken();
        for (int i = 1; i <= WEEK_SIZE; i++) {
            printDayOfWeekTitle(weekdayNames[i], i);
        }
        printCloseWeekToken();
    }


    protected String getBodyColor(Day day, ColorSchema colorSchema) {

        if (!day.isInMonth()) {
            return colorSchema.getOtherMonthColor();
        }

        if (day.isWeekendDay()) {
            return colorSchema.getWeekendColor();
        }

        if (day.isCurrentDay()) {
            return colorSchema.getCurrentDayColor();
        }

        return colorSchema.getCurrentMonthColor();
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
}
