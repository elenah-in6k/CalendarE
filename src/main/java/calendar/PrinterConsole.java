package calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterConsole extends Printer {

    public MonthCalendar monthCalendar;
    String weekendColor = "[31m";
    String otherMonthColor = "[37m";
    String currentDayColor = "[32m";
    String currentMonthColor = "[30m";
   public ColorSchema colorSchema= new ColorSchema (weekendColor, otherMonthColor, currentDayColor, currentMonthColor);

    public PrinterConsole(MonthCalendar monthCalendar) {
        this.monthCalendar = monthCalendar;
        //PrinterConsole printer = new PrinterConsole(this.monthCalendar);

        print(this.monthCalendar);


    }

    @Override
    void printDayOfWeekTitle(String monthCalendarDay, int i) {

        System.out.print((char) 27 +getHeaderColor(i, this.colorSchema));
        System.out.format("%4s", monthCalendarDay);

    }

    @Override
    void printWeek(MonthCalendar monthCalendar, int i, int j) {
        System.out.print((char) 27 + getBodyColor(i, j, monthCalendar, this.colorSchema));
        System.out.format("%4d", monthCalendar.daysOfMonth[i][j]);

    }


    @Override
    void printStartWeekSequence() {

    }

    @Override
    void printEndWeekSequence() {
        System.out.println();
    }


}