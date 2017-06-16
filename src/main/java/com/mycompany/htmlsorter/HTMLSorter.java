/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.mycompany.htmlsorter;

import com.mycompany.htmlsorter.utils.*;
import java.io.IOException;

public class HTMLSorter {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        ReadConfig RC = new ReadConfig();
        RC.setProperty("html", "C:/Users/WeeklySchedule.html");
        RC.setProperty("description", "C:/Users/Descriptins.txt");
        RC.setProperty("finishedfile", "C:/Users/");
        if(!RC.arePropertiesSet()){
            System.out.println("No props have been set");
        }

        ParseHTML PH = new ParseHTML();
        PrepareFile PF = new PrepareFile();
        
        PH.ParseHTML();

        PF.modifyMonth();
        PF.removeWeekday();
        PF.modifiyDay();
        
        SortPreparedFile SPF = new SortPreparedFile();
        SPF.sort();
    }
}
