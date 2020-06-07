package com.goce.lambdabasics;

public class ThreadableLambda {

    public static void main(String args[]){
        Thread myThread = new Thread(() -> System.out.println("Runnable Thread via Lambda"));
        myThread.run();

        Thread t = new Thread(() -> printMessage());
        t.start();

        t = new Thread(ThreadableLambda::printMessage);
        t.start();

    }

    public static void printMessage(){
        System.out.println("Hello from printMessage with method reference thread");
    }
}
