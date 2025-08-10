package org.ictkerala.inventorysystem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class ViewReportsGUI extends JFrame {
    private final InventoryManager manager = new InventoryManager();

    public ViewReportsGUI() {
        setTitle("Inventory Reports");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        List<InventoryItem> items = manager.getAllItems();
        StringBuilder report = new StringBuilder("Current Inventory Report:\n\n");

        if (items.isEmpty()) {
            report.append("No items in inventory.");
        } else {
            for (InventoryItem item : items) {
                report.append(item.toString()).append("\n");
            }
        }

        textArea.setText(report.toString());
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}