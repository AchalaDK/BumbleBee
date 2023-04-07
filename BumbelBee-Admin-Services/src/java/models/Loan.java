
package models;

import Tools.DBTools;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loan implements Serializable{
    @SerializedName("loanId")
    private int loanId;
    @SerializedName("customerId")
    private int customerId;
    @SerializedName("date")
    private LocalDate date;
    @SerializedName("productId")
    private int productId;
    @SerializedName("amount")
    private double amount;
    @SerializedName("installments")
    private Installment[] installments;
    
    public static Loan createLoan(int customerId, String date, int productId){
        Loan loan = new Loan();
        String query = "INSERT INTO loan(customer_id, date, product_id) VALUES ("+customerId+",'"+date+"',"+productId+")";
        DBTools.runQuery(query);
        loan.loanId = DBTools.getLastPrimaryKey("loan", "loan_id");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d = LocalDate.parse(date, formatter);
        loan.customerId = customerId;
        loan.date = d;
        loan.productId = productId;
        Product p = new Product();
        p.loadInstance(productId);
        loan.amount = p.getPrice();
        loan.installments = new Installment[3];
        for(int i = 0; i<3 ; i++){
            d = d.plusDays(30);
            loan.installments[i] = Installment.createInstallment(
                    loan.loanId,
                    i,
                    d.format(formatter));            
        }
        Product.updateCount(productId, -1);
        return loan;
    }
    public void loadInstance(int loanId){
        ResultSet rs = DBTools.getResultFromQuery("SELECT * FROM loan WHERE loan_id = "+loanId);
        try {
            while(rs.next()){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.customerId = rs.getInt("customer_id");
                this.date = LocalDate.parse(rs.getString("date"), formatter);
                this.productId = rs.getInt("product_id");
                Product p = new Product();
                p.loadInstance(productId);
                amount = p.getPrice();
                this.loanId = loanId;
                Installment[] installments = new Installment[3];
                for(int i = 0;i<3;i++){
                    Installment ins = new Installment();
                    ins.loadInstance(loanId, i);
                    installments[i]= ins;
                }
                this.installments = installments;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void payInstallment(){
        for(Installment i : installments){
            if(!(i.isPaid())){
                i.pay();
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Loan{" + "loanId=" + loanId + ", customerId=" + customerId + ", date=" + date + ", productId=" + productId + ", installments=" + installments + '}';
    }

    public Installment[] getInstallments() {
        return installments;
    }
    public int getProductId() {
        return productId;
    }
    public String toJson() {        
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public int getLoanId() {
        return loanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInstallments(Installment[] installments) {
        this.installments = installments;
    }

    public Loan(int loanId, int customerId, LocalDate date, int productId, double amount, Installment[] installments) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.date = date;
        this.productId = productId;
        this.amount = amount;
        this.installments = installments;
    }

    public Loan() {
    }
    
}
