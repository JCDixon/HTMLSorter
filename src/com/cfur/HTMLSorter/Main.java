/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 *
 *
 * @author john
 */
package com.cfur.HTMLSorter;

import com.cfur.HTMLSorter.ui.*;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final HTMLSorterWindow wnd = new HTMLSorterWindow();
                wnd.setVisible(true);
            }
        });
    }
}