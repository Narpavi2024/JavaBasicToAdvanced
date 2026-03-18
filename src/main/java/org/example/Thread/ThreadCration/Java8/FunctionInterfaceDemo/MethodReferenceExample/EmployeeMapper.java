package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.MethodReferenceExample;

public class EmployeeMapper {

    public static EmployeeDAO convert(Employee employee){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setId(employee.getId());
        employeeDAO.setName(employee.getName());
        employeeDAO.setSalary(employee.getSalary());
        return employeeDAO;
    }
    public  EmployeeDAO convert1(Employee employee){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setId(employee.getId());
        employeeDAO.setName(employee.getName());
        employeeDAO.setSalary(employee.getSalary());
        return employeeDAO;
    }
}
