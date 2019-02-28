/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author rizwan
 */
public class Game extends JPanel implements KeyListener, ActionListener {

    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon upmounth;
    private ImageIcon downmounth;
    private ImageIcon rightmounth;
    private ImageIcon leftmounth;

    private Timer timer;
    private int delay = 100;
    private int snakelength = 3;
    private int moves = 0;
    private int score = 0;

    private ImageIcon body;

    private ImageIcon head;
    
    private int[] enemyXpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,
        425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int[] enemyYpos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,
        425,450,475,500,525,550,575,600,625};
    
    private ImageIcon enemy;
    private Random rand = new Random();
    private int Xpos = rand.nextInt(34);
    private int Ypos = rand.nextInt(23);

    public Game() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        if (moves == 0) {
            snakeXlength[2] = 50;
            snakeXlength[1] = 75;
            snakeXlength[0] = 100;

            snakeYlength[2] = 100;
            snakeYlength[1] = 100;
            snakeYlength[0] = 100;
        }

        //draw head border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 56);

        //draw head image
        head = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\title.jpg");
        head.paintIcon(this, g, 25, 11);

        //draw background border
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);

        //draw background color
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
        //draw score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score " + score, 780, 45);

        rightmounth = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\righthead.png");
        rightmounth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);

        for (int i = 0; i < snakelength; i++) {

            if (i == 0 && right) {
                rightmounth = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\righthead.png");
                rightmounth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i == 0 && left) {
                leftmounth = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\leftthead.png");
                leftmounth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i == 0 && up) {
                upmounth = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\uphead.png");
                upmounth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i == 0 && down) {
                downmounth = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\righthead.png");
                downmounth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i != 0) {
                body = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\body.png");
                body.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
        }
        
        enemy = new ImageIcon("F:\\Work\\NetBeansProjects\\SnakeGame\\src\\img\\enemy.png");
        
        if(enemyXpos[Xpos] == snakeXlength[0] && enemyYpos[Ypos] == snakeYlength[0]){
            snakelength++;
            score++;
            Xpos = rand.nextInt(34);
            Ypos = rand.nextInt(23);
        }
        
        enemy.paintIcon(this, g, enemyXpos[Xpos], enemyYpos[Ypos]);
        
        for(int j=1; j<snakelength; j++){
            if(snakeXlength[j] == snakeXlength[0] && snakeYlength[j] == snakeYlength[0]){
                right = false;
                left = false;
                up = false;
                down = false;
                
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over", 320, 350);
                
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Arial", 0, 30));
                g.drawString("Press space for restart", 310, 400);
                
            }
        }
        
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            moves = 0;
            score =0;
            snakelength = 3;
            repaint(); 
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            } else {
                right = true;
                left = false;
            }
            up = false;
            down = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            } else {
                down = true;
                up = false;
            }
            left = false;
            right = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            down = true;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if (right) {
            for (int r = snakelength; r >= 0; r--) {
                snakeYlength[r + 1] = snakeYlength[r];
            }
            for (int r = snakelength; r >= 0; r--) {
                if (r == 0) {
                    snakeXlength[r] = snakeXlength[r] + 25;
                } else {
                    snakeXlength[r] = snakeXlength[r - 1];
                }
                if (snakeXlength[r] > 850) {
                    snakeXlength[r] = 25;
                }
            }
            repaint();
        }
        if (left) {
            for (int r = snakelength; r >= 0; r--) {
                snakeYlength[r + 1] = snakeYlength[r];
            }
            for (int r = snakelength; r >= 0; r--) {
                if (r == 0) {
                    snakeXlength[r] = snakeXlength[r] - 25;
                } else {
                    snakeXlength[r] = snakeXlength[r - 1];
                }
                if (snakeXlength[r] < 25) {
                    snakeXlength[r] = 850;
                }
            }
            repaint();

        }
        if (up) {

            for (int r = snakelength; r >= 0; r--) {
                snakeXlength[r + 1] = snakeXlength[r];
            }
            for (int r = snakelength; r >= 0; r--) {
                if (r == 0) {
                    snakeYlength[r] = snakeYlength[r] - 25;
                } else {
                    snakeYlength[r] = snakeYlength[r - 1];
                }
                if (snakeYlength[r] < 75) {
                    snakeYlength[r] = 625;
                }
            }
            repaint();

        }
        if (down) {
            for (int r = snakelength; r >= 0; r--) {
                snakeXlength[r + 1] = snakeXlength[r];
            }
            for (int r = snakelength; r >= 0; r--) {
                if (r == 0) {
                    snakeYlength[r] = snakeYlength[r] + 25;
                } else {
                    snakeYlength[r] = snakeYlength[r - 1];
                }
                if (snakeYlength[r] > 625) {
                    snakeYlength[r] = 75;
                }
            }
            repaint();

        }

    }

   
}
