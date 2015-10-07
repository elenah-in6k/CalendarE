package Calendar;

import java.util.Calendar;

public class App {
    public  static int weekSize = 7;
    public  static int workWeekSize = 5;
    public  static int qtyMonthWeek = 5;
    public  static int nSut = 5;
    public  static int nSun = 6;
    public  static String blackText = (char) 27 + "[30m" ;
    public  static String redText = (char) 27 + "[31m" ;
    public  static String greenText = (char) 27 + "[32m" ;
    public  static String yellowText = (char) 27 + "[33m" ;
    public  static String blueText = (char) 27 + "[34m" ;
    public  static String magentaText = (char) 27 + "[35m" ;
    public  static String lightBlueText = (char) 27 + "[36m" ;
    public  static String whiteText = (char) 27 + "[37m" ;
    public  static String blackBackground = (char) 27 + "[40m" ;
    public  static String redBackground = (char) 27 + "[41m" ;
    public  static String greenBackground = (char) 27 + "[42m" ;
    public  static String yellowBackground= (char) 27 + "[43m" ;
    public  static String blueBackground= (char) 27 + "[44m" ;
    public  static String magentaBackground= (char) 27 + "[45m" ;
    public  static String lightBlueBackground = (char) 27 + "[46m" ;
    public  static String whiteBackground= (char) 27 + "[47m" ;
    public  static String boldText= (char) 27 + "[1m" ;


    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        int firstDayOffset = dayOfMonth - c.get(Calendar.DAY_OF_WEEK) ;
        int currentMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
         c.set(c.MONTH - 1, 1);
        int previousMonthSize = c.getActualMaximum(Calendar.DAY_OF_MONTH);
         int[][] monthCalendar = calendarDays(previousMonthSize, firstDayOffset, currentMonthSize);
        printCalendarHeader();
        printCalendarBody(monthCalendar, dayOfMonth);
    }

    public static void printCalendarHeader() {
        String[] dayWeekName;
        // edit with collection
        dayWeekName = new String[7];
        //edit array name day of week {,}
        dayWeekName[0] = "Mon";
        dayWeekName[1] = "Tue";
        dayWeekName[2] = "Wed";
        dayWeekName[3] = "Thu";
        dayWeekName[4] = "Fri";
        dayWeekName[5] = "Sut";
        dayWeekName[6] = "Sun";

        for (int i = 0; i <= 6; i++) {
            System.out.print((char) 27 + "[46m" +redText + dayWeekName[i] + " "); //set sut sun else color
        }

        System.out.println();
    }

    public static int[][] calendarDays(int qDaysOfMonthLast, int firstDayOffset, int qDaysOfMonthNow) {
        int[][] monthCalendar;
        //extract const
        monthCalendar = new int[qtyMonthWeek][weekSize];
        monthCalendar[0][firstDayOffset] = qDaysOfMonthLast;
        for (int i = firstDayOffset - 1; i >= 0; i--) {
            monthCalendar[0][i] = monthCalendar[0][i + 1] - 1;
        }
        monthCalendar[0][firstDayOffset] = 1;
        for (int i = firstDayOffset+1 ; i < weekSize; i++) {
            monthCalendar[0][i] = monthCalendar[0][i - 1] + 1;
        }
        for (int i = 1; i <qtyMonthWeek; i++) {
            for (int j = 0; j < weekSize; j++) {
                if (j!=0){
                     if  ((monthCalendar[i][j - 1] == qDaysOfMonthNow)|(monthCalendar[i-1][weekSize-1] == qDaysOfMonthNow) ) {
                             monthCalendar[i][j] = 1;
                     } else {
                             monthCalendar[i][j] = monthCalendar[i][j - 1] + 1;
                     }
                } else {
                        monthCalendar[i][j] = monthCalendar[i - 1][weekSize-1] + 1;
                }
            }
        }
        return monthCalendar;
    }

     public static void printCalendarBody(int[][] monthCalendar, int dayOfMonth) {
        for (int i = 0; i < qtyMonthWeek; i++) {
            for (int j =0; j < weekSize; j++) {
                System.out.print( getColour(monthCalendar[i][j], i, j, dayOfMonth) );
                System.out.format("%4d", monthCalendar[i][j]);
            }
            System.out.println();
        }
        System.out.println(lightBlueBackground);
    }

    public static String getColour(int day, int i, int j, int dayOfMonth) {
        String colour;
        if (((i == 0) & (day >= 26) & (day <= 31)) | ((i == qtyMonthWeek - 1) & (day < 26))) {
            colour = whiteText;
        } else if (((j == nSut) | (j == nSun)) & (day != dayOfMonth)) {
            colour = redText ;
        } else if (day == dayOfMonth) {
            colour =boldText + magentaBackground + blueText ;
        } else {
            colour = blackText ;
        }
        return colour;
    }
}
