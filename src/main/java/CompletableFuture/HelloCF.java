package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HelloCF {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        HelloWorldService hello = new HelloWorldService();

      CompletableFuture.supplyAsync(( ) -> hello.getWorld())
              .thenApply(String::toUpperCase)
              .thenAccept(System.out::println);









    }
}
