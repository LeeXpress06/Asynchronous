package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class IndependentTask {

    public static void main(String[] args) {
        HelloWorldService hello = new HelloWorldService();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> hello.getWorld());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> hello.getHelloWorldCF());

        completableFuture.thenCombine(future, (a,b) -> (a + b))
                .thenAccept(s -> System.out.println(s)).join();
    }


}
