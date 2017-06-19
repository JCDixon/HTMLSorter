/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 */
package com.mycompany.htmlsorter.ui;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author john
 */
public class HTMLSorterGUI {

    private static JFrame MainFrame;

    public static void start() {

        MainFrame = new JFrame();
        MainFrame.setSize(640, 480);
        MainFrame.setTitle("HTML Sorter");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //prevPanel pPanel = new prevPanel();
        choosePanel cPanel = new choosePanel();

        //MainFrame.add(pPanel, BorderLayout.NORTH);
        MainFrame.add(cPanel, BorderLayout.CENTER);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HTMLSorterGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HTMLSorterGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HTMLSorterGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HTMLSorterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainFrame.setVisible(true);
    }
}