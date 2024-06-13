package org.example.db;

import org.example.model.Product;

import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn = null;

    public ProductDB() {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:PORT/database", "username", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void save(Product product) {

        String query = "INSERT INTO tablename (name, type, location, warranty) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setString(3, product.getLocation());
            statement.setInt(4, product.getWarranty());

            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        String query = "SELECT name, type, location, warranty FROM products";

        try {
            PreparedStatement statement = conn.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setLocation(rs.getString(3));
                p.setWarranty(rs.getInt(4));

                products.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getByLocation(String location) {

        List<Product> products = new ArrayList<>();

        String query = "SELECT name, type, warranty FROM products WHERE location = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, location);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
            throw new RuntimeException(e);
        }

        return products;
    }
}

















