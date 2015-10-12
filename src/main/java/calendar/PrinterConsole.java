package calendar;

import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterConsole extends Printer {

    public MonthCalendar monthCalendar;
    String weekendColor = "[31m";
    String otherMonthColor = "[37m";
    String currentDayColor = "[32m";
    String currentMonthColor = "[30m";

    public ColorSchema colorSchema = new ColorSchema(weekendColor, otherMonthColor, currentDayColor, currentMonthColor);
    private PrintStream calendarStream;

    public  PrinterConsole(PrintStream out) {
        PrintStream calendarStream = new PrintStream(out);


    }

    @Override
    void output() {




    }

    @Override
    void printDayOfWeekTitle(String monthCalendarDay, int i) {


        calendarStream.print("\t" + (char) 27 + getHeaderColor(i, this.colorSchema) + monthCalendarDay);


    }

    @Override
    void printWeek(MonthCalendar monthCalendar, int i, int j) {
        calendarStream.print("\t" + (char) 27 + getBodyColor(i, j, monthCalendar, this.colorSchema) + monthCalendar.daysOfMonth[i][j]);


    }


    @Override
    void printStartWeekSequence() {

    }

    @Override
    void printEndWeekSequence() {
        calendarStream.print("\n");
    }

    @Override
    void openMonth() {

    }

    @Override
    void closeMonth() {

    }


}