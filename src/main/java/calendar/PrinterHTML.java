package calendar;

import java.io.*;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterHTML extends Printer {

    public MonthCalendar monthCalendar;
    String weekendColor = "#FF0000";
    String otherMonthColor = "#C0C0C0";
    String currentDayColor = "#0DFF00";
    String currentMonthColor = "#000000";
    public ColorSchema colorSchema = new ColorSchema(weekendColor, otherMonthColor, currentDayColor, currentMonthColor);
    //static String printStream = "";
    private PrintStream printStream;

    public PrinterHTML(File file) throws FileNotFoundException {
        PrintStream calendarStream = new PrintStream(file);
    }

    @Override
    void output() {

    }

    @Override
    void openMonth() {
        printStream.print("<HTML>\n<HEAD>\n<TITLE>\n" +
                "MonthCalendar\n</TITLE>\n  " +
                "</HEAD>\n<BODY>\n" +
                "<table style=\"width: 200px;\">" + "\n");
        printStream.print("<tr>" + "\n");
    }

    @Override
    void closeMonth() {
        printStream.print("\n</tr>\n");
        printStream.print("</table>\n</BODY>\n</HTML>\n");
    }


    @Override
    void printDayOfWeekTitle(String monthCalendarDay, int i) {

        printStream.print("<td>\n" + "<font color=" + getHeaderColor(i, colorSchema) + ">" +
                monthCalendarDay + "</font>\n" + "</td>\n");
    }

    @Override
    void printStartWeekSequence() {
        printStream.print("<tr>\n");
    }

    @Override
    void printEndWeekSequence() {
        printStream.print("</tr>\n");
    }

    @Override
    void printWeek(MonthCalendar monthCalendar, int i, int j) {
        printStream.print("<td>\n" + "<font color=" + getBodyColor(i, j, monthCalendar, colorSchema) + ">" +
                monthCalendar.daysOfMonth[i][j] + "</font>\n" + "</td>\n");


    }

}