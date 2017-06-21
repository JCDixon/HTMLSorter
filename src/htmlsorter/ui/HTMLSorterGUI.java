/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 */
package htmlsorter.ui;
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
        MainFrame.setTitle("WeeklySchedule.html to CSV");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        choosePanel cPanel = new choosePanel();

        MainFrame.add(cPanel, BorderLayout.CENTER);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HTMLSorterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainFrame.setVisible(true);
    }
}
