package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private MemoryCustomerRepository memoryCustomerRepository = new MemoryCustomerRepository();

    public MainController() {

    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers()
    {

        return memoryCustomerRepository.findAll();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        memoryCustomerRepository.insert(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        memoryCustomerRepository.deleteById(customerId);
    }
}