package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;

public class StockPriceDataFetcher {

    public CompletableFuture<Double> fetchStockPriceFromApi1(String Symbol){
        return CompletableFuture.supplyAsync(()->{
            // Simulate a network delay
            simulatedelay(2000); // Simulate a delay of 2 seconds
            return 150.0; // Simulated stock price from API 1
        });
    }

    public CompletableFuture<Double> fetchStockPriceFromApi2(String Symbol){
        return CompletableFuture.supplyAsync(()->{
            // Simulate a network delay
            simulatedelay(1000); // Simulate a delay of 3 seconds
            return 155.0; // Simulated stock price from API 2
        });
    }

    private void simulatedelay(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {

        StockPriceDataFetcher stockPriceDataFetcher = new StockPriceDataFetcher();
        String stockSymbol = "APPL"; //apple inc

        //fetch stock price from both the API

        CompletableFuture<Double> apiresult1 = stockPriceDataFetcher.fetchStockPriceFromApi1(stockSymbol);
        CompletableFuture<Double> apiresult2 = stockPriceDataFetcher.fetchStockPriceFromApi2(stockSymbol);
        //Use anyOf to wait any of the future to complete

        CompletableFuture<Object> anyofresultss = CompletableFuture.anyOf(apiresult1, apiresult2);

        //process the result
        anyofresultss.thenAccept(price -> {
            System.out.println("Received stock price : $" + price);
        }).join();

    }
}
