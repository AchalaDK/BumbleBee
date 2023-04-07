
package Models;

import Tools.DBTools;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartItem implements Serializable{
    @SerializedName("customer")
    private Customer customer;
    @SerializedName("product")
    private Product product;
    @SerializedName("qty")
    private int qty;
    
    public CartItem(int c, int p, int q){
        this.customer = new Customer();
        customer.loadInstanceById(c);
        this.product = new Product();
        product.loadInstance(p);
        this.qty = q;
        
    }
    
    public void addItem(){
        String query = "INSERT INTO cart (customer_id, product_id, qty) VALUES ("+customer.getCustomerId()+","+product.getProductId()+","+qty+") ON DUPLICATE KEY UPDATE qty = qty + "+qty+";";
        System.out.println(query);
        DBTools.runQuery(query);
    }
    public static ArrayList<CartItem> getCartList(int c){
        ArrayList<CartItem> list = new ArrayList<>();
        String query = "SELECT * FROM cart WHERE customer_id = "+c;
        ResultSet rs = DBTools.getResultFromQuery(query);
        try {
            while(rs.next()){
                list.add(new CartItem(rs.getInt("customer_id"), rs.getInt("product_id"), rs.getInt("qty")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    public static void deleteItem(int customer, int product){
        String query = "DELETE FROM cart WHERE customer_id = "+customer+" AND product_id ="+product;
        DBTools.runQuery(query);
    }

    public CartItem(Customer customer, Product product, int qty) {
        this.customer = customer;
        this.product = product;
        this.qty = qty;
    }

    public CartItem() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public String toJson() {        
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
