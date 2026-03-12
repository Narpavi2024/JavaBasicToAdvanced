package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.Sort;

import org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.ForEachRealEx.Employee;

import java.util.*;

public class SortMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("eight",8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("two", 2);

        //traditional way

        List<Map.Entry<String,Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries,(o1,o2)->o1.getValue().compareTo(o2.getValue()));
//        for (Map.Entry<String,Integer> entry:entries){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

        //Using stream
//        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        //map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Map<Employee,Integer> employeeMap = new TreeMap<>((o1,o2)->(int) (o2.getSalary()-o1.getSalary()));
        employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
        employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
        employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
        employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
        employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

        //System.out.println(employeeMap);
        employeeMap.entrySet().stream().sorted(Map.Entry.
                comparingByKey(Comparator.comparing(Employee::getDept).reversed())).forEach(System.out::println);
    }

}
