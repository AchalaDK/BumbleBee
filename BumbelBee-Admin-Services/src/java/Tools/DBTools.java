
package Tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTools {
    
    public static ResultSet getResultFromQuery(String query){
            Connection connection = DBConnection.getDbConnection().getConnection();
            ResultSet rs = null;
            try {
                Statement stmnt = connection.createStatement();
                rs = stmnt.executeQuery(query);
            } catch (SQLException e) {
                System.out.println(query);
                e.printStackTrace();
            }
            return  rs;
        }
    public  static void runQuery(String query){
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(query);
            e.printStackTrace();
        }
    }
    public static int getLastPrimaryKey(String tableName, String primaryColoumn){
        String query = "SELECT * FROM "+tableName+" ORDER BY "+primaryColoumn+" DESC LIMIT 1";

        ResultSet rs = getResultFromQuery(query);
        int id = 0;
        try {
            while(rs.next()){
                id = rs.getInt(primaryColoumn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
