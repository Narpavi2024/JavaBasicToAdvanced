package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.SkipLimitExample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SkipLimitDemo {
    public static void main(String[] args) throws IOException {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.stream().skip(1).limit(7).forEach(System.out::println);

        System.out.println("===================");

        List<String> list1 = Files.readAllLines(Paths.get("data.txt"));
        list1.stream().skip(1).limit(list1.size()-2).forEach(System.out::println);
    }
}
