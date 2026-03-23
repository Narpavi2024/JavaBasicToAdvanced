package org.example.Thread.ThreadCration.java17;

import org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.MethodReferenceExample.Employee;

import java.awt.*;
import java.util.Objects;

public class RecordclassDemo {
//    private final int x;
//    private final int y;
//
//    public RecordclassDemo(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        if (object == null || getClass() != object.getClass()) return false;
//        RecordclassDemo that = (RecordclassDemo) object;
//        return x == that.x && y == that.y;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }
//
//    @Override
//    public String toString() {
//        return "RecordclassDemo{" +
//                "x=" + x +
//                ", y=" + y +
//                '}';
//    }

    public static void main(String[] args) {
        Point point = new Point(3,2);
        System.out.println(point.x());
        System.out.println(point);

        Circle circle = new Circle(5.0);
        System.out.println(circle.area());

        Employees employee = new Employees("Sabari","E1140");
        System.out.println(employee.describe());
    }
}

