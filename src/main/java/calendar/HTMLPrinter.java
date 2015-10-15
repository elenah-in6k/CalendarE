package calendar;

import java.io.PrintStream;

/**
 * Created by Алена on 10/13/15.
 */
public class HTMLPrinter extends AbstractPrinter {

    String weekendColor = "#FF0000";
    String otherMonthColor = "#C0C0C0";
    String currentDayColor = "#0DFF00";
    String currentMonthColor = "#000000";
    public ColorSchema colorSchema = new ColorSchema(weekendColor, otherMonthColor, currentDayColor, currentMonthColor);

    HTMLPrinter(PrintStream printStream) {
        super(printStream);
    }

    @Override
    protected void printOpenWeekToken() {
        printStream.print("<tr>\n");
    }

    @Override
    protected void printCloseWeekToken() {
        printStream.print("</tr>\n");

    }

    @Override
    protected void printOpenMonthToken() {
        printStream.print("<HTML>\n<HEAD>\n<TITLE>\n" +
                "MonthCalendar\n</TITLE>\n  " +
                "</HEAD>\n<BODY>\n" +
                "<table style=\"width: 200px;\">" + "\n");
        printStream.print("<tr>" + "\n");
    }

    @Override
    protected void printCloseMonthToken() {
        printStream.print("\n</tr>\n");
        printStream.print("</table>\n</BODY>\n</HTML>\n");
    }

    @Override
    protected void printDay(Day day) {
        printStream.print("<td>\n" + "\t" + "<font color=" + getBodyColor(day, colorSchema) + ">" +
                day.dayOfMonth + "</font>\n" + "</td>\n");
    }

    @Override
    protected void printDayOfWeekTitle(String weekdayName, int i) {
        printStream.print("<td>\n" + "<font color=" + getHeaderColor(i, colorSchema) + ">" +
                weekdayName + "</font>\n" + "</td>\n");
    }
}
