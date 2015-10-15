package calendar;

import java.io.PrintStream;

/**
 * Created by employee on 10/13/15.
 */
public class ANSIPrinter extends AbstractPrinter {

    String weekendColor = "[31m";
    String otherMonthColor = "[37m";
    String currentDayColor = "[32m";
    String currentMonthColor = "[30m";

    public ColorSchema colorSchema = new ColorSchema(weekendColor, otherMonthColor, currentDayColor, currentMonthColor);


    ANSIPrinter(PrintStream printStream) {
        super(printStream);

    }


    protected void printDay(Day day) {
        String printString = "\t";
        printString += (char) 27;
        printString += getBodyColor(day, this.colorSchema);
        printString += day.dayOfMonth;

        printStream.print(printString);
    }

    protected void printDayOfWeekTitle(String weekdayName, int i) {
        printStream.print("\t" + (char) 27 + getHeaderColor(i, this.colorSchema) + weekdayName);

    }

    protected void printOpenWeekToken() {

    }

    protected void printCloseWeekToken() {
        printStream.print("\n");
    }

    protected void printOpenMonthToken() {

    }

    protected void printCloseMonthToken() {

    }
}
