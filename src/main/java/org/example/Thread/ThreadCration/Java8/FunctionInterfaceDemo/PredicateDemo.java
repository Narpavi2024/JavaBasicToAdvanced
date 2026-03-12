package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
//        Predicate<Integer> predicate = t -> t%2 == 0;
////        System.out.println(predicate.test(5));

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream();
        list.stream().filter(t -> t%2 == 0).forEach(t -> System.out.println("Print is "+t));
    }
}
