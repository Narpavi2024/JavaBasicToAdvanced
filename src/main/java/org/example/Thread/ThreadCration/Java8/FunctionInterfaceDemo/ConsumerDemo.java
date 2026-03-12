package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
//        Consumer<Integer> consumer = (t) -> System.out.println("Printing is "+t);
//        consumer.accept(10);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(t -> System.out.println("Print is "+t));
    }
}
