/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.mycompany.htmlsorter.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class prevPanel extends JPanel {

    private JButton prevButtonNo;
    private JButton prevButtonYes;
    private JLabel prevHTMLLabel;
    private JLabel prevSortedLocationLabel;
    private JTextArea prevHTMLLocationDisplay;
    private JTextArea prevSortLocationDisplay;
    private JLabel reuseLabel;

    public prevPanel() {
        this.setLayout(new GridLayout(8, 1));
        prevButtonNo = new JButton("No");
        prevButtonYes = new JButton("Yes");
        prevHTMLLabel = new JLabel("Previous location of WeeklySchedule.html");
        prevHTMLLocationDisplay = new JTextArea();
        prevHTMLLocationDisplay.setEditable(false);
        prevSortedLocationLabel = new JLabel("Previous location of sorted file");
        prevSortLocationDisplay = new JTextArea();
        prevSortLocationDisplay.setEditable(false);
        reuseLabel = new JLabel("Would you like to reuse your previous settings?");
        
        this.add(reuseLabel);
        this.add(prevHTMLLabel);
        this.add(prevHTMLLocationDisplay);
        this.add(prevSortedLocationLabel);
        this.add(prevSortLocationDisplay);
        this.add(prevButtonNo);
        this.add(prevButtonYes);

    }
}
