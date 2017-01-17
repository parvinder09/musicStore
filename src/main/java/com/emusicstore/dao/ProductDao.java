package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by parvinder.kumar on 12-01-2017.
 */

public interface ProductDao {

     void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProducts(String id);

    void editProduct(Product product);


}
