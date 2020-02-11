package com.enorkus.academy.validation;

import com.enorkus.academy.entity.CountryCode;
import com.enorkus.academy.exception.InvalidCountryCodeException;
import com.enorkus.academy.exception.ValidationException;

public class CountryCodeValidator extends Validator<String> {

    @Override
    public void validate(String countryCode, String message) {
        if (!countryCode.equals(CountryCode.LT.name()) && !countryCode.equals(CountryCode.LV.name()) &&
                !countryCode.equals(CountryCode.EE.name()) && !countryCode.equals(CountryCode.SE.name()) &&
                !countryCode.isEmpty()) {
            throw new ValidationException(message);
        }
    }
}
