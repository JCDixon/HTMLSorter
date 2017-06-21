/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package htmlsorter;
import htmlsorter.ui.*;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class HTMLSorter {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            HTMLSorterGUI.start();
        });
    }
}
