/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.scoreboard;

import com.jfoenix.controls.JFXRadioButton;
import cricket.create.BatfirstController;
import cricket.create.OpenerballerController;
import static cricket.function.LoadWin.load_pop_stage;
import cricket.scoreboard.function.Batsman;
import cricket.scoreboard.function.BoardStruct;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rizwan
 */
public class MainboardController implements Initializable {

    @FXML
    private Text teamname;
    @FXML
    private Text totalrun;
    @FXML
    private Text wicket;
    @FXML
    private Text totalover;
    @FXML
    private Text runrate;
    @FXML
    private JFXRadioButton player1;
    @FXML
    private JFXRadioButton player2;
    @FXML
    private Text bowlername;

    /**
     * Initializes the controller class.
     */
    static int total = 0, wckt = 0, bowl = 0, dott = 0, nbs = 0, wides = 0;
    static int ONE = 0, TWO = 0, THREE = 0, FOUR = 0, SIX = 0;
    static float ovr = 0, rr;
    static int LB = 0, lb = 0;
    static int extrun = 0;
    @FXML
    private HBox thisoverbox;
    public static String Team_Name_For_List;
    BoardStruct board;
    @FXML
    private Text info;
    @FXML
    private VBox calVb;
    @FXML
    private Text p1run;
    @FXML
    private Text p2run;
    @FXML
    private Text p1ball;
    @FXML
    private Text p2ball;
    @FXML
    private Text pnamed;
    @FXML
    private Text prund;
    @FXML
    private Text pballd;
    @FXML
    private Text psixd;
    @FXML
    private Text pfourd;
    @FXML
    private Text psrd;
    @FXML
    private VBox playerview;
    @FXML
    private Text closeview;
    @FXML
    private Text matchover;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        board = BatfirstController.bs;
        ToggleGroup tg = new ToggleGroup();
        player1.setToggleGroup(tg);
        player2.setToggleGroup(tg);
        player1.setSelected(true);
        playerview.setVisible(false);
        initializeBatsman();
        init();
    }

    static Batsman batsman1;
    static Batsman batsman2;

    void initializeBatsman() {
        batsman1 = new Batsman(board.getP1(), 0, 0, 0, 0, 0);
        batsman2 = new Batsman(board.getP2(), 0, 0, 0, 0, 0);
    }

    static int RUN = 0; // FOR GETTING CURRENT RUN ON A  CURRENT BALL

    float calSR(int run, int ball){
        DecimalFormat df = new DecimalFormat("0.00");
        float sr = ((float)run/ball)*100;
        sr = Float.parseFloat(df.format(sr));
        return sr;
    }
    
    void updateBatsmanScore() {
        if (player1.isSelected()) {
            batsman1.setRun(RUN + batsman1.getRun());
            batsman1.setBall(batsman1.getBall() + 1);
            if (RUN == 6) {
                batsman1.setSix(batsman1.getSix() + 1);
            }
            if (RUN == 4) {
                batsman1.setFour(batsman1.getFour() + 1);
            }
            batsman1.setSr(calSR(batsman1.getRun(), batsman1.getBall()));
        } else if (player2.isSelected()) {
            batsman2.setRun(RUN + batsman2.getRun());
            batsman2.setBall(batsman2.getBall() + 1);
            if (RUN == 6) {
                batsman2.setSix(batsman2.getSix() + 1);
            }
            if (RUN == 4) {
                batsman2.setFour(batsman2.getFour() + 1);
            }
            batsman2.setSr(calSR(batsman2.getRun(), batsman2.getBall()));

        }

    }

    void init() {
        p1run.setText(batsman1.getRun()+"");
        p2run.setText(batsman2.getRun()+"");
        p1ball.setText("(" + batsman1.getBall()+")");
        p2ball.setText("(" + batsman2.getBall()+")");
        teamname.setText(board.getBatTeamName());
        player1.setText(board.getP1());
        player2.setText(board.getP2());
        bowlername.setText(board.getBowler());
        matchover.setText(board.getOver()+" Over Match");
        System.out.println("over " + board.getOver());
    }

    boolean strikeChange() {
        if (player1.isSelected()) {
            player2.setSelected(true);
            player1.setSelected(false);
        } else if (player2.isSelected()) {
            player1.setSelected(true);
            player2.setSelected(false);
        }
        return true;
    }

    int calTotalRun() {
        total = ONE * 1 + TWO * 2 + THREE * 3 + FOUR * 4 + SIX * 6 + nbs + wides + dott * 0 + lb + extrun;
        return total;
    }

    float calcTotalOver() {
        ovr = bowl / 6;
        float rb = (float) ((bowl - ovr * 6) * 0.1);
        ovr = rb + ovr;
        return ovr;
    }

    float calRunRate() {
        DecimalFormat df = new DecimalFormat("0.00");
        rr = total / ovr;
        rr= Float.parseFloat(df.format(rr));
        return rr;
    }

    int getWicket() {
        return wckt;
    }

    public void refresh() {
        playerview.setVisible(false);
        updateBatsmanScore();
        totalrun.setText(calTotalRun() + "");
        wicket.setText(getWicket() + "");
        totalover.setText(calcTotalOver() + "");
        runrate.setText(calRunRate() + "");
        p1run.setText(batsman1.getRun()+"");
        p2run.setText(batsman2.getRun()+"");
        p1ball.setText("(" + batsman1.getBall()+")");
        p2ball.setText("(" + batsman2.getBall()+")");
        if (overComplete()) {
            strikeChange();
            removethisOver();
            loadPlayerList(board.getBallTeamName());
            calVb.setDisable(true);
            info.setText("OVER IS COMPLETED PLEASE REFRESH");
        }
        if (isOut) {
            System.out.println("yes out ho gya");
            loadPlayerList(board.getBatTeamName());
            calVb.setDisable(true);
            info.setText("NEW BATSMAN ADDED PLEASE REFRESH");
        }

        isOut = false;
        System.out.println("refresh...");
    }

    public void updateName() {
        if (PlayersController.setBallPlayer) {
            setNextBowler();
            PlayersController.setBallPlayer = false;
        }
        if (PlayersController.setBatPlayer) {
            setNextBatsman();
            PlayersController.setBatPlayer = false;
        }
        calVb.setDisable(false);
        info.setText("Game in progress...");
    }

    int getTotalBall() {
        return bowl;
    }

    boolean overComplete() {
        if (getTotalBall() % 6 == 0) {
            return true;
        }
        return false;
    }

    void thisOver(String run) {
        String ball = run;
        thisoverbox.getChildren().add(new Label(ball));
    }

    void removethisOver() {
        while (thisoverbox.getChildren().size() != 0) {
            for (int i = 0; i < thisoverbox.getChildren().size(); i++) {
                thisoverbox.getChildren().remove(i);
            }
        }
    }

    void loadPlayerList(String team) {
        Team_Name_For_List = team;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/cricket/scoreboard/players.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            load_pop_stage = stage;
            stage.setScene(scene);
            stage.setTitle(team);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    void setNextBatsman() {
        if (player1.isSelected()) {
            player1.setText(board.getNextBatsman());
            batsman1 = new Batsman(board.getNextBatsman(),0 , 0, 0,0, 0);
        }
        if (player2.isSelected()) {
            player2.setText(board.getNextBatsman());
            batsman2 = new Batsman(board.getNextBatsman(),0 , 0, 0,0, 0);
        }
    }

    void setNextBowler() {
        bowlername.setText(board.getNextBowler());
    }

    @FXML
    private void dotBtn(ActionEvent event) {
        bowl++;
        dott++;
        RUN = 0;
        thisOver("Dot");
        refresh();
    }

    @FXML
    private void singleBtn(ActionEvent event) {
        bowl++;
        ONE++;
        RUN = 1;
        thisOver("1");
        refresh();
        strikeChange();
    }

    @FXML
    private void doubleBtn(ActionEvent event) {
        bowl++;
        TWO++;
        RUN = 2;
        thisOver("2");
        refresh();
    }

    @FXML
    private void trippleBtn(ActionEvent event) {
        bowl++;
        THREE++;
        RUN = 3;
        thisOver("3");
        refresh();
        strikeChange();
    }

    @FXML
    private void fourBtn(ActionEvent event) {
        bowl++;
        FOUR++;
        RUN = 4;
        thisOver("4");
        refresh();
    }

    @FXML
    private void sixBtn(ActionEvent event) {
        bowl++;
        SIX++;
        RUN = 6;
        thisOver("6");
        refresh();
    }
    boolean isOut = false;

    @FXML
    private void outBtn(ActionEvent event) {
        bowl++;
        wckt++;
        RUN = 0;
        thisOver("wckt");
        isOut = true;
        refresh();
    }

    @FXML
    private void noballBtn(ActionEvent event) {
        nbs++;
        RUN = 1;
        thisOver("NB");
        refresh();
    }

    @FXML
    private void wideBtn(ActionEvent event) {
        wides++;
        RUN = 1;
        thisOver("WD");
        refresh();
    }

    @FXML
    private void extraa4(ActionEvent event) {
        extrun += 4;
        RUN = 4;
        refresh();
    }

    @FXML
    private void extraa6(ActionEvent event) {
        extrun += 6;
        RUN = 6;
        refresh();
    }

    @FXML
    private void lb1(ActionEvent event) {
        bowl++;
        LB++;
        lb++;
        RUN = 1;
        thisOver("lb1");
        refresh();
    }

    @FXML
    private void lb2(ActionEvent event) {
        bowl++;
        LB++;
        lb += 2;
        RUN = 2;
        thisOver("lb2");
        refresh();
    }

    @FXML
    private void lb3(ActionEvent event) {
        bowl++;
        LB++;
        lb += 3;
        RUN = 3;
        thisOver("lb3");
        refresh();
    }

    @FXML
    private void lb4(ActionEvent event) {
        bowl++;
        LB++;
        lb += 4;
        RUN = 4;
        thisOver("lb4");
        refresh();
    }

    @FXML
    private void doRefresh(ActionEvent event) {
        updateName();
        System.out.println(batsman1.getName());
        System.out.println(batsman1.getRun());
        System.out.println(batsman1.getBall());
        System.out.println(batsman1.getSix());
        System.out.println(batsman1.getSr());
    }

    @FXML
    private void showP1detail(MouseEvent event) {
        playerview.setVisible(true);
        System.out.println("player 1 detail here");
        pnamed.setText(batsman1.getName());
        prund.setText(batsman1.getRun()+"");
        pballd.setText(batsman1.getBall()+"");
        psixd.setText(batsman1.getSix()+"");
        pfourd.setText(batsman1.getFour()+"");
        psrd.setText(batsman1.getSr()+"");
    }

    @FXML
    private void showP2detail(MouseEvent event) {
        playerview.setVisible(true);
        System.out.println("player 2 detail here");
        pnamed.setText(batsman2.getName());
        prund.setText(batsman2.getRun()+"");
        pballd.setText(batsman2.getBall()+"");
        psixd.setText(batsman2.getSix()+"");
        pfourd.setText(batsman2.getFour()+"");
        psrd.setText(batsman2.getSr()+"");
    }

    @FXML
    private void closeview(MouseEvent event) {
        playerview.setVisible(false);
    }

}
