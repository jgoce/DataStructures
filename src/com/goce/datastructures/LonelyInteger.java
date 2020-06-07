package com.goce.datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LonelyInteger {

    public static void main(String args[]){
        int[] numbersL = {9,1,2,3,2,9,1,7,7};

        int[] copyArray = Arrays.copyOf(numbersL, numbersL.length * 2);

        int result = 0;
        for(int value : numbersL){
            result ^= value;
        }

        System.out.println(result);
    }
}
