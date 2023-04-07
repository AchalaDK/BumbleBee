/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerTest {
    
    public CustomerTest() {
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
    public void testHashPassword() {
        System.out.println("hashPassword");
        String passwordText = "";
        String expResult = "";
        String result = Customer.hashPassword(passwordText);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidateAge() {
        Customer c = Customer.createAccount("john@mail.com", "555", "1996-01-27","John Doe", 15000);
        System.out.println(c.validateAge());
    }
    @Test
    public void testCreateAccount(){
        Customer c = Customer.createAccount("john@mail.com", "555", "1996-01-27","John Doe", 15000);
        System.out.println(c.validateAge());
    }
    @Test
    public void testUpdateCustomer(){
        Customer c = new Customer("john@mail.com", "555");
        c.updateDetails("d2@mail.com", "322", "1995-01-27","emma watsoon", 30000);
    }
    @Test
    public void testLogin(){
        Customer c = new Customer("john@mail.com","555");
        System.out.println(c.login());
    }
    
}
