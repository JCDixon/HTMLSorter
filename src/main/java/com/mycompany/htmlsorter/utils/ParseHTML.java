/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.mycompany.htmlsorter.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class ParseHTML {

    private ArrayList line;
    private File scheduleFile;
    private Document parsedSchedule;
    private Elements table;
    private PrintWriter pw;

    public ParseHTML() {

    }

    public void ParseHTML() throws IOException {
        line = new ArrayList();
        scheduleFile = new File("/home/john/Downloads/WeekSchedule.html");
        parsedSchedule = Jsoup.parse(scheduleFile, "UTF-8");
        table = parsedSchedule.select("tr");
        for (Element row : table.select("td")) {
            String current = row.text();
            if (!current.contentEquals("Time")) {
                line.add(current);
            }

        }
        toTXT(line);
    }

    private void toTXT(ArrayList<String> parsed) throws FileNotFoundException {
        pw = new PrintWriter("/home/john/Parsed.txt");

        for (String current : parsed) {
            pw.write(current, 0, current.length());
            pw.write("\r\n");
        }
        pw.close();
    }
}
