package com.cybertek.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {

        Integer[] numbersArray = {1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> numbersStream = Arrays.stream(numbersArray);

        //  FILTER

        System.out.println("********FILTER********");

        System.out.println(numbersStream.filter(x -> x % 2 != 0).count());

        Stream<String> strStream = Arrays.asList("Apple","Orange","Kiwi","Banana","Apple","Cherry","Mango").stream();
        System.out.println(strStream.filter(str -> str.length() == 5).count());

//        System.out.println(strStream.filter(str -> str.startsWith("A")).count());     //  This will throw an Exception because we can use one Stream just once because we are done with it.

        Arrays.asList("Apple","Orange","Kiwi","Banana","Apple","Cherry","Mango").stream().filter(str -> str.equals("Apple")).forEach(str -> System.out.println(str));

        //  MAP

        System.out.println("********MAP********");

        Arrays.asList("Apple","Orange","Kiwi","Banana","Apple","Cherry","Mango").stream().map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));

        //  DISTINCT

        System.out.println("********DISTINCT********");

        Arrays.asList("Apple","Orange","Kiwi","Banana","Apple","Cherry","Mango").stream().distinct().forEach(str -> System.out.println(str));

        //  SORTED ORDER

        System.out.println("********SORTED ORDER********");

        Arrays.asList(9,7,2,8,5,6,3,1,4).stream().sorted().forEach(number -> System.out.println(number));

        //  SORTED REVERSED ORDER

        System.out.println("********SORTED REVERSED ORDER********");

        Arrays.asList(9,7,2,8,5,6,3,1,4).stream().sorted(Comparator.reverseOrder()).forEach(number -> System.out.println(number));

    }

}
