/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Models;

import java.util.ArrayList;
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
public class CartItemTest {
    
    public CartItemTest() {
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
    public void testAddItem() {
        System.out.println("addItem");
        CartItem instance = new CartItem(1000,1,1);
        instance.addItem();
        
    }

    @Test
    public void testGetCartList() {
        System.out.println("getCartList");
        int c = 0;
        ArrayList<CartItem> expResult = null;
        ArrayList<CartItem> result = CartItem.getCartList(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        int customer = 0;
        int product = 0;
        CartItem.deleteItem(customer, product);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        CartItem instance = new CartItem();
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        Customer customer = null;
        CartItem instance = new CartItem();
        instance.setCustomer(customer);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        CartItem instance = new CartItem();
        Product expResult = null;
        Product result = instance.getProduct();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        Product product = null;
        CartItem instance = new CartItem();
        instance.setProduct(product);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetQty() {
        System.out.println("getQty");
        CartItem instance = new CartItem();
        int expResult = 0;
        int result = instance.getQty();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetQty() {
        System.out.println("setQty");
        int qty = 0;
        CartItem instance = new CartItem();
        instance.setQty(qty);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJson() {
        System.out.println("toJson");
        CartItem instance = new CartItem();
        String expResult = "";
        String result = instance.toJson();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
