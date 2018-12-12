package com.davidhernandeztechpro.examples.java.v8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilteringExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");

        filter(list);
    }

    private static void filter(List<String> stringList) {
        List<String> filteredList = stringList.stream().filter(elt -> elt.contains("e")).collect(Collectors.toList());
        filteredList.forEach(System.out::println);

    }
}
