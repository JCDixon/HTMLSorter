/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 */
package com.mycompany.htmlsorter.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

/**
 *
 * @author john
 */
public class choosePanel extends JPanel {

    private JButton ButtonOkay;
    private BrowseButton scheduleBrowseButton;
    private BrowseButton sortedBrowseButton;
    //private JButton scheduleBrowseButton;
    //private JButton sortedBrowseButton;
    private JLabel HTMLLabel;
    private JLabel SortedLocationLabel;
    private JTextArea HTMLLocationDisplay;
    private JTextArea SortLocationDisplay;

    public choosePanel() {
        this.setLayout(new GridLayout(7, 1));
        ButtonOkay = new JButton("Okay");
        HTMLLabel = new JLabel("Choose location of WeeklySchedule.html");
        HTMLLocationDisplay = new JTextArea();
        scheduleBrowseButton = new BrowseButton("Browse", "html");
        HTMLLocationDisplay.setEditable(false);
        SortedLocationLabel = new JLabel("Choose location of sorted file");
        SortLocationDisplay = new JTextArea();
        sortedBrowseButton = new BrowseButton("Browse", "txt");
        SortLocationDisplay.setEditable(false);

        this.add(HTMLLabel);
        this.add(HTMLLocationDisplay);
        this.add(scheduleBrowseButton);
        this.add(SortedLocationLabel);
        this.add(SortLocationDisplay);
        this.add(sortedBrowseButton);
        this.add(ButtonOkay);
    }
}
