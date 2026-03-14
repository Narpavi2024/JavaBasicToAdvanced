package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeReminderService {

    public CompletableFuture<Void> sendReminderToEmployee(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("Fetch Employee :"+Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployee();
        },executorService)
               .thenApplyAsync((employees) -> {
            System.out.println("Filter new joiner Employee :" + Thread.currentThread().getName());

            return employees.stream()
                    .filter(employee -> "True".equalsIgnoreCase(employee.getNewJoiner())).collect(Collectors.toList());


        }, executorService).thenApplyAsync((employees) -> {
                    System.out.println("filter training not complete employee  : " + Thread.currentThread().getName());
                    return employees.stream().filter(employee -> "True".equalsIgnoreCase(employee.getLearningPending())).collect(Collectors.toList());
                },executorService).thenApplyAsync((employees)->{
                    System.out.println("get emails  : " + Thread.currentThread().getName());
                    return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
                },executorService).thenAcceptAsync((emails)->{
                    System.out.println("send email  : " + Thread.currentThread().getName());
                    emails.forEach(EmployeeReminderService::sendEmail);
                },executorService);
        return completableFuture;
    }

    public static void sendEmail(String email){
        System.out.println("sending training reminder email to : " + email);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
      EmployeeReminderService employeeReminderService = new EmployeeReminderService();
      employeeReminderService.sendReminderToEmployee().get();
    }
}
