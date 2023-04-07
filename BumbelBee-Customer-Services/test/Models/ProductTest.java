/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Models;

import com.google.gson.Gson;
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
    public void testLoadInstance() {
        System.out.println("loadInstance");
        int productId = 0;
        Product instance = new Product();
        instance.loadInstance(productId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        int productId = 0;
        String name = "";
        double price = 0.0;
        int count = 0;
        Product instance = new Product();
        instance.updateProduct(productId, name, price, count);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateCount() {
        System.out.println("updateCount");
        int productId = 0;
        int count = 0;
        Product.updateCount(productId, count);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductList() {
        System.out.println("getProductList");
        
        ArrayList<Product> result = Product.getProductList();
        System.out.println(new Gson().toJson(result));
        
        
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Product instance = new Product();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCount() {
        System.out.println("getCount");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int productId = 0;
        Product instance = new Product();
        instance.setProductId(productId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Product instance = new Product();
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        Product instance = new Product();
        instance.setPrice(price);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCount() {
        System.out.println("setCount");
        int count = 0;
        Product instance = new Product();
        instance.setCount(count);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJson() {
        System.out.println("toJson");
        Product instance = new Product();
        String expResult = "";
        String result = instance.toJson();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
