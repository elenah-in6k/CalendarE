package Calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterHTML extends Printer {
    public static final String blackText = "<font color= #000000>";
    public static final String redText ="<font color= #FF0000>";
    public static final String greenText = "<font color= #008000>";
    public static final String yellowText = "<font color= #FFFF00>";
    public static final String blueText = "<font color= #0000FF>";
    public static final String magentaText = "<font color= #FF00FF>";
    public static final String lightBlueText ="<font color= #00FFFF>";
    public static final String whiteText = "<font color= #FFFFFF>";
    public static final String blackBackground = (char) 27 + "[40m";
    public static final String redBackground = (char) 27 + "[41m";
    public static final String greenBackground = (char) 27 + "[42m";
    public static final String yellowBackground = (char) 27 + "[43m";
    public static final String blueBackground = (char) 27 + "[44m";
    public static final String magentaBackground = (char) 27 + "[45m";
    public static final String lightBlueBackground = (char) 27 + "[46m";
    public static final String whiteBackground = (char) 27 + "[47m";
    public static final String boldText = (char) 27 + "[1m";
    public static void printCalendarHeaderInHTML(MonthCalendar c) {

        for (int i = 1; i <= MonthCalendar.weekSize; i++) {
            System.out.print(getColorHeaderHTML(i));
            System.out.format("%4s", c.dayWeekName[i]);
        }
        System.out.println();
    }

    public static String getColourBodyInHTML( int i, int j, MonthCalendar c) {
        String colour;
        if (((i == 0) & (c.daysOfMonth[i][j] >= MonthCalendar.weekSize) & (c.daysOfMonth[i][j] <= c.previousMonthSize)) | ((i == MonthCalendar.monthWeekNumber - 1) & (c.daysOfMonth[i][j] < MonthCalendar.weekSize))) {
            colour =whiteText;
        } else if (((j == saturdayIndex) | (j == sundayIndex)) & (c.daysOfMonth[i][j] != c.currentDayOfMonth)) {
            colour = redText;
        } else if (c.daysOfMonth[i][j] == c.currentDayOfMonth) {
            colour = boldText +greenText;
        } else {
            colour = blackText;
        }
        return colour;
    }

    public static String getColorHeaderHTML(int i) {
        String color;
        color = blackText;
        if ((i <= MonthCalendar.workWeekSize)) {
            color = redText;
        }
        return color;
    }

    public static void saveInFile() throws FileNotFoundException {

        PrintWriter out = new PrintWriter(new File("MonthCalendar.HTML"));
        out.printf("<HTML> <HEAD> <TITLE>MonthCalendar</TITLE> </HEAD> <BODY>");


        out.printf("</font>");


        out.println();
        out.printf("</BODY> </HTML>");
        out.close();

    }
}
