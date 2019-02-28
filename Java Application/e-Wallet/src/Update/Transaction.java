/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Update;

import Query.Run;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rizwan
 */
public class Transaction {

    private static int txnid;
    private static int balance;
    private static String action;
    private static String particular;
    private static String date;
    Run run;

    public Transaction() {
        run = new Run();
    }

    public void getDetail(int userid) throws SQLException {
        String query = "SELECT * FROM txntable WHERE userid =" + userid;
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            txnid = rs.getInt("txnid");
            balance = rs.getInt("amount");
            action = rs.getString("action");
            particular = rs.getString("particular");
            date = rs.getString("date");
        }
    }

    public int getWallet(int userid) throws SQLException {
        int total = 0;
        String query = "SELECT SUM(amount) as total FROM txntable WHERE userid = " + userid;
        ResultSet rs = run.readQuery(query);
        while (rs.next()) {
            total = rs.getInt("total");
        }
        return total;
    }

    public boolean updateWallet(int userid, int bal, String act, String part) throws SQLException {
        String query = "INSERT INTO txntable(userid,amount,action,particular) VALUES("
                + "'" + userid + "'," + "'" + bal + "'," + "'" + act + "'" + ",'" + part + "'" + ")";
        System.out.println(query);
        if (run.insertQuery(query)) {
            return true;
        }
        return false;
    }

    public int getTxnID() {
        return txnid;
    }

    public int getBal() {
        return balance;
    }

    public String getAct() {
        return action;
    }

    public String getParticular() {
        return particular;
    }

    public String getDate() {
        return date;
    }
}
