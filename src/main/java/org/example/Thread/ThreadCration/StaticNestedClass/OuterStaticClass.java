package org.example.Thread.ThreadCration.StaticNestedClass;

public class OuterStaticClass {
    int instancevariable = 10;
    static int classvariable = 20;

    static class NestedClass{
        public void print(){
            System.out.println(classvariable);
        }
    }

    public void display(){
        NestedClass nestedClass = new NestedClass();
        nestedClass.print();
    }
}
