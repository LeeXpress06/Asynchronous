package Executors;

import Thread.Database.Database;
import Thread.Model.Product;
import Thread.Model.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static Database database = new Database();
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Future<Product> productFuture = executorService.submit( ( ) -> database.getproductByid(1));

        Future<Service> serviceFuture = executorService.submit(( ) -> database.getServiceByid(1));

        Product product = productFuture.get();
        Service service = serviceFuture.get();

        System.out.println(product);
        System.out.println(service);




    }
}
