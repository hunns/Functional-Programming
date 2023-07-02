package com.honeybadger.functionalProgramming.combinator;

import org.springframework.cglib.core.internal.Function;

import java.time.LocalDate;
import java.time.Period;


//Creating the set of custom Functional methods and their combinator.

public interface CustomerCombinatorValidator extends
        Function<Customer, CustomerCombinatorValidator.ValidationResult> {

    static CustomerCombinatorValidator isEmailValid() {
        return customer -> {
            System.out.println("In IsEmailValid.....");
            return customer.getEmail().contains("@") ?
            ValidationResult.SUCCESS :
            ValidationResult.EMAIL_NOT_VALID;
        };
    }


    static CustomerCombinatorValidator isPhoneValid() {
        return customer -> {
            System.out.println("In isPhoneValid.....");
            return customer.getPhoneNumber().length() >= 10?
                ValidationResult.SUCCESS :
                ValidationResult.PHONE_NOT_VALID;
        };
    }

    static CustomerCombinatorValidator isAgeValid() {
        return customer -> {
            System.out.println("In isAgeValid.....");
            return Period.between(customer.getDOB(), LocalDate.now()).getYears() > 16 ?
                    ValidationResult.SUCCESS :
                    ValidationResult.AGE_NOT_VALID;
        };
    }
    default CustomerCombinatorValidator add(CustomerCombinatorValidator other) {
        return customer -> {
            System.out.println("In add.....");
            //Lets say if we use
            // ValidationResult result = CustomerCombinatorValidator.isEmailValid()
            //                .add(CustomerCombinatorValidator.isPhoneValid())
            //                .add(CustomerCombinatorValidator.isAgeValid())
            //                .apply(customer);
            // below this.apply will run for IsEmailValid

            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }
    enum ValidationResult {
        SUCCESS,
        EMAIL_NOT_VALID,
        AGE_NOT_VALID,
        PHONE_NOT_VALID
    }
}