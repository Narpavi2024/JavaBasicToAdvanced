package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.Map_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 7, 8, 1, 5, 9);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        int sum = 0;
        for (int num:list){
            sum = sum+num;
        }
       // System.out.println(sum);
        int sum1 = list.stream().mapToInt(i->i).sum();
       // System.out.println(sum1);

        //reduce
        Integer reduceex = list.stream().reduce(0, (a,b)->a+b);
        //System.out.println(reduceex);

        Optional<Integer> reducesum  = list.stream().reduce(Integer::sum);
        //System.out.println(reducesum.get());
        Integer mulreduce = list.stream().reduce(1, (a, b) -> a * b);
       // System.out.println(mulreduce);

        Integer maxvalue = list.stream().reduce(0, (a, b) -> a > b ? a : b);
      //  System.out.println(maxvalue);

        Integer maxwithmethodref = list.stream().reduce(Integer::max).get();
       /// System.out.println(maxwithmethodref);

        Optional<String> longeststring = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        System.out.println(longeststring.get());

        //getEmployee whose grade A
        //getSalary

        Optional<Double> empsalry = Optional.of(EmployeeDatabase.getEmployees().
                stream().filter(e -> e.getGrade().equalsIgnoreCase("A"))
                .map(Employee::getSalary).
                mapToDouble(i -> i).average().getAsDouble());
        empsalry.ifPresent(System.out::println);

        double sumsalary = EmployeeDatabase.getEmployees().stream().filter(e -> e.getGrade().
                equalsIgnoreCase("A")).map(Employee::getSalary).mapToDouble(i -> i).sum();
        System.out.println(sumsalary);


    }
}
