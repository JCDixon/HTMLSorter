/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlsorter.ui;
import htmlsorter.utils.ParseHTML;
import htmlsorter.utils.PrepareFile;
import htmlsorter.utils.SortPreparedFile;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author John
 */
public class choosePanel extends JPanel {
    private final JButton ButtonOkay;
    private final JButton scheduleBrowseButton;
    private final JButton descriptionBrowseButton;
    private final JButton sortedBrowseButton;
    private final JLabel HTMLLabel;
    private final JLabel descriptionLabel;
    private final JLabel SortedLocationLabel;
    private JTextArea HTMLLocationDisplay;
    private JTextArea DescriptionLocationDisplay;
    private JTextArea SortLocationDisplay;
    private File scheduleFile;
    private File descriptionFile;
    private String scheduleLocation;
    private String descriptionLocation;
    private String sortLocation;

    public choosePanel() {
        this.setLayout(new GridLayout(10, 1));

//********************START CODE FOR HTML BUTTONS, LABELS, AND TEXT AREA********************//
        HTMLLabel = new JLabel("Choose location of WeeklySchedule.html");
        HTMLLocationDisplay = new JTextArea();
        HTMLLocationDisplay.setEditable(false);
        scheduleBrowseButton = new JButton("Browse");
        scheduleBrowseButton.addActionListener((ActionEvent ae) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.html", "html"));
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                scheduleFile = chooser.getSelectedFile();
                try {
                    scheduleLocation = scheduleFile.getCanonicalPath();
                    HTMLLocationDisplay.setText(scheduleLocation);
                } catch (IOException ex) {
                    Logger.getLogger(choosePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("No Selection ");
            }
        });

//********************END CODE FOR HTML BUTTONS, LABELS, AND TEXT AREA********************//

//********************START CODE FOR DESCRIPTION BUTTONS, LABELS, AND TEXT AREA********************//    
        descriptionLabel = new JLabel("Choose location of Descriptions.txt");
        DescriptionLocationDisplay = new JTextArea();
        DescriptionLocationDisplay.setEditable(false);
        descriptionBrowseButton = new JButton("Browse");
        descriptionBrowseButton.addActionListener((ActionEvent ae) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                descriptionFile = chooser.getSelectedFile();
                try {
                    descriptionLocation = descriptionFile.getCanonicalPath();
                    DescriptionLocationDisplay.setText(descriptionLocation);
                } catch (IOException ex) {
                    Logger.getLogger(choosePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("No Selection ");
            }
        });

//********************START CODE FOR Sorted LOCATION BUTTONS, LABELS, AND TEXT AREA********************//            
        SortedLocationLabel = new JLabel("Choose where to place the sorted file");
        SortLocationDisplay = new JTextArea();
        SortLocationDisplay.setEditable(false);
        sortedBrowseButton = new JButton("Browse");
        sortedBrowseButton.addActionListener((ActionEvent ae) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                SortLocationDisplay.setText(chooser.getSelectedFile().getAbsolutePath());
                sortLocation = chooser.getSelectedFile().getAbsolutePath() + "/WeeklySchedule.csv";
            } else {
                System.out.println("No Selection ");
            }
        });
//********************END CODE FOR Sorted LOCATION BUTTONS, LABELS, AND TEXT AREA********************//    

//********************************START CODE FOR OKAY BUTTON********************************//
        ButtonOkay = new JButton("Okay");
        ButtonOkay.addActionListener((ActionEvent ae) -> {
            if (scheduleLocation != null || descriptionLocation != null || sortLocation != null) {
                try {
                    ParseHTML PH = new ParseHTML(scheduleFile, sortLocation);
                    PrepareFile PF = new PrepareFile(sortLocation);
                    SortPreparedFile SPF = new SortPreparedFile(sortLocation, descriptionLocation);

                    PH.ParseHTML();
                    PF.modifyMonth();
                    PF.removeWeekday();
                    PF.modifiyDay();
                    SPF.sort();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(HTMLSorterGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(HTMLSorterGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.exit(0);
            }
            System.exit(0);
        });
//********************************END CODE FOR OKAY BUTTON********************************//

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
