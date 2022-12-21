package net.flexberry.flexberrySampleSpring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.flexberry.flexberrySampleSpring.db.filter.internal.Condition;
import net.flexberry.flexberrySampleSpring.model.Comment;
import net.flexberry.flexberrySampleSpring.model.Customer;
import net.flexberry.flexberrySampleSpring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
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

    @GetMapping("/filteringCustomers")
    public List<Customer> getCommentsForPeriod(@RequestBody List<Condition> conditions) throws JsonProcessingException {
        return service.getFilteringCustomers(conditions);
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
