/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.scoreboard.function;


import javafx.collections.ObservableList;

/**
 *
 * @author rizwan
 */
public class BoardStruct {
    private String batTeamName;
    private String ballTeamName;
    private int over;
    private String p1;
    private String p2;
    private String bowler;
    private ObservableList <String> batPlayList;
    private ObservableList <String> ballPlayList;
    private String nextBatsman;
    private String nextBowler;

    public BoardStruct(String batTeamName, String ballTeamName, int over, String p1, String p2, String bowler, ObservableList<String> batPlayList, ObservableList<String> ballPlayList) {
        this.batTeamName = batTeamName;
        this.ballTeamName = ballTeamName;
        this.over = over;
        this.p1 = p1;
        this.p2 = p2;
        this.bowler = bowler;
        this.batPlayList = batPlayList;
        this.ballPlayList = ballPlayList;
    }

    public String getNextBatsman() {
        return nextBatsman;
    }

    public void setNextBatsman(String nextBatsman) {
        this.nextBatsman = nextBatsman;
    }

    public String getNextBowler() {
        return nextBowler;
    }

    public void setNextBowler(String nextBowler) {
        this.nextBowler = nextBowler;
    }


    public String getBatTeamName() {
        return batTeamName;
    }

    public String getBallTeamName() {
        return ballTeamName;
    }

    public int getOver() {
        return over;
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }

    public String getBowler() {
        return bowler;
    }
    
     public ObservableList<String> getBatPlayList() {
        return batPlayList;
    }

    public ObservableList<String> getBallPlayList() {
        return ballPlayList;
    }
    
    
}
