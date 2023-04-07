
package Services;

import Tools.DBTools;
import com.google.gson.Gson;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.Admin;
import models.Customer;
import models.Product;

@WebService(serviceName = "AdminService")
public class AdminService {

    public Admin admin;
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    @WebMethod(operationName = "getAllCustomers")
    public String getAllCustomers(){
        return new Gson().toJson(Customer.getAllCustomers());
    }
    @WebMethod(operationName = "updateInformation")
    @Oneway
    public void updateInformation(@WebParam(name = "name") String name, @WebParam(name = "fulName") String fulName, @WebParam(name = "dob") String dob, @WebParam(name = "password") String password , @WebParam(name = "customerId") int customerId , @WebParam(name = "maxLoan") double maxLoan) {
        Customer customer = new Customer();
        customer.loadInstanceById(customerId);
        System.out.println(customer.getEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        customer.updateDetails(customer.getEmail(), customer.getDob().format(formatter), customer.getName(), maxLoan);        
    }
    @WebMethod(operationName = "loginAdmin")
    public boolean loginAdmin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        Admin admin = new Admin(username, password);
        if(admin.validateUser()){
            this.admin = admin;
            return true;
        }
        return false;
    }
    @WebMethod(operationName = "addProduct")
    public int addProduct(@WebParam(name = "name") String name, @WebParam(name = "price") double price, @WebParam(name = "count") int count) {
        Product product = new Product();
        product.addProduct(name, price, count); 
        return DBTools.getLastPrimaryKey("product", "product_id");
    }
    @WebMethod(operationName = "getAllProducts")
    public ArrayList<Product> getAllProducts() {
        return Product.getProductList();        
    }
    @WebMethod(operationName = "updateProduct")
    @Oneway
    public void updateProduct(@WebParam(name = "productId") int productId, @WebParam(name = "name") String name, @WebParam(name = "price") double price, @WebParam(name = "count") int count) {
        Product product = new Product();
        product.updateProduct(productId, name, price, count);
    }
    @WebMethod(operationName = "getAllProductsJson")    
    public java.lang.String getAllProductsJson() {       
        return new Gson().toJson(Product.getProductList());
              
    }
    @WebMethod(operationName = "getProductById")    
    public java.lang.String getProductById(@WebParam(name = "productId") int productId) {   
        Product product = new Product();
        product.loadInstance(productId);
        return new Gson().toJson(product);              
    }
    @WebMethod(operationName = "deleteProductById")    
    public boolean deleteProductById(@WebParam(name = "productId") int productId) {   
        return Product.deleteProduct(productId);                    
    }
    @WebMethod(operationName = "getCustomerById")    
    public java.lang.String getCustomerById(@WebParam(name = "customerId") int customerId) {   
        Customer customer = new Customer();
        customer.loadInstanceById(customerId);
        return new Gson().toJson(customer);              
    }
    
    
    

    
    


}
