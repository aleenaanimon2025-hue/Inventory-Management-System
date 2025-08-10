package org.ictkerala.inventorysystem;

import javax.swing.*;
import java.awt.*;

public class InventoryItemGUI extends JFrame {
    private final JTextField nameField = new JTextField(20);
    private final JTextField quantityField = new JTextField(20);
    private final JTextField supplierIdField = new JTextField(20);
    private final InventoryManager manager = new InventoryManager();

    public InventoryItemGUI() {
        setTitle("Add Inventory Item");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close this window, not the whole application

        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Item Name:"));
        add(nameField);

        add(new JLabel("Quantity:"));
        add(quantityField);

        add(new JLabel("Supplier ID:"));
        add(supplierIdField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                int supplierId = Integer.parseInt(supplierIdField.getText());

                InventoryItem item = new InventoryItem(name, quantity, supplierId);
                manager.addItem(item);

                JOptionPane.showMessageDialog(this, "Item added successfully!");
                this.dispose(); // Close the window after saving
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Quantity and Supplier ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(saveButton);
        add(new JLabel()); // Placeholder for a button on the same row

        setVisible(true);
    }
}