package Executors;

import CompletableFuture.HelloWorldService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorCompletableFuture {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        HelloWorldService hello = new HelloWorldService();

        CompletableFuture.supplyAsync(
                ( ) -> hello.getHelloWorldCF(),executorService
        ).thenAcceptAsync(s-> System.out.println()) // change the thread if you needed or performance is slow
                .join();
    }
}

// interview question
// how to improve the performance of cf --- use asynch