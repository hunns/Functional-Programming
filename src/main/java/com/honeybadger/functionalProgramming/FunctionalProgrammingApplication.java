package com.honeybadger.functionalProgramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

@SpringBootApplication
public class FunctionalProgrammingApplication {

    public static void main(String[] args) {

        SpringApplication.run(FunctionalProgrammingApplication.class, args);
//		BiFunction<Integer,Integer,Integer> addNumber=
//				(toNumber, byNumber)-> toNumber + byNumber;
//
//		BiFunction<Integer,Integer,Integer> multiplyNumber=
//				(toNumber, byNumber)-> toNumber + byNumber;
//
//		addNumber.andThen(multiplyNumber).apply(1)

        List<String> names = new ArrayList<>();
        names = Arrays.asList("One", "Two", "Three");
        List<Long> phoneNumbers = new ArrayList<>();
        phoneNumbers = Arrays.asList(123345L, 234567L, 345678L);

        BiFunction<String, Long, String> clubLists = (a, b) -> a + "-"+ b;

        List<String> namesAndPhoneNumbers = new ArrayList<>();
        namesAndPhoneNumbers = listCombiner(names, phoneNumbers, clubLists);
        System.out.println(namesAndPhoneNumbers);
    }


    private static <T, U, R> List<R> listCombiner(
            List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
