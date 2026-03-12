package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BookService {
    public List<Book> getBookinshort(){
        List<Book> books = new BookDAO().getBooks();
//        Collections.sort(books,new MyComparator());
//        Collections.sort(books, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getName().compareTo(o1.getName());
//            }
//        });
        Collections.sort(books,(o1,o2) -> o2.getName().compareTo(o1.getName()));
        return books;

    }

    public static void main(String[] args) {
        System.out.println(new BookService().getBookinshort());
    }
}

//class MyComparator implements Comparator<Book>{
//
//    @Override
//    public int compare(Book o1, Book o2) {
//        return o2.getName().compareTo(o1.getName());
//    }
//}
