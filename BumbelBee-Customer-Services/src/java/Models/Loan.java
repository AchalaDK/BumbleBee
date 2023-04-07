
package Models;

import Tools.DBTools;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loan {
    private int loanId;
    private int customerId;
    private LocalDate date;
    private int productId;
    private Installment[] installments;
    private double amount;
    
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
        loan.installments = new Installment[3];
        Product p = new Product();
        p.loadInstance(productId);
        loan.amount = p.getPrice();
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
                this.loanId = loanId;
                Installment[] installments = new Installment[3];
                Product p = new Product();
                p.loadInstance(productId);
                amount = p.getPrice();
                for(int i = 0;i<3;i++){
                    Installment installment = new Installment();
                    installment.loadInstance(loanId, i);
                    installments[i] = installment;
                            
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
    public int getPaidNumber(){
        int count = 0;
        for(Installment i : installments){
            if(i.isPaid()){
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Loan{" + "loanId=" + loanId + ", customerId=" + customerId + ", date=" + date + ", productId=" + productId + ", installments=" + installments + '}';
    }
    public Installment[] getInstallments(){
        return installments;
    }

    public int getProductId() {
        return productId;
    }
    
    
}
