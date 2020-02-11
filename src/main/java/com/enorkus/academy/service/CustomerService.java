package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validation.CustomerValidation;

import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository = new MemoryCustomerRepository();

    private CustomerValidation customerValidation = new CustomerValidation();

    public CustomerService() {
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {

       // customerRepository.insert(customer);

        String formattedFirstName = capitalizeFirstLetter(customer.getFirstName());

        String formattedLastName = capitalizeFirstLetter(customer.getLastName());

        String formattedPersonalNumber = addDashToPersonalNumber(customer.getPersonalNumber());

        Customer formattedCustomer = new Customer.CustomerBuilder(formattedFirstName,formattedLastName,formattedPersonalNumber)
        .age(customer.getAge()).city(customer.getCity()).countryCode(customer.getCountryCode()).employer(customer.getEmployer())
        .gender(customer.getGender()).maritalStatus(customer.getMaritalStatus()).middleName(customer.getMiddleName())
        .monthlyIncome(customer.getMonthlyIncome()).build();

        customerValidation.validateMandatoryValues(formattedFirstName,formattedLastName,formattedPersonalNumber);
        customerValidation.validateAge(customer.getAge());
        customerRepository.insert(formattedCustomer);
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    public String capitalizeFirstLetter(String string) {
        if (string != null && !string.isEmpty()) {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
        return null;
    }

    public String addDashToPersonalNumber(String string) {
        if (!string.isEmpty() && string.length() > 3) {
            return string.substring(0, 4) + "-" + string.substring(4);
        }
        return null;
    }
}
