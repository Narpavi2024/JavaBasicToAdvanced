package org.example.Thread.ThreadCration;

public class ThreadMain {
    public static void main(String[] args) {

        ShareResources shareResources = new ShareResources();

        Thread producethread = new Thread(() -> {
            try {
            Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            shareResources.addItem();
        });

        Thread consumethread = new Thread(() -> {
            shareResources.consumeItem();
        });

        producethread.start();
        consumethread.start();
    }
}
