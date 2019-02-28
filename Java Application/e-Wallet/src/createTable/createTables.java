/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createTable;

import Database.DbConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Query.Run;

/**
 *
 * @author rizwan
 */
public class createTables {

    public Connection con;

    public createTables() throws SQLException {
        con = DbConnect.dbConnection();
        if (!existTable("login")) {
            createLogin();
        }
        if (!existTable("txntable")) {
            createTxn();
        }
    }

    private boolean existTable(String tablename) throws SQLException {
        boolean exist = false;
        try (ResultSet rs = con.getMetaData().getTables(null, null, tablename, null)) {
            while (rs.next()) {
                String tblname = rs.getString("TABLE_NAME");
                if (tblname != null && tblname.equals(tablename)) {
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    private void createLogin() throws SQLException {
        String query = " CREATE TABLE 'main'." + "login"
                + "('userid' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                + "'mobile' VARCHAR,"
                + "'pass' VARCHAR,"
                + "'name' VARCHAR,"
                + "'email' VARCHAR)";
        System.out.println(query);
        new Run().insertQuery(query);
    }

    private void createTxn() throws SQLException {
        String query = " CREATE TABLE 'main'." + "txntable"
                + "('txnid' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                + "'userid' INTEGER NOT NULL,"
                + "'amount' INTEGER,"
                + "'action' VARCHAR,"
                + "'particular' VARCHAR,"
                + "'date' DATETIME DEFAULT CURRENT_DATE)";
        System.out.println(query);
        new Run().insertQuery(query);
    }

}
