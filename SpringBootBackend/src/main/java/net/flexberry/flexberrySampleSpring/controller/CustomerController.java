package net.flexberry.flexberrySampleSpring.controller;

import net.flexberry.flexberrySampleSpring.model.Customer;
import net.flexberry.flexberrySampleSpring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("/customers/{primarykey}")
    public Customer getCustomer(@PathVariable("primarykey") UUID primaryKey) {
        return service.getCustomer(primaryKey);
    }

    @DeleteMapping("/customers/{primaryKey}")
    public void deleteCustomer(@PathVariable("primaryKey") UUID primaryKey) {
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
}
