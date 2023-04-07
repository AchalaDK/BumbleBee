
package models;

import Tools.DBTools;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
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

public class Customer {
    @SerializedName("customerId")
    private int customerId;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("dob")
    private LocalDate dob;
    @SerializedName("passwordHash")
    private String passwordHash;
    @SerializedName("maxLoan")
    private double maxLoan;
    @SerializedName("currentLoan")
    private double currentLoan;
    
    public Customer(){
        
    }
    
    public Customer(String email,String password){
        this.email = email;
        this.passwordHash = hashPassword(password);
    }
    public boolean login(){
        String query = "SELECT * FROM customer WHERE email = '"+email+"' AND password_hash = '"+passwordHash+"'";
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
        return true;
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
    public void updateDetails(String email, String dob,String name, double maxLoan){
        if(login()){
            String query = "UPDATE Customer SET email = '"+email+"', dob = '"+dob+"',ful_name = '"+name+"', max_loan = "+maxLoan+" WHERE customer_id = "+customerId;
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
        return age.getYears() < 18;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", email=" + email + ", name=" + name + ", dob=" + dob + ", passwordHash=" + passwordHash + ", maxLoan=" + maxLoan + '}';
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
                if(LocalDate.now().isAfter(i.getDueDate()) && !(i.isPaid())){
                    redList.add(l);
                    break;
                }
            }
        }
        return (Loan[]) redList.toArray();
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
    public static ArrayList<Customer> getAllCustomers(){
        String query = "SELECT * FROM customer";
        ResultSet rs = DBTools.getResultFromQuery(query);
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            while(rs.next()){
                Customer customer = new Customer();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");            
                customer.customerId = rs.getInt("customer_id");
                customer.dob = LocalDate.parse(rs.getString("dob"), formatter);
                
                customer.maxLoan = rs.getDouble("max_loan");
                customer.name = rs.getString("ful_name");
                customer.email = rs.getString("email");
                customer.currentLoan = customer.getTotalLoan();
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
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

    public double getCurrentLoan() {
        return currentLoan;
    }

    public void setCurrentLoan(double currentLoan) {
        this.currentLoan = currentLoan;
    }
    
    public String toJson() {
        this.currentLoan = getTotalLoan();
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Customer(int customerId, String email, String name, LocalDate dob, String passwordHash, double maxLoan, double currentLoan) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.passwordHash = passwordHash;
        this.maxLoan = maxLoan;
        this.currentLoan = getTotalLoan();
    }
    
    
}
