package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CombineCompletableFutureDemo {

    public CompletableFuture<Employee> getEmployeeDetails(){

        return CompletableFuture.supplyAsync(()->{
            System.out.println("getEmployeeDetails() " + Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployee().stream()
                    .filter(emp -> "79-021-3776".equals(emp.getEmployeeId()))
                    .findAny().orElse(null);

        });

    }
    public CompletableFuture<Integer> getRatings(Employee employee){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("getRatings() " + Thread.currentThread().getName());
            return employee.getRating();
        });
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //combine dependent future (2) -> thenCompose

        //employee -> ratings
        CombineCompletableFutureDemo demo = new CombineCompletableFutureDemo();

        CompletableFuture<Integer> themcomposeresult = demo.getEmployeeDetails()
                .thenCompose(demo::getRatings);
        System.out.println("ratings :"+themcomposeresult.get());


        //combine independent future (2) -> thenCombine
        //1-  group employee and counts

        CompletableFuture<Map<String,Long>> empmapfuture = CompletableFuture.supplyAsync(()->{
            return EmployeeDatabase.fetchEmployee().stream()
                    .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

        });

        //2- get all emails

        CompletableFuture<List<String>> emailfuture = CompletableFuture.supplyAsync(()->{

            return EmployeeDatabase.fetchEmployee().stream().map(Employee::getEmail).collect(Collectors.toList());
        });

        CompletableFuture<String> thencombineresult = empmapfuture
                .thenCombine(emailfuture,(emmap,email)->emmap + " "+email);
        System.out.println(thencombineresult.get());

        //combine multiple independent future (more than 2) -> allOf(n task)
        //-> weatherDetailsAPI
        //-> news apis
        //-> stockPrice apis


        //combine multiple independent future (more than 2) -> anyOf(n task) (no need to wait for all)
        //Location -> X Y -> result
        //stock price -> x ,y , z ->
    }
}
