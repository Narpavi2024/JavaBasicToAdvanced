package org.example.Thread.ThreadCration.GenericClassExample;

public class GenericMain {
    public static void main(String[] args) {
        Print<Integer> print = new Print<Integer>();
        print.setValue(1);
        Integer printvalue = print.getValue();
        if (printvalue == 1){
            System.out.println("Print Genric Value");
        }
    }
}
