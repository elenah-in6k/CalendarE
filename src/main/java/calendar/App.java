package calendar;

import java.lang.String;
import java.util.Calendar;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws NullPointerException {

        displaySelectedMethod();

    }

    private static void displaySelectedMethod() {
        int placeOfOutput = chooseDisplayMethod();
        MonthCalendar cal = new MonthCalendar();
        Printer printer = placeOfOutput == 1 ? new PrinterConsole(cal) : new PrinterHTML(cal);
        //printer.printCalendar();
    }

    private static int chooseDisplayMethod() {
        Scanner in = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        System.out.println("Where to show calendar choose number of printer: \n" +
                "#1 console \n" +
                "#2 html \n");
        return in.nextInt();
    }

}