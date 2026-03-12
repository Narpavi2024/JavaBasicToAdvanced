package org.example.Thread.ThreadCration.interfaceexample;

public class Student {
    public static void main(String[] args) {
        Person person = new Engineer();
        Person person1 = new Teacher();
        System.out.println(person.profession());
        System.out.println(person1.profession());
    }
}
