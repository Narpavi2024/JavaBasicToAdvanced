package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.concurrent.*;

public class RunAsyncDemo {

    public Void saveEmployees(File jsonfile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        CompletableFuture<Void> runAsyncFuture =  CompletableFuture.runAsync(()->{
            try{
                List<Employee> employees = objectMapper.readValue(jsonfile, new TypeReference<List<Employee>>() {
                });
                //write logic t save list of employee to database
                //repository.saveAll(employees);
                System.out.println("Thread :"+Thread.currentThread().getName());
                System.out.println("Employees Size :"+employees.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return runAsyncFuture.get();
    }

    public void saveEmployeesWithCustomExecutor(File jsonfile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExecutorService executors =  Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
            List<Employee> employees = objectMapper.readValue(jsonfile, new TypeReference<List<Employee>>() {
            });
                System.out.println("Thread :"+Thread.currentThread().getName());
                System.out.println("Employee Size :"+employees.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, (Executor) executors);
        completableFuture.get();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
        runAsyncDemo.saveEmployees(new File("employees.json"));
        runAsyncDemo.saveEmployeesWithCustomExecutor(new File("employees.json"));

    }
}
