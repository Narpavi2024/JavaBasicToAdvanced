package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.ParallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

    public static List<Employee> getEmployees(){
      List<Employee> employeeList = new ArrayList<>();
      for (int i=1;i<=1000;i++){
          employeeList.add(new Employee(i,"Employee"+i,"A", (double) new Random().nextInt(1000 * 100)));
      }
      return employeeList;
    }
}
