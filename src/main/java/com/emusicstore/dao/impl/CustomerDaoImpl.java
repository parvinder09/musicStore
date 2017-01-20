package com.emusicstore.dao.impl;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Authorities;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by parvinder.kumar on 20-01-2017.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session=sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser=new Users();

        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setCustomerId(customer.getCustomerId());
        newUser.setEnabled(true);

        Authorities authorities=new Authorities();
        authorities.setUsername(customer.getUsername());
        authorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(authorities);

        Cart newCart = new Cart();

        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);


        session.flush();
    }

    public Customer getCustomerById(int customerId) {
        Session session=sessionFactory.getCurrentSession();
        Customer customer=session.get(Customer.class,customerId);
        session.flush();
        return customer;

    }

    public List<Customer> getAllCustomers() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer");
        List<Customer> customers=query.list();
        session.flush();
        return customers;
    }

    public Customer getCustomerByUsername(String username) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer where username=?");
        query.setString(0,username);

        return (Customer) query.uniqueResult();
    }
}
