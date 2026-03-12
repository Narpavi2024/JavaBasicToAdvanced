package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<String> supplier = ()->  "Hi Sabari";
       // System.out.println(supplier.get());
//        List<String> list = Arrays.asList("a","b");
        List<String> list = Arrays.asList();
//        System.out.println(list.stream().findAny().orElseGet(supplier));
        System.out.println(list.stream().findAny().orElseGet(()-> "HI Narpavi"));
    }
}
