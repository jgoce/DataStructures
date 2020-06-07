package com.goce.lambdabasics;

public class ClosuresExample {

    public static void main(String args[]){
        int a = 10;
        int b = 20, c = 30;

        // closure
        doProcess(a, new Process() {

            @Override
            public void process(int i) {
                System.out.println(i + b);
            }
        });

        // lambda closure
        doProcess(a, (i) -> System.out.println(i + c));
    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }
}

interface Process {
    void process(int i);
}