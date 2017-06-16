/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 */
package com.mycompany.htmlsorter.ui;

/**
 *
 * @author john
 */
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BrowseButton extends JButton {

    JFileChooser chooser;
    String choosertitle;

    public BrowseButton(String buttonText, String fileType) {
        this.setText(buttonText);
        this.addActionListener((ActionEvent ae) -> {
            chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("*." + fileType, fileType));
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                /*
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println(selectedFile.getName());
                 */
                System.out.println("getCurrentDirectory(): "
                        + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : "
                        + chooser.getSelectedFile());
            } else {
                System.out.println("No Selection ");
            }
        });
    }
}
