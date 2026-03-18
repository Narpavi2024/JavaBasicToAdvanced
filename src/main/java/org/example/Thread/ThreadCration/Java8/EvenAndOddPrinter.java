package org.example.Thread.ThreadCration.Java8;

import org.example.Thread.ThreadCration.InterviewQuestions.InterviewMain;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenAndOddPrinter {
    private static Object object = new Object();

    private static IntPredicate evencondition = e -> e%2 == 0;
    private static IntPredicate oddcondition = e -> e%2 !=0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenAndOddPrinter.printResults(oddcondition));
        CompletableFuture.runAsync(() -> EvenAndOddPrinter.printResults(evencondition));
        Thread.sleep(1000);

    }

    public static void printResults(IntPredicate condition){
        IntStream.rangeClosed(1,10)
                .filter(condition)
                .forEach(EvenAndOddPrinter::execute);
    }

    public static void execute(int i){
      synchronized (object){
          try {
              System.out.println("Thread name "+Thread.currentThread().getName()+" :"+i);
              object.notify();
              object.wait();
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }
    }
}
