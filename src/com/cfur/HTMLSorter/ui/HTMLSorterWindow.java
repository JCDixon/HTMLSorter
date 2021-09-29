/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.cfur.HTMLSorter.ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class HTMLSorterWindow extends JFrame {

    public HTMLSorterWindow() {
        initWindow();
    }

    private void initWindow() {
        setTitle("WeeklySchedule.html to CSV");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choosePanel cPanel = new choosePanel();
        add(cPanel, BorderLayout.CENTER);
    }
}
