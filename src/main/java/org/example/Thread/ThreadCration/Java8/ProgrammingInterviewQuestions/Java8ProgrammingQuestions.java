package org.example.Thread.ThreadCration.Java8.ProgrammingInterviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8ProgrammingQuestions {

    public static void main(String[] args) {
        //1.Java program count the occurance of each character in the string
        //ex:ilovejavatechie
        //o/p: a = 2,c=1,t=1,e=3,v=2,h=1,i=2,j=1,l=1,o=1
        String input = "ilovejavatechie";
        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> collect1 = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        //2.To find all the duplicate element from a given string

        List<String> duplicate = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(duplicate);
        //3.FInd all the unique element from a given String
        List<String> unique = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(unique);

        //4.Find first non repeating element from a given string
        String nonrepeat = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .findFirst().get().getKey();
        //5.Find first  repeating element from a given string
        String repeat = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .findFirst().get().getKey();
        System.out.println(repeat);

        //6.Find second highest number from given array
        int[] num = {5,9,11,2,8,21,1};
        Integer scndhighestnum = Arrays.stream(num).boxed()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(scndhighestnum);
        //7.TO find longest string from given array
        String[] strarr = {"java","techie","springboot","microservices"};
        String longeststr = Arrays.stream(strarr).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println(longeststr);

        //8.To find all elements from arrays who sart with 1
        List<String> strlist = Arrays.stream(num).boxed().map(s -> s + "")
                .filter(s -> s.startsWith("1")).collect(Collectors.toList());
        System.out.println(strlist);

        //9.String.join

        List<String> list = Arrays.asList("1","2","3","4");
        String result = String.join(",", list);
        System.out.println(result);

        //10.skip and limit use case based example

        IntStream.rangeClosed(1,10).skip(1).limit(8).forEach(System.out::println);


    }
}
