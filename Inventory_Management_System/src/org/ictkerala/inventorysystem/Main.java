package org.ictkerala.inventorysystem;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuDriven::new);
    }
}