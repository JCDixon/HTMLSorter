package htmlsorter.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author John
 */
public class prevPanel extends JPanel {

    private final JButton prevButtonNo;
    private final JButton prevButtonYes;
    private final JLabel prevHTMLLabel;
    private final JLabel prevDescriptionLabel;
    private final JLabel prevSortedLocationLabel;
    private final JLabel reuseTheseSettingsLabel;
    private JTextArea prevHTMLLocationDisplay;
    private JTextArea prevDescriptionDisplay;
    private JTextArea prevSortLocationDisplay;
    private String scheduleLocation;
    private String descriptionLocation;
    private String sortLocation;

    public prevPanel() {

        prevButtonNo = new JButton("No");
        prevButtonYes = new JButton("Yes");
        prevHTMLLabel = new JLabel("Previous location of WeeklySchedule.html");
        prevHTMLLocationDisplay = new JTextArea();
        prevHTMLLocationDisplay.setEditable(false);
        prevDescriptionLabel = new JLabel("Previous location of Descriptions.txt");
        prevDescriptionDisplay = new JTextArea();
        prevSortedLocationLabel = new JLabel("Previous location of sorted file");
        prevSortLocationDisplay = new JTextArea();
        prevSortLocationDisplay.setEditable(false);
        reuseTheseSettingsLabel = new JLabel("Would you like to reuse your previous settings?");

        this.setLayout(new GridLayout(9, 1));
        addComponents();
    }

    private void addComponents() {
        this.add(reuseTheseSettingsLabel);
        this.add(prevHTMLLabel);
        this.add(prevHTMLLocationDisplay);
        this.add(prevDescriptionLabel);
        this.add(prevDescriptionDisplay);
        this.add(prevSortedLocationLabel);
        this.add(prevSortLocationDisplay);
        this.add(prevButtonNo);
        this.add(prevButtonYes);
    }
}
