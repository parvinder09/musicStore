package com.emusicstore.controller;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;
import com.emusicstore.service.CartItemService;
import com.emusicstore.service.CartService;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.dao.SystemWideSaltSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * Created by parvinder.kumar on 21-01-2017.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;


    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public @ResponseBody
    String greeting() {
        return "testing rest";
    }




    @RequestMapping(value = "/{cartId}")
    public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId){
        System.out.println("testing cart rest");
        return  cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public  void addItem(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser){
        Customer customer=customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart=customer.getCart();
        Product product=productService.getProductById(productId);
        List<CartItem> cartItems=cart.getCartItems();

        for (int i=0;i<cartItems.size();i++){
            if(product.getProductId()==cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem=cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
            }
        }
        CartItem cartItem= new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        System.out.print("add cart");

    }

    @RequestMapping(value = "/remove/productId",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable("productId") int productId){
        CartItem cartItem=cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartId}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable("catdId") int cartId){
        Cart cart=cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Illegal request,Please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Internal Server Error")
    public void handleServerError(Exception e){}

}
