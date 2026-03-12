package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.ExceptionHandling;

@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<Target,ExObj extends Exception>{
    public void accept(Target target) throws ExObj;
}
