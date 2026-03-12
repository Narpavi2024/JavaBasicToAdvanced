package org.example.Thread.ThreadCration.Java8;

public class CalculatorImpl {
    public static void main(String[] args) {

//        Calculator calculator = () -> System.out.println("Switch On");
//        calculator.switchOn();

//        Calculator calculator = (input) -> System.out.println("Sum "+input);
//        calculator.sum(30);

          Calculator calculator = (i1,i2) -> {
              return i2 - i1;
          };
        System.out.println(calculator.substract(8,20));

    }
}
interface Calculator{
    //void switchOn();
    //void sum(int output);
    int substract(int i1,int i2);
}
