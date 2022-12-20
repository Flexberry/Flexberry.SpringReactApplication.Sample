package net.flexberry.flexberrySampleSpring.service;

import net.flexberry.flexberrySampleSpring.model.Customer;
import net.flexberry.flexberrySampleSpring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public Customer getCustomer(UUID primarykey) {
        return repository.findById(primarykey).orElse(null);
    }

    public void saveOrUpdateCustomer(Customer customer) {
        repository.save(customer);
    }

    public void deleteCustomerByPrimaryKey(UUID primarykey) {
        repository.deleteById(primarykey);
    }
}
