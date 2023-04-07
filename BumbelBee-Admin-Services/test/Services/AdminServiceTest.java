/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Services;

import java.util.ArrayList;
import models.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dilshan GAM
 */
public class AdminServiceTest {
    
    public AdminServiceTest() {
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
    public void testHello() {
        System.out.println("hello");
        String txt = "";
        AdminService instance = new AdminService();
        String expResult = "";
        String result = instance.hello(txt);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllCustomers() {
        System.out.println("getAllCustomers");
        AdminService instance = new AdminService();
        String expResult = "";
        String result = instance.getAllCustomers();
        System.out.println(result);
    }

    @Test
    public void testUpdateInformation() {
        System.out.println("updateInformation");
        String name = "";
        String fulName = "";
        String dob = "";
        String password = "";
        int customerId = 0;
        double maxLoan = 0.0;
        AdminService instance = new AdminService();
        instance.updateInformation(name, fulName, dob, password, customerId, maxLoan);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoginAdmin() {
        System.out.println("loginAdmin");
        String username = "";
        String password = "";
        AdminService instance = new AdminService();
        boolean expResult = false;
        boolean result = instance.loginAdmin(username, password);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        String name = "";
        double price = 0.0;
        int count = 0;
        AdminService instance = new AdminService();
        int expResult = 0;
        int result = instance.addProduct(name, price, count);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllProducts() {
        System.out.println("getAllProducts");
        AdminService instance = new AdminService();
        ArrayList<Product> expResult = null;
        ArrayList<Product> result = instance.getAllProducts();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        int productId = 0;
        String name = "";
        double price = 0.0;
        int count = 0;
        AdminService instance = new AdminService();
        instance.updateProduct(productId, name, price, count);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllProductsJson() {
        System.out.println("getAllProductsJson");
        AdminService instance = new AdminService();
        String expResult = "";
        String result = instance.getAllProductsJson();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductById() {
        System.out.println("getProductById");
        int productId = 0;
        AdminService instance = new AdminService();
        String expResult = "";
        String result = instance.getProductById(productId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteProductById() {
        System.out.println("deleteProductById");
        int productId = 36;
        AdminService instance = new AdminService();
        System.out.println(instance.deleteProductById(productId));
        
    }

    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        int customerId = 0;
        AdminService instance = new AdminService();
        String expResult = "";
        String result = instance.getCustomerById(customerId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
