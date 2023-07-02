package com.honeybadger.functionalProgramming.combinator;

import java.time.LocalDate;

import static com.honeybadger.functionalProgramming.combinator.CustomerCombinatorValidator.*;

public class CombinatorTest {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Lora",
                "lora@gmail.com",
                LocalDate.of(2000, 1, 1),
                "1234567890"
        );

        System.out.println(CustomerCombinatorValidator.isEmailValid().apply(customer));
        System.out.println("---------------------------");
        System.out.println(CustomerCombinatorValidator.isEmailValid().apply(customer));

        System.out.println("---------------------------");
        ValidationResult result = CustomerCombinatorValidator.isEmailValid()
                .add(CustomerCombinatorValidator.isPhoneValid())
                .add(CustomerCombinatorValidator.isAgeValid())
                .apply(customer);
        System.out.println("---------------------------");
        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
