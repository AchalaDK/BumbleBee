/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package models;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddProduct() {
        Product p = new Product();
        p.addProduct("TV", 45000, 38);
        System.out.println(p);
    }
    @Test
    public void testUpdateProduct(){
        Product p = new Product();
        p.updateProduct(1, "Fridge", 10900, 12);
    }
    @Test
    public void testDeleteProduct(){
        System.out.println(Product.deleteProduct(35));
    }
    @Test
    public void testUpdateCount(){
        Product.updateCount(2, 5);
    }
    
    @Test
    public void tesGetProductList(){
        ArrayList<Product> list = Product.getProductList();
        for(Product p : list){
            System.out.println(p);
        }
    }
}
