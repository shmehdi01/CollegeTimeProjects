/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomKey;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author rizwan
 */
public class GetKey extends javax.swing.JFrame {

    int Max;
    int counter;
    int lower,upper,digit;
    String Key = null;
    public GetKey() {
        initComponents();
        
        counter = 0;
        Max = 8;
        lower = 2;
        upper = 2;
        digit = 4;
        getValue();
        
               
    }
    
    public void getValue()
    {
        try{
            
        digit = Integer.parseInt(digit1.getText());
        lower = Integer.parseInt(lower1.getText());
        upper= Integer.parseInt(upper1.getText());
        Max = digit + lower + upper;
        key.setText("Key Length : "+Max);
        }catch(Exception e)
        {
     
        }
           getKey();
    }
   
    public void getKey()
    {
        try{
           
        Random getRandom = new Random();
        int count =0;
 
        StringBuilder  sb = new StringBuilder();
        String[] charList = {"a", "b", "c", "d", "e", "f", "g", "e", "h", "i", "j", "k", "l", "m", "n",
                      "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "E", "H", "I", "J", "K", "L", "M", "N",
                      "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", 
                      "1", "2", "30","4","5","6","7","8","9","0" };
        String getChar;
        String tempKey = null;
        while(count<Max)
        {
        getChar = charList[getRandom.nextInt(charList.length)];
        tempKey = (sb.append(getChar)).toString(); 
        count++;
        }
        Condition(tempKey);
        
        }catch(Exception e) {}
        
    }
    public void Condition(String get)
    {
        try{
           
            String temp = get;
       char Check;
       int d=0, l=0, U=0;
       for(int i = 0; i<temp.length(); i++)
       {
          Check = temp.charAt(i);
          if(Character.isDigit(Check))
             d++;
          if(Character.isLetter(Check) && Character.isUpperCase(Check))
              U++;
          if(Character.isLetter(Check) && Character.isLowerCase(Check))
              l++;      
       }
       if(d!=digit)
           getKey();
       else if(l!=lower)
           getKey();
       else if(U!=upper)
           getKey();
       else result.setText(temp);
            
        } catch(Exception e) {}
       
         
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        digit1 = new javax.swing.JTextField();
        upper1 = new javax.swing.JTextField();
        lower1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        key = new javax.swing.JLabel();
        result = new javax.swing.JTextField();
        get = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        digit1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        digit1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        digit1.setText("4");
        digit1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                digit1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                digit1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                digit1KeyTyped(evt);
            }
        });

        upper1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        upper1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        upper1.setText("2");
        upper1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                upper1KeyReleased(evt);
            }
        });

        lower1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lower1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lower1.setText("2");
        lower1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lower1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Digit :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Lowercase :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Uppercase :");

        key.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        key.setText("Key Length : 8");

        result.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        result.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        get.setText("Generate Random");
        get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(digit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lower1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(upper1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(get, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(digit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lower1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upper1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(get)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void digit1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_digit1KeyReleased
         
       
    }//GEN-LAST:event_digit1KeyReleased

    private void lower1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lower1KeyReleased
         getValue();
    }//GEN-LAST:event_lower1KeyReleased

    private void upper1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_upper1KeyReleased
        getValue();
    }//GEN-LAST:event_upper1KeyReleased

    private void getActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getActionPerformed
      getValue();
    }//GEN-LAST:event_getActionPerformed

    private void digit1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_digit1KeyTyped
       
    }//GEN-LAST:event_digit1KeyTyped

    private void digit1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_digit1KeyPressed
         
    }//GEN-LAST:event_digit1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GetKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetKey().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField digit1;
    private javax.swing.JButton get;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel key;
    private javax.swing.JTextField lower1;
    private javax.swing.JTextField result;
    private javax.swing.JTextField upper1;
    // End of variables declaration//GEN-END:variables
}