package org.example.service;

import org.example.db.ProductDB;
import org.example.model.Product;

import java.util.List;

public class ProductService {

    ProductDB dbConnect = new ProductDB();

    public void addProduct(Product product) {

        dbConnect.save(product);
    }

    public List<Product> getProducts() {

        List<Product> product = dbConnect.getAllProducts();

        return product;
    }

    public List<Product> getByLocation(String location) {

        /*for(Product p: products) {
            if (p.getLocation().equals(location)) {
                return  p;
            }

            return null;
        }*/

        List<Product> products = dbConnect.getByLocation(location);

        return products;
    }
}
