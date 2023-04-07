
package Tools;


import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Test;


public class DBConnectionTest {
    
    public DBConnectionTest() {
    }
    
    

    @Test
    public void testGetDbConnection() {
        System.out.println("getDbConnection");
        
        DBConnection result = DBConnection.getDbConnection();
        if(result.getConnection() == null){
            fail("Database didnt connected");
        }
        
        
    }
    
}
