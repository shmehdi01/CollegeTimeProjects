
package roommanagment;


public class UserData {
    
    private String s_no;
    private String Total;
    private String Expense;
    private String purpose;
    private String date;
    
    public UserData(String s_no, String Total, String Expense, String purpose, String date)
    {
        this.s_no = s_no;
        this.Total = Total;
        this.Expense = Expense;
        this.purpose = purpose;
        this.date = date;
    }
    
    public String getSno()
    {
        return s_no;
    }
    
    public String getTotal()
    {
        return Total;
    }
    
    public String getExpense()
    {
        return Expense;
    }
    public String getPurpose()
    {
        return purpose;
    }
    
    public String getDate()
    {
        return date;
    }
    
}
