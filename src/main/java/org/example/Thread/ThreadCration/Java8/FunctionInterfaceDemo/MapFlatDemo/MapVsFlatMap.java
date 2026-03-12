package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.MapFlatDemo;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {

        List<Customer> customer = EkartDataBase.getAll();

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping

        List<String> email = customer.stream().map(Customer::getEmail).toList();
        System.out.println(email);

        //customer -> customer.getPhoneNumbers()  ->> one to many mapping

        List<List<String>> phonenum = customer.stream().map(Customer::getPhone).toList();
        System.out.println(phonenum);

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping

        List<String> phone = customer.stream().flatMap(c -> c.getPhone().stream()).toList();
        System.out.println(phone);


    }
    
}
