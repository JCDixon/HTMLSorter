/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.cfur.HTMLSorter.data;

public class Event {

    private String Subject;
    private String StartDate;
    private String StartTime;
    private String EndDate;
    private String EndTime;

    public Event(String Subject, String StartDate, String StartTime) {
        Subject = Subject.replaceAll("⤷ ", "");
        this.Subject = Subject;
        this.StartDate = StartDate;
        this.StartTime = StartTime;
        EndDate = "";
        EndTime = "";
    }

    public boolean isEndTimeSet() {
        return !EndTime.equals("");
    }

    public boolean isSubjectBlank() {
        return Subject.equals("");
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public void setEventName(String Subject) {
        this.Subject = Subject;
    }

    public String getEventName() {
        return Subject;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndTime() {
        return EndTime;
    }

    public String getEndDate() {
        return EndDate;
    }
}