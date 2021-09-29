/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.cfur.HTMLSorter.utils;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PrepareFile {

    private Scanner sc;
    private final String[] monthREGEX;
    private final String[] monthNumberREPLACE;
    private final String[] weekdayREGEX;
    private final String blankREPLACE;
    private final String[] dayREGEX;
    private final String[] dayREPLACE;
    private final String parsedPath;

    public PrepareFile(String parsedPath) {
        monthREGEX = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
            "Oct", "Nov", "Dec"};
        monthNumberREPLACE = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        weekdayREGEX = new String[]{"Sun, ", "Mon, ", "Tue, ", "Wed, ", "Thu, ", "Fri, ", "Sat, "};
        blankREPLACE = "";
        dayREGEX = new String[]{"31,", "30,", "29,", "28,", "27,", "26,", "25,", "24,", "23,", "22,", "21,", "20,", "19,", "18,", "17,", "16,",
            "15,", "14,", "13,", "12,", "11,", "10,", "9,", "8,", "7,", "6,", "5,", "4,", "3,", "2,", "1,"};
        dayREPLACE = new String[]{"31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15",
            "14", "13", "12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02", "01"};

        this.parsedPath = parsedPath;
    }

    public void modifyMonth() {
        sc = new Scanner(parsedPath);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] INPUT = str.split(" ");
            for (int counter = 0; counter < INPUT.length; counter++) {
                for (int regArray = 0; regArray < monthREGEX.length; regArray++) {
                    modifyFile(parsedPath, monthREGEX[regArray], monthNumberREPLACE[regArray]);
                }
            }
        }
    }

    public void removeWeekday() {
        sc = new Scanner(parsedPath);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] INPUT = str.split(" ");
            for (int counter = 0; counter < INPUT.length; counter++) {
                for (int regArray = 0; regArray < weekdayREGEX.length; regArray++) {
                    modifyFile(parsedPath, weekdayREGEX[regArray], blankREPLACE);
                }
            }
        }
    }

    public void modifiyDay() {
        sc = new Scanner(parsedPath);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] INPUT = str.split(" ");
            for (int counter = 0; counter < INPUT.length; counter++) {
                for (int regArray = 0; regArray < dayREGEX.length; regArray++) {
                    modifyFile(parsedPath, dayREGEX[regArray], dayREPLACE[regArray]);
                }
            }
        }
    }

    private void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources

                reader.close();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
