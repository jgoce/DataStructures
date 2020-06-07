package com.goce.lambdabasics;

public class ThisReferenceExample {

    public static void main(String args[]){
        int a = 10;
        int b = 20, c = 30;

        // closure 
        doProcess(a, new Process() {

            @Override
            public void process(int i) {
                System.out.println(i + b);
                System.out.println(this);
            }

            public String toString(){
                return "This is anonymous inner class";
            }
        });

        // lambda closure
        doProcess(a, (i) -> {
            System.out.println(i + c);
        });
    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }
}
