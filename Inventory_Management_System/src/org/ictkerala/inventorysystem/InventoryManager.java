package org.ictkerala.inventorysystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    public void addItem(InventoryItem item) {
        try (Connection conn = InventorySystem.getConnection()) {
            String sql = "INSERT INTO items (name, quantity, supplier_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.name);
            stmt.setInt(2, item.quantity);
            stmt.setInt(3, item.supplierId);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.id = generatedKeys.getInt(1);
                }
            }
            System.out.println("Item added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // New method to add a supplier
    public void addSupplier(Supplier supplier) {
        try (Connection conn = InventorySystem.getConnection()) {
            String sql = "INSERT INTO suppliers (name, contact) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, supplier.name);
            stmt.setString(2, supplier.contact);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    supplier.id = generatedKeys.getInt(1);
                }
            }
            System.out.println("Supplier added successfully with ID: " + supplier.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStock(int itemId, int change) {
        try (Connection conn = InventorySystem.getConnection()) {
            String sql = "UPDATE items SET quantity = quantity + ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, change);
            stmt.setInt(2, itemId);
            stmt.executeUpdate();
            System.out.println("Stock updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(int id) {
        try (Connection conn = InventorySystem.getConnection()) {
            String sql = "DELETE FROM items WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Item deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<InventoryItem> getAllItems() {
        List<InventoryItem> items = new ArrayList<>();
        try (Connection conn = InventorySystem.getConnection()) {
            String sql = "SELECT * FROM items";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int supplierId = rs.getInt("supplier_id");
                items.add(new InventoryItem(id, name, quantity, supplierId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}