package com.enorkus.academy.validation;

import com.enorkus.academy.entity.CountryCode;
import com.enorkus.academy.exception.CustomerNotAdultException;
import com.enorkus.academy.exception.InvalidCountryCodeException;
import com.enorkus.academy.exception.MandatoryValueMissingException;

public class CustomerValidation {

    public CustomerValidation() {
    }

    public void validateMandatoryValues (String firstName, String lastName, String personalNumber){
        if (firstName == null || firstName.trim().isEmpty())
            throw new MandatoryValueMissingException("First name is empty");
        if (lastName == null || lastName.trim().isEmpty())
            throw new MandatoryValueMissingException("Last name is empty");
        if (personalNumber == null || personalNumber.trim().isEmpty())
            throw new MandatoryValueMissingException("Personal number is empty");
    }

    public void validateAge (int age) {
        if (age<18)
            throw new CustomerNotAdultException("Age is less than 18!");
    }

    public void validateCountryCode (String countryCode){
        if (!countryCode.equals(CountryCode.LT.name())&&!countryCode.equals(CountryCode.LV.name())&&
                !countryCode.equals(CountryCode.EE.name())&&!countryCode.equals(CountryCode.SE.name())&&
                !countryCode.isEmpty()){
            throw new InvalidCountryCodeException("Country code should be LT,LV,EE,SE or empty");
        }
    }
}
