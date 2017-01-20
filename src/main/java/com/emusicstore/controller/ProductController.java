package com.emusicstore.controller;

import com.emusicstore.model.Product;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by parvinder.kumar on 19-01-2017.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products=productService.getProductList();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProducts(@PathVariable("productId") int productId,Model model){
        Product product=productService.getProductById(productId);
        model.addAttribute("product",product);
        return "viewProduct";
    }


}
