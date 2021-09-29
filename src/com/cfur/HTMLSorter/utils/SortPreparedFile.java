/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.cfur.HTMLSorter.utils;

import com.cfur.HTMLSorter.data.Event;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class SortPreparedFile {

    private final String Arrow;
    private final String parsedPath;
    private String descriptionPath;
    private File descriptionFile;
    private final File file;
    private String CurrentTime;
    private String CurrentEvent;
    private Scanner input;
    private final ArrayList<String> StartDate;
    private final ArrayList<String> EndDate;
    private Event[][] EventArray;

    public SortPreparedFile(String parsedPath, String descriptionPath) throws FileNotFoundException {
        this.parsedPath = parsedPath;
        this.descriptionPath = descriptionPath;
        file = new File(parsedPath);
        StartDate = new ArrayList();
        EndDate = new ArrayList();
        Arrow = "⤵";
        EventArray = new Event[48][7];
    }

    public void sort() throws FileNotFoundException {
        input = new Scanner(file);
        for (int i = 0; i < 7; i++) {
            String dates = input.nextLine();
            StartDate.add(dates);
            EndDate.add(dates);
        }

        CurrentTime = input.nextLine();
        for (int i = 0; i < 7; i++) {
            CurrentEvent = input.nextLine();
            EventArray[0][i] = new Event(CurrentEvent, StartDate.get(i), CurrentTime);
        }

        while (input.hasNextLine()) {
            for (int row = 1; row < 48; row++) {
                CurrentTime = input.nextLine();
                for (int column = 0; column < 7; column++) {
                    CurrentEvent = input.nextLine();
                    if (CurrentTime.equals("11:30 PM")) {
                        if (CurrentEvent.equals(Arrow)) {
                            EventArray[row][column] = new Event("", "", "");
                            for (int c = (row - 1); row > 0; c--) {
                                if (!EventArray[c][column].isSubjectBlank()) {
                                    EventArray[c][column].setEventName("");
                                    EventArray[0][column + 1].setStartDate(StartDate.get(column));
                                    EventArray[0][column + 1].setStartTime(EventArray[c][column].getStartTime());
                                    break;
                                }
                            }
                        } else {
                            for (int c = (row - 1); row > 0; c--) {
                                if (EventArray[c][column].isSubjectBlank()) {

                                } else if (!EventArray[c][column].isEndTimeSet()) {
                                    EventArray[c][column].setEndTime("12:00 AM");
                                    //EventArray[c][column].setEndTime(CurrentTime);
                                    EventArray[c][column].setEndDate(StartDate.get(column));
                                    EventArray[row][column] = new Event(CurrentEvent, StartDate.get(column), CurrentTime);
                                    break;
                                }
                            }
                        }
                    } else if (CurrentEvent.equals("")) {
                        EventArray[row][column] = new Event("", "", "");

                    } else {
                        for (int c = (row - 1); row > 0; c--) {
                            if (EventArray[c][column].isSubjectBlank()) {

                            } else if (!EventArray[c][column].isEndTimeSet()) {
                                EventArray[c][column].setEndTime(CurrentTime);
                                EventArray[c][column].setEndDate(StartDate.get(column));
                                EventArray[row][column] = new Event(CurrentEvent, StartDate.get(column), CurrentTime);
                                break;
                            } else {

                            }
                        }

                    }
                }
            }
        }
        printEventArray();
    }

    private void printEventArray() throws FileNotFoundException {
        String pathToFinishedFile = parsedPath;
        File finishedFile = new File(pathToFinishedFile);
        PrintWriter pw = new PrintWriter(finishedFile);
        pw.write("Subject,Start Date,Start Time,End Date,End Time,All Day Event,Description,Location,Private");
        pw.write("\r\n");
        for (int row = 0; row < 48; row++) {
            for (int column = 0; column < 7; column++) {
                if (EventArray[row][column].isSubjectBlank()) {
                    //Do Nothing
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(EventArray[row][column].getEventName()).append(",");
                    sb.append(EventArray[row][column].getStartDate()).append(",");
                    sb.append(EventArray[row][column].getStartTime()).append(",");
                    sb.append(EventArray[row][column].getEndDate()).append(",");
                    sb.append(EventArray[row][column].getEndTime()).append(",");
                    sb.append("FALSE" + ",");
                    sb.append(findDescription(EventArray[row][column].getEventName())).append(",");
                    sb.append(",,");
                    sb.append("TRUE");
                    pw.write(sb.toString());
                    pw.write("\r\n");
                }
            }
        }
        pw.close();
    }

    private String findDescription(String passedEvent) throws FileNotFoundException {
        boolean reachedDescriptionEnd = false;
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionFile = new File(descriptionPath);
        Scanner sc = new Scanner(descriptionFile);
        while (sc.hasNextLine()) {
            String Current = sc.nextLine();
            if (!Current.equals(passedEvent)) {
            } else {
                while (!reachedDescriptionEnd && sc.hasNextLine()) {
                    String temp = sc.nextLine();
                    if (!temp.equals("*****************************************************************")) {
                        descriptionBuilder.append(temp);
                    } else if (temp.equals("*****************************************************************")) {
                        reachedDescriptionEnd = true;
                    }
                }
            }
        }
        return descriptionBuilder.toString();
    }
}