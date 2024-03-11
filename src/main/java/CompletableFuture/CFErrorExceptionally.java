package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CFErrorExceptionally {
    public static void main(String[] args) {

     HelloWorldService hello = new HelloWorldService();


        CompletableFuture.supplyAsync(
                ( ) -> hello.getHelloWorldCF()
        ).exceptionally(e -> {
                    if(e != null) System.out.println(e.getMessage());
                   return "Exceptionally default value";
                       } )

                .thenAccept(System.out::println).join();



    }
}
