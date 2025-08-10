package org.ictkerala.inventorysystem;

public class InventoryItem {

    public int id;
    public String name;
    public int quantity;
    public int supplierId;

    public InventoryItem(int id, String name, int quantity, int supplierId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }
    
    // Constructor for adding a new item without an ID
    public InventoryItem(String name, int quantity, int supplierId) {
        this(0, name, quantity, supplierId);
    }

    public InventoryItem() {
        // Default constructor
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Supplier ID: " + supplierId;
    }
}