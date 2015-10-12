package Calendar;

import java.lang.String;
import java.util.Calendar;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws NullPointerException {

        displaySelectedMethod();

    }

    private static int chooseDisplayMethod() {
        Scanner in = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        System.out.println("Where to show calendar console or html file?\n" +
                "press 1 or 2 respectively:");
        return in.nextInt();
    }

    private static void displaySelectedMethod() {
        int placeOfOutput = chooseDisplayMethod();
        MonthCalendar cal = new MonthCalendar();
        if (placeOfOutput == 1) {
            PrinterConsole pc = new PrinterConsole(cal);

        } else {
            PrinterHTML ph = new PrinterHTML(cal);

        }
    }

}