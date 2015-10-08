package Calendar;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.lang.String;
import java.util.Scanner;

public class App {
    public static int weekSize = 7;
    public static int workWeekSize = 5;
    public static int qtyMonthWeek = 5;
    public static int nSut = 5;
    public static int nSun = 6;
    public static String blackText = (char) 27 + "[30m";
    public static String redText = (char) 27 + "[31m";
    public static String greenText = (char) 27 + "[32m";
    public static String yellowText = (char) 27 + "[33m";
    public static String blueText = (char) 27 + "[34m";
    public static String magentaText = (char) 27 + "[35m";
    public static String lightBlueText = (char) 27 + "[36m";
    public static String whiteText = (char) 27 + "[37m";
    public static String blackBackground = (char) 27 + "[40m";
    public static String redBackground = (char) 27 + "[41m";
    public static String greenBackground = (char) 27 + "[42m";
    public static String yellowBackground = (char) 27 + "[43m";
    public static String blueBackground = (char) 27 + "[44m";
    public static String magentaBackground = (char) 27 + "[45m";
    public static String lightBlueBackground = (char) 27 + "[46m";
    public static String whiteBackground = (char) 27 + "[47m";
    public static String boldText = (char) 27 + "[1m";


    public static void main(String[] args) throws FileNotFoundException {
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        int firstDayOffset = dayOfMonth - c.get(Calendar.DAY_OF_WEEK);
        int currentMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(c.MONTH - 1, 1);
        int previousMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int[][] monthCalendar = calendarDays(previousMonthSize, firstDayOffset, currentMonthSize);
        printCalendarHeader();
        printCalendarBody(monthCalendar, dayOfMonth, previousMonthSize);
        saveInFile();
    }

    public static String[]  getDayWeekName ()    {
        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("us"));
        String[] dayWeekName = symbols.getShortWeekdays();
        for (int i = 1; i < weekSize ; i++)
        { String tmp =  dayWeekName[i];
            dayWeekName[i] = dayWeekName[i + 1];
            dayWeekName[i + 1]=tmp;
        }
        return dayWeekName;
    }
    public static String getColorHeader(int i){
        String color;
        color = blackText;
        if ( ( i <=workWeekSize)) {
           color =  redText;
        }
        return color;
    }

    public static int[][] getPreviousMonthDay(int[][] monthCalendar, int firstDayOffset, int previousMonthSize ){
        monthCalendar[0][firstDayOffset] = previousMonthSize;
        for (int i = firstDayOffset - 1; i >= 0; i--) {
            monthCalendar[0][i] = monthCalendar[0][i + 1] - 1;
        }
        return monthCalendar;
    }
    public static int[][] getCurrentMonthFirstWeekDay(int[][] monthCalendar, int firstDayOffset ) {
        monthCalendar[0][firstDayOffset] = 1;
        for (int i = firstDayOffset + 1; i < weekSize; i++) {
            monthCalendar[0][i] = monthCalendar[0][i - 1] + 1;
        }
        return monthCalendar;
    }
    public static int[][] getElseMonthDay(int[][] monthCalendar, int currentMonthSize){
        for (int i = 1; i < qtyMonthWeek; i++) {
            for (int j = 0; j < weekSize; j++) {
                if (j != 0) {
                    if ((monthCalendar[i][j - 1] == currentMonthSize) | (monthCalendar[i - 1][weekSize - 1] == currentMonthSize)) {
                        monthCalendar[i][j] = 1;
                    } else {
                        monthCalendar[i][j] = monthCalendar[i][j - 1] + 1;
                    }
                } else {
                    monthCalendar[i][j] = monthCalendar[i - 1][weekSize - 1] + 1;
                }
            }
        }
        return monthCalendar;
    }
    public static int[][] calendarDays(int previousMonthSize, int firstDayOffset, int currentMonthSize) {
        int[][] monthCalendar;
        monthCalendar = new int[qtyMonthWeek][weekSize];
        monthCalendar = getPreviousMonthDay( monthCalendar,  firstDayOffset,  previousMonthSize );
        monthCalendar = getCurrentMonthFirstWeekDay(monthCalendar,  firstDayOffset);
        monthCalendar = getElseMonthDay(monthCalendar, currentMonthSize);
        return monthCalendar;
    }

    public static void printCalendarBody(int[][] monthCalendar, int dayOfMonth, int previousMonthSize) {
        for (int i = 0; i < qtyMonthWeek; i++) {
            for (int j = 0; j < weekSize; j++) {
                System.out.print(getColourBody(monthCalendar[i][j], i, j, dayOfMonth, previousMonthSize));
                System.out.format("%4d", monthCalendar[i][j]);
            }
            System.out.println();
        }
    }

    public static void printCalendarHeader() {
        String[] dayWeekName = getDayWeekName ();
        for (int i = 1; i <=weekSize; i++) {
            System.out.print( getColorHeader(i) );
            System.out.format("%4s", dayWeekName[i]);
        }
        System.out.println();
    }
    public static String getColourBody(int day, int i, int j, int dayOfMonth, int previousMonthSize) {
        String colour;
        if (((i == 0) & (day >= weekSize) & (day <= previousMonthSize)) | ((i == qtyMonthWeek - 1) & (day < weekSize))) {
            colour = whiteText;
        } else if (((j == nSut) | (j == nSun)) & (day != dayOfMonth)) {
            colour = redText;
        } else if (day == dayOfMonth) {
            colour = boldText + redBackground + blackText;
        } else {
            colour = blackText;
        }
        return colour;
    }

    public static void printCalendarHeaderInHTML() {
        String[] dayWeekName = getDayWeekName ();
        for (int i = 1; i <=weekSize; i++) {
            System.out.print( getColorHeaderHTML(i) );
            System.out.format("%4s", dayWeekName[i]);
        }
        System.out.println();
    }
    public static String getColourBodyInHNML(int day, int i, int j, int dayOfMonth, int previousMonthSize) {
        String colour;
        if (((i == 0) & (day >= weekSize) & (day <= previousMonthSize)) | ((i == qtyMonthWeek - 1) & (day < weekSize))) {
            colour = whiteText;
        } else if (((j == nSut) | (j == nSun)) & (day != dayOfMonth)) {
            colour = redText;
        } else if (day == dayOfMonth) {
            colour = boldText + redBackground + blackText;
        } else {
            colour = blackText;
        }
        return colour;
}
    public static String getColorHeaderHTML(int i){
        String color;
        color =   "#000000";
        if ( ( i <=workWeekSize)) {
            color =" #FF0000";
        }
        return color;
    }
    public static void saveInFile() throws FileNotFoundException {

        PrintWriter out = new  PrintWriter (new File("Calendar.HTML"));
        out.printf( "<HTML> <HEAD> <TITLE>Calendar</TITLE> </HEAD> <BODY>");
        out.printf( "<font color=");

        out.printf( ">");

        out.printf( "</font>");
        String[] dayWeekName = getDayWeekName ();
        for (int i = 1; i <=weekSize; i++) {
            out.printf("%4s", dayWeekName[i]);

        }
      out.println();
        out.printf( "</BODY> </HTML>") ;
 out.close();
    }

}
