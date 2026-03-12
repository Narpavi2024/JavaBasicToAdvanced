package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.ExceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("44","33","abc");
        List<Integer> list1 = Arrays.asList(1,0);
        //list1.forEach(handlegeneric(s-> System.out.println(10/s), ArithmeticException.class));

     //   list.forEach(handlegeneric(s-> System.out.println(Integer.parseInt(s)), NumberFormatException.class));

//        List<Integer> intlist = list.stream().map(Integer::parseInt).collect(Collectors.toList());
//        System.out.println(intlist);
        //list.forEach(ExceptionHandlingExample::printlist);

        //list.forEach(handleexceptionifAny(s-> System.out.println(Integer.parseInt(s))));

        //handle exception for checkedException
        List<Integer> list2 = Arrays.asList(10,20);
        list2.forEach(handleCheckedExceptionConsumer(i->{
             Thread.sleep(i);
            System.out.println(i);
        }));
    }

    public static void printlist(String s){
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception e) {
            System.out.println("Exception :"+e.getMessage());
        }
    }

    static Consumer<String> handleexceptionifAny(Consumer<String> payload){
        return obj ->{
            try {
                payload.accept(obj);

            } catch (Exception e) {
                System.out.println("Exception :"+e.getMessage());
            }
        };
    }

    static <Target,Exobj extends Exception> Consumer<Target> handlegeneric(Consumer<Target> targetConsumer,
                                                                           Class<Exobj> exobjClass){
        return obj -> {
            try {
            targetConsumer.accept(obj);
            } catch (Exception e) {
               Exobj exobj = exobjClass.cast(e);
                System.out.println("Exception :"+exobj.getMessage());
            }
        };
    }

    static <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target,Exception> handlerConsumer){
        return obj ->{
            try {
                handlerConsumer.accept(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
