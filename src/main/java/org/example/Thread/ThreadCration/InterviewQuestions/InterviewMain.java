package org.example.Thread.ThreadCration.InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewMain {
    public static void main(String[] args) {
//        1.Differnce b/w Collection and Stream
        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Orange");
        list.add("mango");
//        System.out.println(list);
//        list.remove(3);
//        System.out.println("After remove "+list);

        //External iteration for collections
//        for (int i=0;i< list.size();i++){
//            System.out.println(list.get(i));
//        }

        //Using java 8 lambda
        //list.forEach(System.out::println);

        List<String> lines = Arrays.asList("Java","C","Python");

        List<String> result = lines.stream().filter(e -> !e.equals("C")).collect(Collectors.toList());

        result.forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(4, 2, 8, 9, 5, 6, 7);
//
//        Stream<Integer> numbersGreaterThan5 = numbers.stream().filter(i -> i > 5);

//Traversing numbersGreaterThan5 stream first time

       // numbersGreaterThan5.forEach(System.out::println);

//Second time traversal will throw error

//Error : stream has already been operated upon or closed

        //numbersGreaterThan5.forEach(System.out::println);


    }
}
