package com.honeybadger.functionalProgramming.steams;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _Steams {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Kiran", Gender.MALE),
                new Person("Praveen", Gender.MALE),
                new Person("Malli", Gender.MALE),
                new Person("Rani", Gender.FEMALE),
                new Person("Srividhya", Gender.FEMALE)
        );

        //people.stream().map().toList();

        people.stream()
                .map(a -> a.gender.equals(Gender.MALE) ? "Mr " + a.name : "Ms/Mrs " + a.name)
                .forEach(System.out::println);

        List<Integer> numberList =List.of(1,2,3,4,5,6);
        List<String> numberListString =List.of("1","2","3","4","5","6");

        // Finding sum of all elements
        int sum = numberList.stream()
                //.mapToInt()
                //.range(3, 5)
                .reduce(0,(element1, element2) -> element1 + element2);
        // Displaying sum of all elements




    }


    static class Person {
        private Gender gender;
        private String name;

        public Person(String name, Gender gender) {
            this.gender = gender;
            this.name = name;

        }

    }

    static enum Gender {
        MALE,
        FEMALE;
    }
}
