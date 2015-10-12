package calendar;

import java.io.*;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterHTML extends Printer {

    public MonthCalendar monthCalendar;
    String weekendColor = "#FF0000";
    String otherMonthColor = "#C0C0C0";
    String currentDayColor =  "#0DFF00";
    String currentMonthColor = "#000000";
    public ColorSchema colorSchema= new ColorSchema (weekendColor, otherMonthColor, currentDayColor, currentMonthColor);
    String html;

    public PrinterHTML(MonthCalendar monthCalendar) {
        this.monthCalendar = monthCalendar;
       // PrinterHTML printer = new PrinterHTML(this.monthCalendar);
        print(this.monthCalendar);

    }
    // afterprint function
    public void print() {
        File file = new File("MonthCalendar.HTML");
        try (FileWriter monthCalendarHtmlFile = new FileWriter(file, false)) {
            writeBeginningHtmlFile();
            printCalendarHeader(this.monthCalendar);
            printCalendarBody(this.monthCalendar);
            writeEndingHtmlFile();
            monthCalendarHtmlFile.write(html);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    void writeBeginningHtmlFile() {
        html = "<HTML>\n<HEAD>\n<TITLE>\n" +
                "MonthCalendar\n</TITLE>\n  " +
                "</HEAD>\n<BODY>\n" +
                "<table style=\"width: 200px;\">" + "\n";
        html += "<tr>" + "\n";
    }

    void writeEndingHtmlFile() {
        html += "\n</tr>\n";
        html += "</table>\n</BODY>\n</HTML>\n";
    }


    @Override
    void printDayOfWeekTitle(String monthCalendarDay, int i) {

        html += "<td>\n" +"<font color="+ getHeaderColor(i, colorSchema)+">" +
                monthCalendarDay + "</font>\n" + "</td>\n";
    }

    @Override
    void printStartWeekSequence(){
        html += "<tr>\n";
    }

    @Override
    void printEndWeekSequence(){
        html += "</tr>\n";
    }

    @Override
    void printWeek(MonthCalendar monthCalendar, int i, int j) {
        html += "<td>\n" +"<font color="+getBodyColor(i, j, monthCalendar, colorSchema)+">" +
                    monthCalendar.daysOfMonth[i][j] + "</font>\n" + "</td>\n";


    }

}