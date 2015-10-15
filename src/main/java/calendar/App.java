package calendar;

import java.io.*;
import java.lang.String;
import java.util.Calendar;
import java.util.Scanner;


public class App {
    public static final int ANSI_PRINTER = 1;

    public static void main(String[] args) throws NullPointerException, FileNotFoundException, IOException {
        App app = new App();
        app.run();
    }

    private void run()  throws NullPointerException, FileNotFoundException, IOException{
        int placeOfOutput = chooseDisplayMethod();

        Month month = new Month();

        AbstractPrinter printer = (placeOfOutput == ANSI_PRINTER) ? new ANSIPrinter(System.out) : createHTMLPrinter();
        printer.printCalendar(month);
    }


    private HTMLPrinter createHTMLPrinter() throws IOException {
        PrintStream printStream = new PrintStream("MonthCalendar.HTML");
        HTMLPrinter printer = new HTMLPrinter(printStream);

        return printer;
    }

    private int chooseDisplayMethod() {
        Scanner in = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        System.out.println("Where to show calendar choose number of printer: \n" +
                "#1 console \n" +
                "#2 html \n");
        return in.nextInt();
    }


}