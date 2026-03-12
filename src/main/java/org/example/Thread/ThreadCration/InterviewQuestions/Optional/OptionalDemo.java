package org.example.Thread.ThreadCration.InterviewQuestions.Optional;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

   public static Customer getCustomerbyEmail(String email) throws Exception {
       List<Customer> customers = EkartDataBase.getAll();
       return customers.stream().filter(e->e.getEmail().equals(email)).findAny().orElseThrow(()-> new Exception("no customer present with this email id"));
   }
    public static void main(String[] args) throws Exception {

        Customer customer = new Customer(101, "john", "test@gmail.com", Arrays.asList("397937955", "21654725"));
        //empty
        //of
        //ofNullable

        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
//        Optional<String> emailoptional = Optional.of(customer.getEmail());
//        System.out.println(emailoptional);
        Optional<String> email = Optional.ofNullable(customer.getEmail());
//        if (email.isPresent()){
//            System.out.println(email.get());
//        }
       // System.out.println(email);
//        System.out.println(email.orElse("default@gmail.com"));
//        System.out.println(email.orElseThrow( () -> new IllegalArgumentException("email not present")));
        System.out.println(email.map(String::toUpperCase).orElseGet(() -> "default email"));
      Customer customer1 = getCustomerbyEmail("john@gmail.com");
        System.out.println(customer1.getId()+" "+customer1.getName()+" "+customer1.getEmail()+" "+customer1.getPhonenumber());
    }
}
