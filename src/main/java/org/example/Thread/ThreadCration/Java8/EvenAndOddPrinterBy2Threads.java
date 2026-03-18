package org.example.Thread.ThreadCration.Java8;

public class EvenAndOddPrinterBy2Threads implements Runnable{
    static int count = 1;
    Object object;
    public EvenAndOddPrinterBy2Threads(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        while (count <=10){
            if (count%2 == 0 && Thread.currentThread().getName().equals("even")){
                synchronized (object){
                    System.out.println("Thread name:"+Thread.currentThread().getName() +"value:"+count);
                    count++;
                    try {
                        object.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            if (count%2 !=0 && Thread.currentThread().getName().equals("odd")){
                synchronized (object){
                    System.out.println("Thread name:"+Thread.currentThread().getName()+"Value :"+count);
                    count++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
           Object lock = new Object();
           Runnable t1 = new EvenAndOddPrinterBy2Threads(lock);
           Runnable t2 = new EvenAndOddPrinterBy2Threads(lock);
           new Thread(t1,"even").start();
           new Thread(t2,"odd").start();
    }
}
