package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {



    //need to inject customer service
    @Autowired
    private CustomerService customerService;
    @GetMapping("/list")
    public String listCustomers(Model theModel){


        //get customers from the service
        List<Customer> theCustomers =customerService.getCustomers();

        //add customers to the spring mvc model
        theModel.addAttribute("customers",theCustomers);
        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute for customer
        Customer theCustomer=new Customer();
        theModel.addAttribute("customer",theCustomer);


        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
        return "redirect:/customer/list";
    }


}