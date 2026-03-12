package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Murrit");
        list.add("John");
        list.add("Piter");
        list.add("Marek");
        list.add("Mac");
        for (String s:list){
          //  if(s.startsWith("M"))
           //  System.out.println(s);
        }

        //Using stream
        list.stream().filter(t-> t.startsWith("M")).forEach(System.out::println);

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.entrySet().stream().filter(t-> t.getKey()%2==0).forEach(System.out::println);
    }
}
