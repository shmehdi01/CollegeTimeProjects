/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keylistener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author rizwan
 */
public class Ball extends JPanel implements ActionListener, KeyListener {

    Timer t;
    int x = 0, y = 0, velX = 0, velY = 0;

    public Ball() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        t =  new Timer(1, this);
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            velX = -1;
            velY = 0;
        }
        if (code == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 1;
        }
        if (code == KeyEvent.VK_UP) {
            velX = 0;
            velY = -1;
        }
        if (code == KeyEvent.VK_RIGHT) {
            velX = 1;
            velY = 0;
        }
       
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (x < 0) {
            x = 0;
            velX = 0;
        }
        if(x>550){
            velX = 0;
            x = 550;
        }
        if(y<0){
            y = 0;
            velY = 0;
        }
        if(y>300){
            velY = 0;
            y = 300;
        }
        
        velX = 0;
        velY = 0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        t.start();
        x = x + velX;
        y = y + velY;
        repaint();
    }

    public static void main(String[] args) {
        Ball ball = new Ball();
        JFrame jf = new JFrame();
        jf.setSize(600, 400);
        jf.setLayout(null);
        jf.add(ball);
        ball.setVisible(true);
        ball.setSize(600, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(3);
    }

}
