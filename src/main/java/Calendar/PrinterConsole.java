package Calendar;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterConsole extends Printer {
    public static final String blackText = (char) 27 + "[30m";
    public static final String redText = (char) 27 + "[31m";
    public static final String greenText = (char) 27 + "[32m";
    public static final String yellowText = (char) 27 + "[33m";
    public static final String blueText = (char) 27 + "[34m";
    public static final String magentaText = (char) 27 + "[35m";
    public static final String lightBlueText = (char) 27 + "[36m";
    public static final String whiteText = (char) 27 + "[37m";
    public static final String blackBackground = (char) 27 + "[40m";
    public static final String redBackground = (char) 27 + "[41m";
    public static final String greenBackground = (char) 27 + "[42m";
    public static final String yellowBackground = (char) 27 + "[43m";
    public static final String blueBackground = (char) 27 + "[44m";
    public static final String magentaBackground = (char) 27 + "[45m";
    public static final String lightBlueBackground = (char) 27 + "[46m";
    public static final String whiteBackground = (char) 27 + "[47m";
    public static final String boldText = (char) 27 + "[1m";

    public MonthCalendar monthCalendar;

    public PrinterConsole(MonthCalendar monthCalendar) {
        this.monthCalendar = monthCalendar;
    }
    public void print() {
        printCalendarHeader();
        printCalendarBody();

    }

    public String getColorHeader(int dayOfWeek) {
        return ((dayOfWeek <= MonthCalendar.workWeekSize)) ? blackText : redText;
    }

    public void printCalendarBody() {
        for (int i = 0; i < MonthCalendar.monthWeekNumber; i++) {
            for (int j = 0; j < MonthCalendar.weekSize; j++) {
                System.out.print(getColourBody(i, j));
                System.out.format("%4d", monthCalendar.daysOfMonth[i][j]);
            }
            System.out.println();
        }
    }

    public void printCalendarHeader() {

        for (int i = 1; i <= MonthCalendar.weekSize; i++) {
            System.out.print(getColorHeader(i));
            System.out.format("%4s", monthCalendar.dayWeekName[i]);
        }
        System.out.println();
    }

    public String getColourBody(int weekNumber, int dayOfWeek) {
        if (monthCalendar.isOutOfMonth(weekNumber, dayOfWeek)) {
            return whiteText;
        }

        if (isWeekend(dayOfWeek) & !monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return redText;
        }

        if (monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return boldText + greenText;
        }

        return blackText;
    }

    private boolean isWeekend(int dayOfWeek) {
        return (dayOfWeek == saturdayIndex) | (dayOfWeek == sundayIndex);
    }




}
