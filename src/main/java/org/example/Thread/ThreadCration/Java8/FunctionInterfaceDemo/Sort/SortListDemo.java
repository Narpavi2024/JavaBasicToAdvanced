package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.Sort;

import org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.ForEachRealEx.Database;
import org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.ForEachRealEx.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(3);
        list.add(12);
        list.add(4);

       // Collections.sort(list); ASC
        //Collections.reverse(list); DESC
//        System.out.println(list);
        //list.stream().sorted().forEach(System.out::println);
        //list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Employee> employees = Database.getEmployee();
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return (int) (o2.getSalary()- o1.getSalary());
//            }
//        });
//        Collections.sort(employees,(o1,o2) -> (int)(o1.getSalary()-o2.getSalary()));
//        System.out.println(employees);
        //Using Stream
//        employees.stream().sorted((o1,o2)->(int)(o2.getSalary()-o1.getSalary())).forEach(System.out::println);
      //  employees.stream().sorted(Comparator.comparing(e->e.getSalary())).forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);


    }
}
