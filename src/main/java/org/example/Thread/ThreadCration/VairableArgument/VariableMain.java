package org.example.Thread.ThreadCration.VairableArgument;

public class VariableMain {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        int output = calculation.sum(5,1,2,3,4,5);
        System.out.println(output);
    }
}
