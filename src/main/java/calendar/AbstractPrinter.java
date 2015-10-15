package calendar;

import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Locale;

/**
 * Created by employee on 10/13/15.
 */
abstract class AbstractPrinter {

    PrintStream printStream;
    String[] weekdayNames;

    AbstractPrinter(PrintStream printStream) {

        this.printStream = printStream;

    }

    protected abstract void openWeek();

    protected abstract void closeWeek();

    protected abstract void openMonth();

    protected abstract void closeMonth();

    protected abstract void printDay(Day day);

    protected abstract void printDayOfWeekTitle(String weekdayName, int i);

    void printCalendar(Month month) {

        openMonth();
        printCalendarHeader();
        List<Week> weeks = month.getWeeks();
        for (Week week : weeks) {
            openWeek();
            for (Day day : week.getDays()) {
                printDay(day);
            }
            closeWeek();
        }
        closeMonth();
    }

    public String getHeaderColor(int dayOfWeek, ColorSchema colorSchema1) {

        return ((dayOfWeek <= Month.WORK_WEEK_SIZE)) ? colorSchema1.getCurrentMonthColor() : colorSchema1.getWeekendColor();
    }

    void printCalendarHeader() {
        initWeekdayNames();
        openWeek();
        for (int i = 1; i <= Week.WEEK_SIZE; i++) {
            printDayOfWeekTitle(weekdayNames[i], i);
        }
        closeWeek();
    }


    protected String getBodyColor(Day day, ColorSchema colorSchema) {

        if (!day.isInMonth()) {
            return colorSchema.getOtherMonthColor();
        }

        if (day.isWeekendDay()) {
            return colorSchema.getWeekendColor();
        }

        if (day.isDayEquals()) {
            return colorSchema.getCurrentDayColor();
        }

        return colorSchema.getCurrentMonthColor();
    }

    private void initWeekdayNames() {
        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("en"));
        weekdayNames = symbols.getShortWeekdays();
        for (int i = 1; i < Week.WEEK_SIZE; i++) {
            String tmp = weekdayNames[i];
            weekdayNames[i] = weekdayNames[i + 1];
            weekdayNames[i + 1] = tmp;
        }
    }
}
