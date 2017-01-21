package com.emusicstore.service;

import com.emusicstore.model.Cart;

/**
 * Created by parvinder.kumar on 21-01-2017.
 */
public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
