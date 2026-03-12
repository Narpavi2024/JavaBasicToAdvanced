package org.example.Thread.ThreadCration.InterviewQuestions.MapFlatmap;

import java.util.List;
import java.util.stream.Collectors;

public class MapVSflatMap {
    public static void main(String[] args) {
        List<Customer> customers = EkartDataBase.getAll();
        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping

        List<String> emails = customers.stream().map(e -> e.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping

        List<List<String>> phonenumber = customers.stream().map(e -> e.getPhonenumber()).collect(Collectors.toList());
        System.out.println(phonenumber);

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping

        List<String> phones = customers.stream().flatMap(e->e.getPhonenumber().stream()).collect(Collectors.toList());
        System.out.println(phones);
    }
}


