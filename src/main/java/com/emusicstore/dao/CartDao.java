package com.emusicstore.dao;

import com.emusicstore.model.Cart;

/**
 * Created by parvinder.kumar on 15-01-2017.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String  cartId);

    void update(String  cartId,Cart cart);

    void delete(String  cartId);
}
