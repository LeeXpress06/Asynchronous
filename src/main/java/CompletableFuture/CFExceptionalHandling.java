package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CFExceptionalHandling {

    public static void main(String[] args) {

        HelloWorldService hello = new HelloWorldService();
      CompletableFuture.supplyAsync(
              ( ) -> hello.getHelloWorldCF()
      ).handle(
              (result,exception) -> {
                  if( exception != null) return exception.getMessage();
                 else return result;}
      ).thenAccept(System.out::println).join();





    }
}
