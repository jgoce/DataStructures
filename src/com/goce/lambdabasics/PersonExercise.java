package com.goce.lambdabasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PersonExercise {

    public static  List<Person> people = Arrays.asList(
            new Person("Sally", "Jankovski", 30),
            new Person("Goce", "Jankovski", 35),
            new Person("Annie", "Jankovski", 8),
            new Person("Melina", "Jankovski", 12)
    );

    public static void main(String args[]) {



        people.stream()
                .sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                .forEach(System.out::println);

        System.out.println("-----------");

        people.forEach(person -> System.out.println(person));

        System.out.println("-----------");

        Stream.of(4, 2, 5)
                .sorted()
                .forEach(System.out::println);

        // 1. Sort List by First Name
        Collections.sort(people,(p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // 2. Create a method that prints all
        people.stream()
                .filter(p -> p.getLastName().startsWith("J"))
                //.filter(j -> j.getFirstName().startsWith("G"))
                .forEach(System.out::println);


        List<Person> result1 = people.stream()
                .map(p -> {
                    Person obj = new Person(p.getFirstName(), p.getLastName(), p.getAge());
                    return obj;
                })
                .collect(Collectors.toList());
        // .forEach(System.out::println));

        System.out.println(result1);

        // 3. Print all persons with lastname starting with J





    }
}
