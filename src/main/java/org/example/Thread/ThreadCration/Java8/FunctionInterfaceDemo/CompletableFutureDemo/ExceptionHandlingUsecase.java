package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandlingUsecase {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture.supplyAsync(()->{
//            // Code which might throw an exception
//            gracefullyShutDown("");
//            return "Some Result";
//        }).thenApply(result -> {
//            return "processed result";
//        }).thenApply(result -> {
//            return "result after further processing";
//        }).thenAccept(result -> {
//            // do something with the final result
//        });

        //update employee db
        CompletableFuture<String> employeeDataFuture = CompletableFuture.supplyAsync(()->{
            // gracefullyShutDown("Employee");
            return "Employee information update in DB";
        });
//                .exceptionally(ex -> {
//            System.out.println("unable to update employee information in DB");
//                    return "500 Internal Server Error";
//        });

        CompletableFuture<String>  employeedocumentfuture = CompletableFuture.supplyAsync(()->{
           // gracefullyShutDown("S3");
            return "Employee document update in S3";
        });
//                .exceptionally(ex->{
//                    System.out.println("unable to update employee document in s3");
//                    return "500 Internal Server Error";
//                });

        CompletableFuture<String>  combinefuture = employeeDataFuture.thenCombine(employeedocumentfuture,(result1,result2)->{
            return result1 + "\n" + result2;
        }).handle((res,ex)->{
            if(ex!=null){
                System.out.println("An error occurred during processing employee data " + ex.getMessage());
                return "Operation Failed ! ";
            }
            return res;
        });

        System.out.println(combinefuture.get());
        //update employee document to S3
    }
    public static void gracefullyShutDown(String apiname){
        throw new RuntimeException(apiname + " service temporarily unavailable. Please try again later.");
    }
}
