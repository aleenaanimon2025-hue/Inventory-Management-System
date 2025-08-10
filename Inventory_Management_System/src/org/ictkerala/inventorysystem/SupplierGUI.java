package org.ictkerala.inventorysystem;

import javax.swing.*;
import java.awt.*;

public class SupplierGUI extends JFrame {
    private final JTextField nameField = new JTextField(20);
    private final JTextField contactField = new JTextField(20);
    private final InventoryManager manager = new InventoryManager();

    public SupplierGUI() {
        setTitle("Add New Supplier");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Supplier Name:"));
        add(nameField);

        add(new JLabel("Contact:"));
        add(contactField);

        JButton saveButton = new JButton("Save Supplier");
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String contact = contactField.getText();

            if (name.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Supplier supplier = new Supplier(0, name, contact);
            manager.addSupplier(supplier);
            
            JOptionPane.showMessageDialog(this, "Supplier added successfully with ID: " + supplier.id);
            this.dispose(); // Close the window
        });

        add(saveButton);
        add(new JLabel()); // Placeholder

        setVisible(true);
    }
}