/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entry;

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author rizwan
 */
public class Key implements KeyListener{

 
    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ESCAPE){
            System.out.println("you pressed Z");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("rel");
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(3);
        jf.addKeyListener(new Key());
        jf.setVisible(true);
        
    }
    
}
