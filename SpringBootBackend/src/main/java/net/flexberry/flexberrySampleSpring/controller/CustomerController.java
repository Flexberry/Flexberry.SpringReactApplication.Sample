package net.flexberry.flexberrySampleSpring.controller;

import net.flexberry.flexberrySampleSpring.model.Customer;
import net.flexberry.flexberrySampleSpring.service.CustomerService;
import net.flexberry.flexberrySampleSpring.utils.UUIDConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("/customers/{primarykey}")
    public Customer getCustomer(@PathVariable("primarykey") int primaryKey) {
        return service.getCustomer(primaryKey);
    }

    @DeleteMapping("/customers/{primaryKey}")
    public void deleteCustomer(@PathVariable("primaryKey") int primaryKey) {
        service.deleteCustomerByPrimaryKey(primaryKey);
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        service.saveOrUpdateCustomer(customer);
    }

    @PutMapping("/customers")
    public void updateCustomer(@RequestBody Customer customer) {
        service.saveOrUpdateCustomer(customer);
    }

    @InitBinder
    public void initBinder(final WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Customer.class, new UUIDConverter());
    }
}
