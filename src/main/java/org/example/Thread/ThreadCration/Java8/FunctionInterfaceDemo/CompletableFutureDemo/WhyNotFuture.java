package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
       Future<List<Integer>> future = executorService.submit(()->{
            System.out.println("Thread :"+Thread.currentThread().getName());
          // Thread.sleep(5000);
           //System.out.println(10/0);
            return Arrays.asList(1,2,3,4);
        });
       List<Integer> list = future.get();
        System.out.println(list);

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.get();
        completableFuture.complete("return dummy data");
    }
}
