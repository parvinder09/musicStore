package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by parvinder.kumar on 21-01-2017.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    private SessionFactory sessionFactory;


    public Cart getCartById(int cartId) {
        Session session=sessionFactory.getCurrentSession();

        return  session.get(Cart.class,cartId);
    }


    public void update(Cart cart) {

        int cartId = cart.getCartId();
        //to do later
    }
}
