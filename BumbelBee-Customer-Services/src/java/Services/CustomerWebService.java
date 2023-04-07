
package Services;

import Models.CartItem;
import Models.Customer;
import Models.Loan;
import Models.Product;
import Tools.DBConnection;
import com.google.gson.Gson;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;



@WebService(serviceName = "CustomerWebService")

public class CustomerWebService {
    private Customer customer;
    
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loginCustomer")
    public boolean loginCustomer(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        Customer customer = new Customer(email, password);
        if(customer.login()){
            this.customer = customer;
            return true;
        }
        return false;
    }

    
    @WebMethod(operationName = "updateInformation")
    @Oneway
    public void updateInformation(@WebParam(name = "name") String name, @WebParam(name = "fulName") String fulName, @WebParam(name = "dob") String dob, @WebParam(name = "password") String password) {
        if(customer != null){
            customer.updateDetails(customer.getEmail(), password, dob, name, customer.getMaxLoan());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLoan")
    public boolean getLoan(@WebParam(name = "productId") int productId) {
        if(customer != null){
            return customer.createLoan(productId);
        }
        return false;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllLoans")
    public String getAllLoans(@WebParam(name = "customerId") int customerId) {
        return new Gson().toJson(Customer.getAllLoans(customerId));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUnpaidLoans")
    public String getUnpaidLoans() {
        if(customer != null){
            return new Gson().toJson(customer.getUnpaidLoans());
        }
        return null;
    }    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "payLoan")
    @Oneway
    public void payLoan(@WebParam(name = "loanId") int loanId) {
        Loan loan = new Loan();
        loan.loadInstance(loanId);
        loan.payInstallment();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPaidInstallments")
    public int getPaidInstallments(@WebParam(name = "loanId") int loanId) {
        Loan loan = new Loan();
        loan.loadInstance(loanId);        
        return loan.getPaidNumber();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllProducts")
    
    public ArrayList<Product> getAllProducts() {
        Gson gson = new Gson();
        String json = gson.toJson(Product.getProductList());
        return Product.getProductList();        
    }
    
    @WebMethod(operationName = "getAllProductsJson")    
    public java.lang.String getAllProductsJson() {      
        
      
        return new Gson().toJson(Product.getProductList());
              
    }
    @WebMethod(operationName = "getLoggedPerson")    
    public java.lang.String getLoggedPerson() {    
        return new Gson().toJson(customer);              
    }
    @WebMethod(operationName = "registerCustomer")    
    public java.lang.String registerCustomer(@WebParam(name = "email") String email,@WebParam(name = "name") String name,@WebParam(name = "dob") String dob, @WebParam(name = "password") String password) {    
        Customer cutomer = Customer.createAccount(email, password, dob, name, 15000);
        this.customer = cutomer;
        return new Gson().toJson(customer);
    }
    @WebMethod(operationName = "getProductById")    
    public java.lang.String getProductById(@WebParam(name = "productId") int productId) {   
        Product product = new Product();
        product.loadInstance(productId);
        return new Gson().toJson(product);              
    }
    
    @WebMethod(operationName = "placeLoan")
    public boolean placeLoan(@WebParam(name = "cuustomerId") int customerId, @WebParam(name = "productId") int productId) {
        boolean loanPlaced = false;        
        Customer customer = new Customer();
        customer.loadInstanceById(customerId);
        return customer.createLoan(productId);        
    }
    @WebMethod(operationName = "getcart")    
    public java.lang.String getcart(@WebParam(name = "customerId") int customerId) {          
        return new Gson().toJson(CartItem.getCartList(customerId));              
    }
    @WebMethod(operationName = "deleteCartItem")  
    @Oneway
    public void deleteCartItem (@WebParam(name = "customerId") int customerId,@WebParam(name = "productId") int productId) {    
        CartItem.deleteItem(customerId, productId);                  
    }
    @WebMethod(operationName = "addCartItem")
    @Oneway
    public void addCartItem(@WebParam(name = "customerId") int customerId,@WebParam(name = "productId") int productId,@WebParam(name = "qty") int qty) {
        CartItem i = new CartItem(customerId, productId, qty);
        i.addItem();
    }  
    @WebMethod(operationName = "checkEligibility")
    public int checkEligibility(@WebParam(name = "customerId") int customerId,@WebParam(name = "total") double total){
        Customer c = new Customer();
        c.loadInstanceById(customerId);
        
        if(c.validateAge()){
            if(total<c.getMaxLoan()){
                return 0;
            }
            return 1; 
        }
        return 2;
        
    }
        
        
    
    
}
