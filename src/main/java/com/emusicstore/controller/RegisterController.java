package com.emusicstore.controller;

import com.emusicstore.model.BillingAddress;
import com.emusicstore.model.Customer;
import com.emusicstore.model.ShippingAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.java2d.pipe.ShapeSpanIterator;

/**
 * Created by parvinder.kumar on 20-01-2017.
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public String registerCustomer(Model model){
        Customer customer=new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress=new ShippingAddress();

        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer",customer);

        return "registerCustomer";

    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerCustomer(@ModelAttribute("customer") Customer customer, Model model) {

        customer.setEnabled(1);
        customerService.addCustomer();

        return "/registerCustomerSuccess";
    }
}
