package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class EmployeeDatabase {
    public static List<Employee> fetchEmployee(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("employees.json"),new TypeReference<List<Employee>>(){

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
