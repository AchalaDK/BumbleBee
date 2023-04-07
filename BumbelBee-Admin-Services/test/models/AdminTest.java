
package models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminTest {
    
    public AdminTest() {
    }
    
    

    @Test
    public void testValidateUser() {
        System.out.println("validateUser");
       
        if(new Admin("admin","123").validateUser()){
            System.out.println("Validation successful");
        }else{
            fail("validation unsuccessful");
        }
        
    }

    @Test
    public void testHashPassword() {
        System.out.println("hashPassword");
        String passwordText = "";
        String expResult = "";
        String result = Admin.hashPassword(passwordText);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
