package Thread.Service;

import Thread.Database.Database;
import Thread.Model.Product;
import Thread.Model.Service;

public class ProductService {

    public ProductService() {
    }

    Database database = new Database();

   // let find the product
       public Product getbyid (int id ){

           return database.getproductByid(id);
       }

    public Service getbyserviceid (int id ){

        return database.getServiceByid(id);
    }


}
