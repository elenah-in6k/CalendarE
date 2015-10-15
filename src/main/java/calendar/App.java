package calendar;

import java.io.*;
import java.lang.String;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class App {
    public static final int firstPrinter = 1;

    public static void main(String[] args) throws NullPointerException, FileNotFoundException {


        displaySelectedMethod();

    }

    private static void displaySelectedMethod() throws FileNotFoundException {
        int placeOfOutput = chooseDisplayMethod();

        Month month = new Month();
        AbstractPrinter printer = placeOfOutput == firstPrinter ? new ANSI_Printer(System.out) : printInHtmlFile(month);
        printer.printCalendar(month);
    }

    private static AbstractPrinter printInHtmlFile(Month month) {
        AbstractPrinter printer = new ANSI_Printer(System.out);

        try (PrintStream printStream = new PrintStream("MonthCalendar.HTML")) {
            printer = new HTML_Printer(printStream);
            printer.printCalendar(month);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return printer;
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