package calendar;

import java.io.PrintStream;

/**
 * Created by employee on 10/13/15.
 */
public class HTML_Printer extends AbstractPrinter {

    String weekendColor = "#FF0000";
    String otherMonthColor = "#C0C0C0";
    String currentDayColor = "#0DFF00";
    String currentMonthColor = "#000000";
    public ColorSchema colorSchema = new ColorSchema(weekendColor, otherMonthColor, currentDayColor, currentMonthColor);

    HTML_Printer(PrintStream printStream) {
        super(printStream);
    }

    @Override
    protected void openWeek() {

    }

    @Override
    protected void closeWeek() {

    }

    @Override
    protected void openMonth() {

    }

    @Override
    protected void closeMonth() {

    }

    @Override
    protected void printDay(Day day) {

    }

    @Override
    protected void printDayOfWeekTitle(String weekdayName, int i) {

    }
}
