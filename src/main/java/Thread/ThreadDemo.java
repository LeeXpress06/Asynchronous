package Thread;

import Thread.Database.Database;
import Thread.Model.Product;
import Thread.Model.Service;

public class ThreadDemo {

     static  Database database = new Database();

    public static void main(String[] args) throws InterruptedException {
        // now define a task
       ProductRunnable productRunnable = new ProductRunnable(1);
       ServiceRunnable serviceRunnable = new ServiceRunnable(2);
        // let find the product
      Thread thread1  = new Thread(productRunnable);
      Thread thread2 = new Thread(serviceRunnable);
      thread1.start();
      thread2.start();

      thread1.join();
      thread2.join();

        System.out.println(productRunnable.getProduct() );
        System.out.println(serviceRunnable.getService());



    }

    // first runnable annonymous class
    public static class ProductRunnable implements  Runnable{
        private int id;
        private Product product;

        public ProductRunnable(int id) {
            this.id = id;
        }

        public Product getProduct() {
            return product;
        }

        @Override
        public void run() {
             product = database.getproductByid(id);


        }
    }

    // second runnable annonymous class
    public static  class ServiceRunnable implements Runnable {
        private int id;
        private Service service;

        public ServiceRunnable(int id) {
            this.id = id;
        }

        public Service getService( ){
            return  service;
        }

        @Override
        public void run() {
             service = database.getServiceByid(2);

        }
    }



}
