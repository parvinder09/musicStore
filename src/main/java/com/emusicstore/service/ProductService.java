package com.emusicstore.service;

import com.emusicstore.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by parvinder.kumar on 19-01-2017.
 */
public interface ProductService {

     List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);


}
