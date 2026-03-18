package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.MethodReferenceExample;



import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        EmployeeService  employeeService = new EmployeeService();

        //anonymous implementation
//        employeeService.loadEmployeesfromDB().forEach(new Consumer<Employee>() {
//            @Override
//            public void accept(Employee employee) {
//                System.out.println(employee);
//            }
//        });

        //lamda expression

       // employeeService.loadEmployeesfromDB().forEach(employee -> System.out.println(employee));

        //Method Reference
     //   employeeService.loadEmployeesfromDB().forEach(MethodReferenceDemo::print);

        //Method Reference wit predefined class
        //employeeService.loadEmployeesfromDB().forEach(System.out::print);

//        List<EmployeeDAO> employeedos = employeeService.loadEmployeesfromDB().stream().map(new Function<Employee, EmployeeDAO>() {
//            @Override
//            public EmployeeDAO apply(Employee employee) {
//                EmployeeDAO employeeDAO = new EmployeeDAO();
//                employeeDAO.setId(employee.getId());
//                employeeDAO.setName(employee.getName());
//                employeeDAO.setSalary(employee.getSalary());
//                return employeeDAO;
//            }
//        }).collect(Collectors.toList());
//        List<EmployeeDAO> employeedos = employeeService.loadEmployeesfromDB().stream().map( (employee)-> {
//                EmployeeDAO employeeDAO = new EmployeeDAO();
//                employeeDAO.setId(employee.getId());
//                employeeDAO.setName(employee.getName());
//                employeeDAO.setSalary(employee.getSalary());
//                return employeeDAO;
//        }).collect(Collectors.toList());
//        List<EmployeeDAO> employeedos = employeeService.loadEmployeesfromDB().stream()
//        .map(EmployeeMapper::convert).collect(Collectors.toList());//static method reference
        EmployeeMapper employeeMapper = new EmployeeMapper();
        List<EmployeeDAO> employeedos = employeeService.loadEmployeesfromDB().stream()
                .map(employeeMapper::convert1).collect(Collectors.toList()); //instance method reference
        System.out.println(employeedos);

        List<String> namelist = employeeService.loadEmployeesfromDB().stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(namelist);

        EmployeeManager employeeManager = Employee::new;
        employeeManager.getEmployee().getEmployeeInfo();
    }

    private static void print(Employee employee) {
        System.out.println(employee);
    }

}
