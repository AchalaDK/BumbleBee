
package models;

import Tools.DBTools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin {
    private String username;
    private String passwordhash;
    
    public Admin(String username, String password){
        this.username = username;
        this.passwordhash = hashPassword(password);
    }
    public boolean validateUser(){
        boolean isValidated = false;
        ResultSet rs = DBTools.getResultFromQuery("SELECT * FROM admin WHERE username = '"+username+"'");
        try {
            while(rs.next()){
                if(passwordhash.equals(rs.getString("password_hash"))){
                    isValidated = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValidated;
    }
    public static String hashPassword(String passwordText){

        String hash = null;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");

            md.update(passwordText.getBytes());

            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(hash);
        return hash;
    }
}
