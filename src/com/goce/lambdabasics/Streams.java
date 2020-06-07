package com.goce.lambdabasics;

import java.util.ArrayList;
import java.util.Collections;

public class Streams {

    public static void main(String args[]){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Goce");
        names.add("Melina");
        names.add("Ben");
        names.add("Annie");
        names.add("Sally");

        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println(names);

    }
}
