package org.example.Thread.ThreadCration.VairableArgument;

public class Calculation {
    static int carPrice = 40;
    public int sum(int a,int...variable){
        int output = 0;
        for(int var:variable){
            output = output + var;
        }
        return output;
    }
}
