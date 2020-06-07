package com.goce.lambdabasics;

import java.util.ArrayList;
import java.util.Collections;

public class Greeter {

    public static void main(String args[]){

        MyLambda greetingFunction = (s) -> s.length();
        MyAdd mathCalc = (int a, int b) ->  a + b;

        System.out.println("Hello World length = " + greetingFunction.perform("Hello World"));
        printHello(s -> s.length());

        System.out.println(mathCalc.addNumbers(35,20));

        IGreeting inGreeting = () -> System.out.println("FunctionInterface Hello World");
        inGreeting.perform();

    }

    public static void printHello(MyLambda l){
        System.out.println("Hello Lambda = " + l.perform("Hello Lambda"));
    }
}

interface MyLambda {
    int perform(String s);

}

interface MyAdd {
    int addNumbers(int a, int b);
}
