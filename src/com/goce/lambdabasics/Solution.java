package com.goce.lambdabasics;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {

        double tipCost = Math.round((meal_cost * tip_percent)/100);
        double taxCost = Math.round((meal_cost * tax_percent)/100);

        int total = (int) Math.round((meal_cost + tipCost + taxCost));

        System.out.println(total);

        System.out.println(meal_cost);
        System.out.println(tipCost);
        System.out.println((tax_percent*.100));
        System.out.println(total);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = 10.25; //scanner.nextDouble();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = 17;//scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = 5;//scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);

        scanner.close();
    }
}

