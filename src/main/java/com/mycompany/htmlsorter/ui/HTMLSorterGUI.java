/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 */
package com.mycompany.htmlsorter.ui;

import com.mycompany.htmlsorter.ui.prevPanel;
import com.mycompany.htmlsorter.ui.choosePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author john
 */
public class HTMLSorterGUI {

    public static void main(String[] args) {

        JFrame MainFrame = new JFrame();
        MainFrame.setSize(640, 480);
        MainFrame.setTitle("HTML Sorter");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        prevPanel pPanel = new prevPanel();
        choosePanel cPanel = new choosePanel();

       //MainFrame.add(pPanel, BorderLayout.NORTH);
        MainFrame.add(cPanel, BorderLayout.CENTER);
        MainFrame.setVisible(true);
    }
}
