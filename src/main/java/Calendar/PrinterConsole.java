package Calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterConsole extends Printer {

    public MonthCalendar monthCalendar;

    public PrinterConsole(MonthCalendar monthCalendar) {
        this.monthCalendar = monthCalendar;
        printCalendarHeader();
        printCalendarBody();

    }

    @Override
    String[] color() {
        String[] color = new String[4];
        color[0] = (char) 27 + "[30m"; //blackText
        color[1] = (char) 27 + "[31m"; //redText
        color[2] = (char) 27 + "[32m"; //greenText
        color[3] = (char) 27 + "[37m"; //greyText

        return color;
    }

    @Override
     void printCalendarBody() {
        String[] color = color();
        for (int i = 0; i < MonthCalendar.monthWeekNumber; i++) {
            for (int j = 0; j < MonthCalendar.weekSize; j++) {
                System.out.print(getColourBody(i, j, monthCalendar, color));
                System.out.format("%4d", monthCalendar.daysOfMonth[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    void printCalendarHeader() {
        String[] color = color();
        for (int i = 1; i <= MonthCalendar.weekSize; i++) {
            System.out.print(getColorHeader(i, color));
            System.out.format("%4s", monthCalendar.dayWeekName[i]);
        }
        System.out.println();
    }


}