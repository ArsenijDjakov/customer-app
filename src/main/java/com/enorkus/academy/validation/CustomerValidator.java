package com.enorkus.academy.validation;

import com.enorkus.academy.entity.Customer;

public class CustomerValidator {

   private Validator countryCodeValidator = new CountryCodeValidator();
   private Validator customerAdultValidator = new CustomerAdultValidator();
   private Validator mandatoryValueValidator = new MandatoryValueValidator();

    public CustomerValidator() {
    }

    public void validateCustomer (Customer customer){
        countryCodeValidator.validate(customer.getCountryCode(),"Country code should be LT,LV,EE,SE or empty");
        customerAdultValidator.validate(customer.getAge(),"Customer must be 18 or older!");
        mandatoryValueValidator.validate(customer.getFirstName(),"First name is mandatory!");
        mandatoryValueValidator.validate(customer.getLastName(),"Last name is mandatory!");
        mandatoryValueValidator.validate(customer.getPersonalNumber(),"Personal number is mandatory!");
    }
}
