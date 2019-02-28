/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

import cricket.db.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rizwan
 */
public class PlayerList {
    DBConnection DBHandler;
    private ObservableList <String> playerlist;
    public PlayerList() {
        playerlist = FXCollections.observableArrayList();
        DBHandler = DBConnection.getConnection();
        try {
            String query = "SELECT name FROM Players";
            ResultSet rs = DBHandler.execQuery(query);
            while(rs.next()){
                playerlist.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public PlayerList(Object attr, Object value) {
        playerlist = FXCollections.observableArrayList();
        DBHandler = DBConnection.getConnection();
        try {
            String query = "SELECT name FROM Players WHERE " +  attr + "=" + "'" + value + "'";
            System.out.println(query);
            ResultSet rs = DBHandler.execQuery(query);
            while(rs.next()){
                playerlist.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<String> getPlayerlist() {
        return playerlist;
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println(new PlayerList("teamid", 4).getPlayerlist());
        
    }
    
}
