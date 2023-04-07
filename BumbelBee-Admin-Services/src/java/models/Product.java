
package models;

import Tools.DBConnection;
import Tools.DBTools;
import com.google.gson.annotations.SerializedName;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Product {
    @SerializedName("productId")
    private int productId;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private double price;
    @SerializedName("count")
    private int count;
    
    public void loadInstance(int productId){
        String query = "SELECT * FROM product WHERE product_id = "+productId;
        ResultSet rs = DBTools.getResultFromQuery(query);
        try {
            while(rs.next()){
                this.name = rs.getString("name");
                this.price = rs.getDouble("price");
                this.count = rs.getInt("count");
                this.productId = productId;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addProduct(String name, double price , int count){
        String query = "INSERT INTO product(name,price,count) VALUES('"+name+"',"+price+","+count+")";
        DBTools.runQuery(query);   
        this.name = name;
        this.price = price;
        this.count = count;
        this.productId = DBTools.getLastPrimaryKey("product", "product_id");
    }
    public static boolean deleteProduct(int productId){        
        String query = "DELETE FROM product WHERE product_id = "+productId;
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            
            System.out.println(query);
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void updateProduct(int productId ,String name, double price , int count){
        this.loadInstance(productId);
        String query = "UPDATE product SET name = '"+name+"', price = "+price+", count = "+count+" WHERE product_id = "+productId;
        DBTools.runQuery(query);
        this.loadInstance(productId);
    }
    public static void updateCount(int productId, int count){
        Product p = new Product();
        p.loadInstance(productId);
        p.updateProduct(productId, p.name, p.price, p.count + count);
    }
    public static ArrayList<Product> getProductList(){
        ArrayList list = new ArrayList<>();
        String query = "SELECT * FROM product";
        ResultSet rs = DBTools.getResultFromQuery(query);
        try {
            while(rs.next()){
                Product p = new Product();
                
                p.name = rs.getString("name");
                p.price = rs.getDouble("price");
                p.count = rs.getInt("count");
                p.productId = rs.getInt("product_id");
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public double getPrice() {
        loadInstance(productId);
        return price;
    }
    
    
    

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", price=" + price + ", count=" + count + '}';
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product(int productId, String name, double price, int count) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Product() {
    }
    
    
    
    
}
    
