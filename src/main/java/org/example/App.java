package org.example;

import org.example.model.Product;
import org.example.service.ProductService;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        ProductService productService = new ProductService();

//        productService.addProduct(new Product("MacBook", "Laptop", "L1", 2024));
/*        productService.addProduct(new Product("Inspiron 5510", "Laptop", "D1", 2026));
        productService.addProduct(new Product("Surface", "Laptop", "M1", 2024));
        productService.addProduct(new Product("iPhone 15", "Mobile", "A1", 2025));
        productService.addProduct(new Product("Galaxy S22", "Mobile", "S1", 2026));
        productService.addProduct(new Product("Vivo Book", "Laptop", "L1", 2023));
        productService.addProduct(new Product("Think Pad", "Laptop", "L1", 2024));
        productService.addProduct(new Product("MacBook", "Laptop", "A1", 2025));
        productService.addProduct(new Product("intel core i11 13 Gen", "Processor", "I1", 2028));
        productService.addProduct(new Product("M2", "Processor", "A1", 2025));*/


        // 2
//        List<Product> products = productService.getProducts();

        List<Product> products = productService.getByLocation("A1");

        for (Product p : products) {
            System.out.println(p);
        }


    }
}
