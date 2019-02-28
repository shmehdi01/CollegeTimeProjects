/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author rizwan
 */
public class Home {
    
    public static void main(String[] args) {
        Game g = new Game();
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setBounds(10,10,905,700);
        f.setBackground(Color.DARK_GRAY);
        f.setResizable(false);
        f.setDefaultCloseOperation(3);
        f.add(g);
    }
    
}
