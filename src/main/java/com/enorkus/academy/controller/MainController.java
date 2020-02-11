package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private MemoryCustomerRepository memoryCustomerRepository = new MemoryCustomerRepository();

    private CustomerService customerService = new CustomerService();

    public MainController() {

    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers()
    {

        return customerService.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
}