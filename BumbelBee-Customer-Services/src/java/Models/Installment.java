
package Models;

import Tools.DBTools;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Installment {
    private int loanNumber;
    private int number;
    private boolean isPaid;
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

    @Override
    public String toString() {
        return "Installment{" + "loanNumber=" + loanNumber + ", number=" + number + ", isPaid=" + isPaid + ", dueDate=" + dueDate + '}';
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    void pay() {
       String query = "UPDATE installment SET paid = "+PAID+" WHERE loan_id = "+loanNumber+" AND number = "+number;
       DBTools.runQuery(query);
    }
    public boolean isPaid(){
        return isPaid;
    }
    

    
    
}
