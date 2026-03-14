package org.example.Thread.ThreadCration.Java8.FunctionInterfaceDemo.CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;

public class MultiApiDataFetcher {
    public CompletableFuture<String> fetchWeatherData(){
        return CompletableFuture.supplyAsync(()->{
          simulatedelay(2000);
          return "Weather: Sunny, 25°C";
        });
    }
    public CompletableFuture<String> fetchnewsHeadlines(){
      return CompletableFuture.supplyAsync(()->{
            simulatedelay(3000);
            return "News: Java 23 Released!";
        });
    }
    public CompletableFuture<String> fetchStockPrices() {
        return CompletableFuture.supplyAsync(() -> {
            simulatedelay(1500); // Simulate network delay
            return "Stocks: AAPL - $150, GOOGL - $2800";
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
      MultiApiDataFetcher multiApiDataFetcher = new MultiApiDataFetcher();
        //combine multiple independent future (more than 2) -> allOf(n task)
        //-> weatherDetailsAPI
        CompletableFuture<String> weatherfuture = multiApiDataFetcher.fetchWeatherData();
        //-> news apis
        CompletableFuture<String> newsFuture = multiApiDataFetcher.fetchnewsHeadlines();
        //StockPrice
        CompletableFuture<String> stockFuture = multiApiDataFetcher.fetchStockPrices();
        //wait for all future to complete
        CompletableFuture<Void> allFuture = CompletableFuture
                .allOf(weatherfuture, newsFuture, stockFuture);
        allFuture.thenRun(()->{
            String weather = weatherfuture.join();
            String news =    newsFuture.join();
            String stock = stockFuture.join();
            System.out.println("Aggregated Data : ");
            System.out.println(weather);
            System.out.println(news);
            System.out.println(stock);
        }).join();
    }
}
