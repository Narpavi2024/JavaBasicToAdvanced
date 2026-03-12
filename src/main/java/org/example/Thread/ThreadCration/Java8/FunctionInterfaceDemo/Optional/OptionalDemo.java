package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static Customer  getCustomerByEmailId(String email) throws Exception{
        List<Customer> customerList = EkartDataBase.getAll();

        return customerList.stream().filter(e -> e.getEmail().equals(email)).findAny()
                .orElseThrow(()-> new Exception("No customer present with this emailid"));


    }
    public static void main(String[] args) throws Exception {
        Customer customer=new Customer(101, "john", "test@gmail.com", Arrays.asList("397937955", "21654725"));
        //empty
        //of
        //ofnullable

//        Optional<Object> object = Optional.empty();
//        System.out.println(object);
//        Optional<String> emptyoptional = Optional.of(customer.getEmail());
//        System.out.println(emptyoptional);

        Optional<String> emptyoptional2 = Optional.ofNullable(customer.getEmail());
       /* if (emptyoptional2.isPresent()){
            System.out.println(emptyoptional2.get());
        }*/
      //  System.out.println(emptyoptional2.orElse("default@gmail.com"));
      //  System.out.println(emptyoptional2.orElseThrow(()-> new IllegalArgumentException("email not present")));
        //System.out.println(emptyoptional2.map(String::toUpperCase).orElseGet(()->"default@gmail.com"));
        try {
            Customer customer1 = getCustomerByEmailId("john@gmail.com");
            System.out.println(customer1.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
