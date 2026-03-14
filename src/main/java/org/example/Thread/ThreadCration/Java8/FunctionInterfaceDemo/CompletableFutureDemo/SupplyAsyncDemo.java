package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {
    public List<Employee> getEmployees() throws ExecutionException,InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("Thread :"+Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployee();

        },executorService);
        return completableFuture.get();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
        List<Employee> employees = supplyAsyncDemo.getEmployees();
        employees.stream().forEach(System.out::println);
    }
}
