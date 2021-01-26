package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //region INSERT
    @GetMapping("/add")
    public ModelAndView showInsertForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/add")
    public String insertCustomer(@ModelAttribute("customer") Customer customer) {
//    public ModelAndView insertCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String address) {
        customerService.save(customer);
//        Customer customer = new Customer(name, email, address);
//        ModelAndView modelAndView = new ModelAndView("add");
//        modelAndView.addObject("message", "Insert OK");
//        return modelAndView;
        return "redirect:/customers";
    }
    //endregion
    @GetMapping
    public ModelAndView showAllCustomer(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
}
