CREATE DATABASE inventory_db;
USE inventory_db;
CREATE TABLE suppliers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    contact VARCHAR(100)
);

CREATE TABLE items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    quantity INT,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);