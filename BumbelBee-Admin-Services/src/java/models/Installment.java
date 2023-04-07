
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

public class Installment implements Serializable{
    @SerializedName("loanNumber")
    private int loanNumber;
    @SerializedName("number")
    private int number;
    @SerializedName("isPaid")
    private boolean isPaid;
    @SerializedName("dueDate")
    private LocalDate dueDate;
    public static final int PAID = 1;
    public static final int UNPAID = 0;
    
    
    public static Installment createInstallment(int loanNumber, int number, String dueDate){
        String query = "Insert INTO installment VALUES ("+loanNumber+","+number+","+UNPAID+",'"+dueDate+"')";
        DBTools.runQuery(query);
        Installment i = new Installment();
        i.loadInstance(loanNumber, number);
        return i;
    }
    public void loadInstance(int loanNumber , int number){
        String query =  "SELECT * FROM installment WHERE loan_id = "+loanNumber+" AND number = "+number;
        ResultSet rs = DBTools.getResultFromQuery(query);
        try {
            while(rs.next()){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dueDate = LocalDate.parse(rs.getString("due_date"), formatter);
                isPaid = rs.getInt("paid") == PAID;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Installment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void payInstallment(int loanNumber, int number){
        loadInstance(loanNumber, number);
        String query = "UPDATE installment SET paid = "+PAID+" WHERE loan_id = "+loanNumber+" AND number = "+number;
        DBTools.runQuery(query);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isPaid() {
        return isPaid;
    }
    
    @Override
    public String toString() {
        return "Installment{" + "loanNumber=" + loanNumber + ", number=" + number + ", isPaid=" + isPaid + ", dueDate=" + dueDate + '}';
    }

    void pay() {
       String query = "UPDATE installment SET paid = "+PAID+" WHERE loan_id = "+loanNumber+" AND number = "+number;
       DBTools.runQuery(query);
    }
    public String toJson() {        
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public int getNumber() {
        return number;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public static int getPAID() {
        return PAID;
    }

    public static int getUNPAID() {
        return UNPAID;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Installment(int loanNumber, int number, boolean isPaid, LocalDate dueDate) {
        this.loanNumber = loanNumber;
        this.number = number;
        this.isPaid = isPaid;
        this.dueDate = dueDate;
    }

    public Installment() {
    }
    
    
    
}
