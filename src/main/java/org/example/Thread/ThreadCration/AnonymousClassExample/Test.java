package org.example.Thread.ThreadCration.AnonymousClassExample;

public class Test {
    public static void main(String[] args) {
        Car car = new Car() {
            @Override
            public void pressBreak() {
                System.out.println("Audi specific break changes");
            }
        };
        car.pressBreak();
    }
}
