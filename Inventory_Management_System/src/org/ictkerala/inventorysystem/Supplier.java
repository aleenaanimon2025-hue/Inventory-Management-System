package org.ictkerala.inventorysystem;

public class Supplier {

    public int id;
    public String name;
    public String contact;

    public Supplier(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Contact: " + contact;
    }
}