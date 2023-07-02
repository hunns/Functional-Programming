package com.honeybadger.functionalProgramming.genericWayFunction;


import java.util.Optional;
import java.util.function.Function;

public class GenericWayFunction {
    public static void main(String[] args) {
        Function<String, String> getSecondWord = paramString ->paramString.split(" ").length >= 1 ? paramString.split(" ")[1] : null;
        Function<String, Integer> getWordCount = paramString -> paramString.length();

        System.out.println(getSecondWord.
                andThen(getWordCount).
                apply("One TwentyTwo"));
        System.out.println("----------1--------------");

        Optional.ofNullable(getSecondWord.apply("Hunns Sailaja"))
                .map(getWordCount)
                .ifPresent(System.out::println);

        System.out.println("-----------2-------------");

        Optional.ofNullable(getSecondWord.apply("Hunns Sailaja"))
                .ifPresent(t->{System.out.println(getWordCount.apply(t));
                });


    }
}
