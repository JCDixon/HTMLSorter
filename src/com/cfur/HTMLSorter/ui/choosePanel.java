/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.cfur.HTMLSorter.ui;

import com.cfur.HTMLSorter.utils.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author John
 */
public class choosePanel extends JPanel {

    private final JButton ButtonOkay = new JButton("Okay");
    private final JButton scheduleBrowseButton = new JButton("Browse");
    private final JButton descriptionBrowseButton = new JButton("Browse");
    private final JButton sortedBrowseButton = new JButton("Browse");

    private final JLabel HTMLLabel = new JLabel("Choose location of WeeklySchedule.html");
    private final JLabel descriptionLabel = new JLabel("Choose location of Descriptions.txt");
    private final JLabel SortedLocationLabel = new JLabel("Choose where to place the sorted file");

    private JTextArea HTMLLocationDisplay;
    private JTextArea DescriptionLocationDisplay;
    private JTextArea SortLocationDisplay;

    private File scheduleFile;
    private File descriptionFile;

    private String scheduleLocation;
    private String descriptionLocation;
    private String sortLocation;

    public choosePanel() {
        createHTMLFileChooser();
        createDescriptionsFileChooser();
        createSortedFileChooser();
        createOkayButton();

        addComponents();
    }

    private void createHTMLFileChooser() {
        HTMLLocationDisplay = new JTextArea();
        HTMLLocationDisplay.setEditable(false);
        scheduleBrowseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.html", "html"));
                if (chooser.showOpenDialog(choosePanel.this) == JFileChooser.APPROVE_OPTION) {
                    scheduleFile = chooser.getSelectedFile();
                    try {
                        scheduleLocation = scheduleFile.getCanonicalPath();
                        HTMLLocationDisplay.setText(scheduleLocation);
                    } catch (IOException ex) {
                        Logger.getLogger(choosePanel.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "There was an error setting the WeeklySchedule file");
                    }
                } else {
                    System.out.println("No Selection ");
                }
            }
        });
    }

    private void createDescriptionsFileChooser() {
        DescriptionLocationDisplay = new JTextArea();
        DescriptionLocationDisplay.setEditable(false);
        descriptionBrowseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
                if (chooser.showOpenDialog(choosePanel.this) == JFileChooser.APPROVE_OPTION) {
                    descriptionFile = chooser.getSelectedFile();
                    try {
                        descriptionLocation = descriptionFile.getCanonicalPath();
                        DescriptionLocationDisplay.setText(descriptionLocation);
                    } catch (IOException ex) {
                        Logger.getLogger(choosePanel.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "There was an error setting the Descriptions file");
                    }
                } else {
                    System.out.println("No Selection ");
                }
            }
        });
    }

    private void createSortedFileChooser() {
        SortLocationDisplay = new JTextArea();
        SortLocationDisplay.setEditable(false);
        sortedBrowseButton.addActionListener((ActionEvent ae) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                SortLocationDisplay.setText(chooser.getSelectedFile().getAbsolutePath());
                sortLocation = chooser.getSelectedFile().getAbsolutePath() + "/WeeklySchedule.csv";
            }
        });
    }

    private void createOkayButton() {
        ButtonOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (scheduleLocation != null && descriptionLocation != null && sortLocation != null) {
                    try {
                        ParseHTML PH = new ParseHTML(scheduleFile, sortLocation);
                        PrepareFile PF = new PrepareFile(sortLocation);
                        SortPreparedFile SPF = new SortPreparedFile(sortLocation, descriptionLocation);

                        PH.ParseHTML();
                        PF.modifyMonth();
                        PF.removeWeekday();
                        PF.modifiyDay();
                        SPF.sort();

                        JOptionPane.showMessageDialog(null, "WeeklySchedule successfully converted");
                        System.exit(0);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(HTMLSorterWindow.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "There was an error finding WeeklySchedule.html. Is the file still in the same location?");
                    } catch (IOException ex) {
                        Logger.getLogger(HTMLSorterWindow.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "There was an IO error during the process of parsing/modifying the file");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Make sure to set the file locations for WeeklySchedule.html, Descriptions.txt, and the final output");
                }
            }
        });
    }

    private void addComponents() {
        this.setLayout(new GridLayout(10, 1));
        this.add(HTMLLabel);
        this.add(HTMLLocationDisplay);
        this.add(scheduleBrowseButton);
        this.add(descriptionLabel);
        this.add(DescriptionLocationDisplay);
        this.add(descriptionBrowseButton);
        this.add(SortedLocationLabel);
        this.add(SortLocationDisplay);
        this.add(sortedBrowseButton);
        this.add(ButtonOkay);
    }
}