package org.example.Thread.ThreadCration;

public class ShareResources {
    boolean isItempresent = false;


    public synchronized void addItem(){
        isItempresent = true;
        System.out.println("Producer thread calling notify method");
        notifyAll();
    }
    public synchronized void consumeItem(){
        System.out.println("Consumer thread inside consumeitem method");
        if (!isItempresent){
            try {
                System.out.println("Consumer thread is waiting");
                wait(); //release all the monitor lock
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Consumer thread consumed the item");
        isItempresent = false;
    }
}
