package org.ictkerala.inventorysystem;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuDriven {

    public MenuDriven() {
        JFrame frame = new JFrame("Inventory Dashboard");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // Now 5 rows for the new button

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(e -> new InventoryItemGUI());
        panel.add(addButton);
        
        // New button for adding suppliers
        JButton addSupplierButton = new JButton("Add Supplier");
        addSupplierButton.addActionListener(e -> new SupplierGUI());
        panel.add(addSupplierButton);

        JButton viewButton = new JButton("View Items");
        viewButton.addActionListener(e -> new ViewItemsGUI());
        panel.add(viewButton);

        JButton reportButton = new JButton("View Reports");
        reportButton.addActionListener(e -> new ViewReportsGUI());
        panel.add(reportButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuDriven::new);
    }
}