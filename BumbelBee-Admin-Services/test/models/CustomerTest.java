package models;

import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public void testLogin() {
        System.out.println("login");
        Customer instance = new Customer();
        boolean expResult = false;
        boolean result = instance.login();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateAccount() {
        System.out.println("createAccount");
        String email = "";
        String password = "";
        String dob = "";
        String name = "";
        double maxLoan = 0.0;
        Customer expResult = null;
        Customer result = Customer.createAccount(email, password, dob, name, maxLoan);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateDetails() {
        System.out.println("updateDetails");
        String email = "";
        String dob = "";
        String name = "";
        double maxLoan = 0.0;
        Customer instance = new Customer();
        instance.updateDetails(email, dob, name, maxLoan);
        fail("The test case is a prototype.");
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
        System.out.println("validateAge");
        Customer instance = new Customer();
        boolean expResult = false;
        boolean result = instance.validateAge();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllLoans() {
        System.out.println("getAllLoans");
        int customerId = 0;
        Loan[] expResult = null;
        Loan[] result = Customer.getAllLoans(customerId);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUnpaidLoans() {
        System.out.println("getUnpaidLoans");
        Customer instance = new Customer();
        Loan[] expResult = null;
        Loan[] result = instance.getUnpaidLoans();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTotalLoan() {
        System.out.println("getTotalLoan");
        Customer instance = new Customer();
        double expResult = 0.0;
        double result = instance.getTotalLoan();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllCustomers() {
        System.out.println("getAllCustomers");
        
        ArrayList<Customer> result = Customer.getAllCustomers();
        System.out.println(new Gson().toJson(result));
        
    }

    @Test
    public void testLoadInstanceById() {
        System.out.println("loadInstanceById");
        int id = 0;
        Customer instance = new Customer();
        instance.loadInstanceById(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Customer instance = new Customer();
        int expResult = 0;
        int result = instance.getCustomerId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDob() {
        System.out.println("getDob");
        Customer instance = new Customer();
        LocalDate expResult = null;
        LocalDate result = instance.getDob();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPasswordHash() {
        System.out.println("getPasswordHash");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getPasswordHash();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMaxLoan() {
        System.out.println("getMaxLoan");
        Customer instance = new Customer();
        double expResult = 0.0;
        double result = instance.getMaxLoan();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        int customerId = 0;
        Customer instance = new Customer();
        instance.setCustomerId(customerId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Customer instance = new Customer();
        instance.setEmail(email);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Customer instance = new Customer();
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDob() {
        System.out.println("setDob");
        LocalDate dob = null;
        Customer instance = new Customer();
        instance.setDob(dob);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPasswordHash() {
        System.out.println("setPasswordHash");
        String passwordHash = "";
        Customer instance = new Customer();
        instance.setPasswordHash(passwordHash);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMaxLoan() {
        System.out.println("setMaxLoan");
        double maxLoan = 0.0;
        Customer instance = new Customer();
        instance.setMaxLoan(maxLoan);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCurrentLoan() {
        System.out.println("getCurrentLoan");
        Customer instance = new Customer();
        double expResult = 0.0;
        double result = instance.getCurrentLoan();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCurrentLoan() {
        System.out.println("setCurrentLoan");
        double currentLoan = 0.0;
        Customer instance = new Customer();
        instance.setCurrentLoan(currentLoan);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJson() {
        System.out.println("toJson");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.toJson();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
