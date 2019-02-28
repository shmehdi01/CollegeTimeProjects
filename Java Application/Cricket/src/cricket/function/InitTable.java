/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.function;

import cricket.db.DBConnection;


/**
 *
 * @author rizwan
 */
public class InitTable {
    public DBConnection DBHandler;

    public InitTable() {
        DBHandler = DBConnection.getConnection();
        if(!DBHandler.existTable("Teams")){
            System.out.println("Teams table is not exist,, creating!!!!!");
            createTeam();
        }
        if(!DBHandler.existTable("Players")){
            System.out.println("Players table is not exist,, creating!!!!!");
            createPlayers();
        }
        if(!DBHandler.existTable("Playersdata")){
            System.out.println("Playersdata table is not exist,, creating!!!!!");
            createPlayersData();
        }
    }
    
    void createTeam(){
        String query = " CREATE TABLE 'main'." + "Teams"
                + "('teamid' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                + "'name' VARCHAR,"
                + "'nickname' VARCHAR,"
                + "'logo' VARCHAR,"
                + "'entry_date' DATETIME DEFAULT CURRENT_DATE)";
        if(!DBHandler.updateQuery(query)){
            System.out.println("Team table is created..");
        }
    }
    
    void createPlayersData(){
        String query = " CREATE TABLE 'main'." + "Playersdata"
                + "('playerdataid' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                + "'playerid' VARCHAR,"
                + "'teamid' VARCHAR,"
                + "'match' VARCHAR,"
                + "'totalrun' VARCHAR,"
                + "'batavg' VARCHAR,"
                + "'bowlavg' VARCHAR,"
                + "'hundred' VARCHAR,"
                + "'fifty' VARCHAR,"
                + "'highscore' VARCHAR,"
                + "'wicket' VARCHAR,"
                + "'catch' VARCHAR,"
                + "'four' VARCHAR,"
                + "'six' VARCHAR,"
                + "'out' VARCHAR,"
                + "'notout' VARCHAR,"
                + "'entry_date' DATETIME DEFAULT CURRENT_DATE)";
        if(!DBHandler.updateQuery(query)){
            System.out.println("Playersdata table is created..");
        }
    }
    
    void createPlayers(){
        String query = " CREATE TABLE 'main'." + "Players"
                + "('playerid' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                + "'teamid' VARCHAR,"
                + "'name' VARCHAR,"
                + "'type' VARCHAR,"
                + "'captain' VARCHAR,"
                + "'entry_date' DATETIME DEFAULT CURRENT_DATE)";
        if(!DBHandler.updateQuery(query)){
            System.out.println("Players table is created..");
        }
    }
    
    
}
