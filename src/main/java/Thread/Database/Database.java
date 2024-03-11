package Thread.Database;

import Thread.Model.Product;
import Thread.Model.Service;

import java.util.Arrays;
import java.util.List;

public class Database {

    public Database() {
    }

    // data
    List<Product> productList = Arrays.asList(new Product(1,"Iphone"," best phone"),
            new Product(2, "Samsung", "second best phone in android market"));
    // method to find the data
    public Product getproductByid ( int id ){
        return productList.stream().filter(productId -> productId.getId() == id)
                .findFirst().get();
    }

    // service data set

    List<Service> serviceList = Arrays.asList(
            new Service(1,"iphone",5),
            new Service ( 2,"Samsung",4)
    );
    // method to find the service rating by cutsomer
    public Service getServiceByid( int id ){

        return serviceList.stream().filter(s -> s.getId() == id)
                .findFirst().get();
    }
}
