/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket.scoreboard.function;


/**
 *
 * @author rizwan
 */
public class Batsman {
    
    private String name;
    private int run;
    private int ball;
    private int four;
    private int six;
    private float sr;

    public Batsman() {
    }

    public Batsman(String name, int run, int ball, int four, int six, float sr) {
        this.name = name;
        this.run = run;
        this.ball = ball;
        this.four = four;
        this.six = six;
        this.sr = sr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public float getSr() {
        return sr;
    }

    public void setSr(float sr) {
        this.sr = sr;
    }
    
}
