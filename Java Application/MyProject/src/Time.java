
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rizwan
 */
public class Time implements Runnable {

    Thread t;

    public Time() {
        
    }

    @Override
    public void run() {
        try {

            Date dt = new Date();
            while (true) {
                SimpleDateFormat ft = new SimpleDateFormat();
                System.out.println(ft.format(ft.format(dt)));

            }
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
