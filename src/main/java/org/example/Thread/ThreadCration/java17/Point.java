package org.example.Thread.ThreadCration.java17;

public record Point(int x,int y) {

    //Compact Constructor (validates without repeating assignments)
//    public Point{
//        if (x > y){
//            throw new IllegalArgumentException("min must be <= max");
//        }
//    }

//Canonical Constructor Override
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
}
