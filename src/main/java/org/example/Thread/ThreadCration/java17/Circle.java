package org.example.Thread.ThreadCration.java17;

public record Circle(double radius) {

    //Custom instance method

    public double area(){
        return Math.PI * radius * radius;
    }

    //Static Method
    public static Circle unit(){
        return new Circle(1.0);
    }
}
