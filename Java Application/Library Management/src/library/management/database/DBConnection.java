/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rizwan
 */
public class DBConnection {

    Connection con;

    public DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:library.sqlite");
        System.out.println(" Databse connected");
        setTable();
    }

    public void setTable() throws SQLException {
        if (!checkExistTable("book")) {
            createBookTable();
        }
        if (!checkExistTable("student")) {
            createStudentTable();
        }
    }

    private boolean checkExistTable(String tablename) throws SQLException {
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

    private void createBookTable() throws SQLException {
        String tablename = "book";
        String query = " CREATE TABLE 'main'." + tablename
                + "('bookid' INTEGER PRIMARY KEY UNIQUE,"
                + "'bookname' VARCHAR,"
                + "'author' VARCHAR,"
                + "'publisher' VARCHAR)";
        if (!insertQuery(query)) {
            System.out.println("New Table created: " + tablename);
        }

    }
    private void createStudentTable() throws SQLException{
         String tablename = "student";
        String query = " CREATE TABLE 'main'." + tablename
                + "('sid' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                + "'roll' INTEGER ,"
                + "'name' VARCHAR,"
                + "'branch' VARCHAR,"
                + "'session' VARCHAR)";
        if (!insertQuery(query)) {
            System.out.println("New Table created: " + tablename);
        }
    }

    public ResultSet readQuery(String query) throws SQLException {

        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public boolean insertQuery(String query) throws SQLException {
        PreparedStatement pst = con.prepareStatement(query);
        int i = pst.executeUpdate();
        if (i > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       ResultSet r =  new DBConnection().readQuery("SELECT * FROM book");
        while(r.next()){
            System.out.println(r.getString("bookid"));
        }
    }

}
