package com.emusicstore.dao;

import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by parvinder.kumar on 15-01-2017.
 */
@Repository
public class CartDaoImpl implements CartDao {

   private Map<String,Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts=new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot create a cart. Cart with existing id already exists"+
            cart.getCartId()));
        }
        //listOfCarts=new HashMap<String, Cart>();
        System.out.print("create method in cartDaoImpl");

        listOfCarts.put(cart.getCartId(),cart);
        return  cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot update a cart. The cart with existing id does not exists"+
                    cart.getCartId()));
        }
        listOfCarts.put(cartId,cart);
    }

    public void delete(String cartId) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete a cart. The cart with this id does not exist"+
            cartId));
        }
        listOfCarts.remove(cartId);
    }
}
