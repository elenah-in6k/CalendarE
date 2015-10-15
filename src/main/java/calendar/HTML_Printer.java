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
        printStream.print("<tr>\n");
    }

    @Override
    protected void closeWeek() {
        printStream.print("</tr>\n");

    }

    @Override
    protected void openMonth() {
        printStream.print("<HTML>\n<HEAD>\n<TITLE>\n" +
                "MonthCalendar\n</TITLE>\n  " +
                "</HEAD>\n<BODY>\n" +
                "<table style=\"width: 200px;\">" + "\n");
        printStream.print("<tr>" + "\n");
    }

    @Override
    protected void closeMonth() {
        printStream.print("\n</tr>\n");
       printStream.print("</table>\n</BODY>\n</HTML>\n");
    }

    @Override
    protected void printDay(Day day) {
        printStream.print("<td>\n" + "<font color=" + getBodyColor(day, colorSchema) + ">" +
                day.dayOfMonth + "</font>\n" + "</td>\n");
    }

    @Override
    protected void printDayOfWeekTitle(String weekdayName, int i) {
        printStream.print("<td>\n" + "<font color=" + getHeaderColor(i, colorSchema) + ">" +
               weekdayName + "</font>\n" + "</td>\n");
    }
}
