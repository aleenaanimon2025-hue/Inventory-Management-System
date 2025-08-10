package org.ictkerala.inventorysystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewItemsGUI extends JFrame {
    private final InventoryManager manager = new InventoryManager();

    public ViewItemsGUI() {
        setTitle("View All Items");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = {"ID", "Name", "Quantity", "Supplier ID"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        List<InventoryItem> items = manager.getAllItems();
        for (InventoryItem item : items) {
            model.addRow(new Object[]{item.id, item.name, item.quantity, item.supplierId});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}