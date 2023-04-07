
package Models;

import Tools.DBTools;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer implements Serializable{
    @SerializedName("customerId")
    private int customerId;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("date")
    private LocalDate dob;
    @SerializedName("passwordHash")
    private String passwordHash;
    @SerializedName("maxLoan")
    private double maxLoan;
    
    public Customer(String email,String password){
        this.email = email;
        this.passwordHash = hashPassword(password);
    }
    public boolean login(){
        String query = "SELECT * FROM customer WHERE email = '"+email+"' AND password_hash = '"+passwordHash+"'";
        System.out.println(query);
        ResultSet rs = DBTools.getResultFromQuery(query);
        boolean isLogged = false;
        try {
            while(rs.next()){
                isLogged = true;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //LocalDate birthday = LocalDate.parse(birthdayString, formatter);
                customerId = rs.getInt("customer_id");
                dob = LocalDate.parse(rs.getString("dob"), formatter);
                maxLoan = rs.getDouble("max_loan");
                name = rs.getString("ful_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isLogged;
    }
    public static Customer createAccount(String email, String password, String dob,String name, double maxLoan){
        String passwordHash =  hashPassword(password);
        String query = "INSERT INTO customer(email,dob,password_hash,max_loan,ful_name) VALUES('"+email+"','"+dob+"','"+passwordHash+"',"+maxLoan+",'"+name+"')";
        DBTools.runQuery(query);
        Customer c = new Customer(email, password);
        if(c.login()){
            return c;
        }
        return null;
    }
    public void updateDetails(String email, String password, String dob,String name, double maxLoan){
        if(login()){
            String query = "UPDATE Customer SET email = '"+email+"', password_hash = '"+hashPassword(password)+"', dob = '"+dob+"',ful_name = '"+name+"', max_loan = "+maxLoan+" WHERE customer_id = "+customerId;
            DBTools.runQuery(query);
        }
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
    public boolean validateAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate birthday = LocalDate.parse(birthdayString, formatter);
        LocalDate now = LocalDate.now();
        Period age = Period.between(dob, now);
        System.out.println(age.getYears());
        return age.getYears() > 18;
    }
    public static Loan[] getAllLoans(int customerId){
        
        String query = "SELECT loan_id from loan WHERE customer_id = "+customerId;
        ArrayList<Integer> loanIds = new ArrayList();
        ResultSet rs = DBTools.getResultFromQuery(query);
        try {
            while(rs.next()){
                loanIds.add(rs.getInt("loan_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Loan[] loans = new Loan[loanIds.size()];
        int i = 0;
        for(int id : loanIds){
            Loan loan = new Loan();
            loan.loadInstance(id);
            loans[i] = loan;
            i++;
        }
        return loans;
    }
    public Loan[] getUnpaidLoans(){
        ArrayList<Loan> redList = new ArrayList<>();
        for(Loan l : getAllLoans(customerId)){
            for(Installment i : l.getInstallments()){
                if(LocalDate.now().isAfter(i.getDueDate())){
                    redList.add(l);
                    break;
                }
            }
        }
        return (Loan[]) redList.toArray();
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", email=" + email + ", name=" + name + ", dob=" + dob + ", passwordHash=" + passwordHash + ", maxLoan=" + maxLoan + '}';
    }
    public double getTotalLoan(){
        double total = 0;
        for(Loan l : getAllLoans(customerId)){
            Product p = new Product();
            p.loadInstance(l.getProductId());
            total += p.getPrice();
        }
        return total;
    }
    public boolean createLoan(int productId){
        if(validateAge()){
            Product p = new Product();
            p.loadInstance(productId);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if((getTotalLoan()+p.getPrice())<=maxLoan){
                Loan.createLoan(customerId, LocalDate.now().format(formatter), productId);
                return true;
            }else{
                System.out.println("Loan cannot be granted");
                return false;
            }
        }
        return false;
    }
    public void loadInstanceById(int id){
        String query = "SELECT * FROM customer WHERE customer_id = "+id;
        ResultSet rs = DBTools.getResultFromQuery(query);
        try {
            while(rs.next()){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                //LocalDate birthday = LocalDate.parse(birthdayString, formatter);
                customerId = rs.getInt("customer_id");
                dob = LocalDate.parse(rs.getString("dob"), formatter);
                maxLoan = rs.getDouble("max_loan");
                name = rs.getString("ful_name");
                email = rs.getString("email");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public double getMaxLoan() {
        return maxLoan;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setMaxLoan(double maxLoan) {
        this.maxLoan = maxLoan;
    }
    public Customer(){
    }
    
    
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    
    
}
