package Calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterConsole extends Printer {

    public MonthCalendar monthCalendar;

    public PrinterConsole(MonthCalendar monthCalendar) {
        this.monthCalendar = monthCalendar;
        printCalendarHeader(this.monthCalendar);
        System.out.println();
        printCalendarBody(this.monthCalendar);

    }

    @Override
    void selectionOutputDataHeader(String monthCalendarDay, int i) {
        String[] color = color();
        System.out.print(getColorHeader(i, color));
        System.out.format("%4s", monthCalendarDay);
    }

    @Override
    void selectionOutputDataBody(MonthCalendar monthCalendar, int i) {
        String[] color = color();
        for (int j = 0; j < MonthCalendar.weekSize; j++) {
            System.out.print(getColourBody(i, j, monthCalendar, color));
            System.out.format("%4d", monthCalendar.daysOfMonth[i][j]);
        }
        System.out.println();
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

}