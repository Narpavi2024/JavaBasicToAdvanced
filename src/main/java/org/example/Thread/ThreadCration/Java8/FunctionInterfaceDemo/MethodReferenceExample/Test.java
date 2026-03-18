package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.MethodReferenceExample;

public class Test {

    public void m1(){
        System.out.println("M1 instance non static method");
    }
    public static void m2(){
        System.out.println("M2 Static method");
    }
    public static void main(String[] args) {

        // reference::Methodname
       Test.m2();
       Test test = new Test();
       test.m1();
    }
}
