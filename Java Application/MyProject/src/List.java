
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rizwan
 */
class List implements ActionListener
{
    JFrame f; int j = 0;
    JComboBox <String> cb,cb1;
    JTextField tf;
    JLabel l,l1;
    JButton b ,b1;
    String d ;
     String s ;
    public static ArrayList <String> al = new ArrayList();
    public static ArrayList  li;
    public List()
    {
       f = new JFrame();
       tf = new JTextField();
       b = new JButton("tip");
       b1 = new JButton("Delete");
       b.addActionListener(this);
       b1.addActionListener(this);
       f.setVisible(true);
       f.setBounds(50,100,400,400);
       f.setDefaultCloseOperation(3);
       f.setLayout(null);
       li = new ArrayList();
       //cb = new JComboBox();
       //.add(cb);
       f.add(tf);
       f.add(b);
       f.add(b1);
       //cb.setBounds(20,20,100,20);
       tf.setBounds(20,50,100,20);
       b.setBounds(120,50,50,20);
       b1.setBounds(170,50,70,20);
       
    }
    
    public void actionPerformed(ActionEvent e)
    {
      int i; 
      cb = new JComboBox();
      f.add(cb);
      cb.setBounds(20,20,100,20);
      d = tf.getText();
      al.add(d);
      for(i=0; i<al.size(); i++)
      {
      s = al.get(i);
      }
      cb.addItem(s);
      l = new JLabel();
      f.add(l);
      l.setBounds(((i*10)+10),80,100,30);
      l.setText(s); 
      l1 = new JLabel();
      j=j+1;
      f.add(l1);
      l1.setBounds(((i*10)+10),100,100,30);
      l1.setText(j +"");
      tf.setText("");
      Toolkit.getDefaultToolkit().beep();
    }
    
   
    
   public static void main(String []args) 
   {
       new List();
      
       
   }

   
}
