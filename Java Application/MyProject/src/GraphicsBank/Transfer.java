/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicsBank;

import javax.swing.JOptionPane;

/**
 *
 * @author rizwan
 */
public class Transfer extends javax.swing.JFrame {

    /**
     * Creates new form Transfer
     */
    public Transfer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toaccount = new javax.swing.JTextField();
        myaccount = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        balance = new javax.swing.JLabel();
        withdraw = new javax.swing.JLabel();
        submit = new javax.swing.JLabel();
        cancel = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(321, 100, 0, 0));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toaccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        toaccount.setBorder(null);
        toaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toaccountActionPerformed(evt);
            }
        });
        toaccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toaccountKeyReleased(evt);
            }
        });
        getContentPane().add(toaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 93, 170, 29));

        myaccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myaccount.setBorder(null);
        myaccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                myaccountKeyReleased(evt);
            }
        });
        getContentPane().add(myaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 93, 170, 29));

        amount.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amount.setBorder(null);
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });
        getContentPane().add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 168, 190, 50));

        balance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        balance.setForeground(new java.awt.Color(0, 102, 153));
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 380, 30));

        withdraw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        withdraw.setForeground(new java.awt.Color(153, 0, 0));
        withdraw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        withdraw.setToolTipText("");
        getContentPane().add(withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 550, 30));

        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicsBank/SUBMIT.png"))); // NOI18N
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicsBank/cancel.png"))); // NOI18N
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicsBank/rawImages/transfer.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 710, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toaccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toaccountActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "You Canceled");
    }//GEN-LAST:event_cancelMouseClicked

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        // TODO add your handling code here:
         if(myaccount.getText().length()==0 || amount.getText().length()==0 || toaccount.getText().length()==0) {
            JOptionPane.showMessageDialog( null, "Seems like fields are empty !!!");
        }
         
         else {
             
             Start.ac = Long.parseLong(myaccount.getText());
        Start.Recv_ac = Long.parseLong(toaccount.getText());
        Start.B = Double.parseDouble(amount.getText());
        
        Start send = null;
        Start recv = null;
        int i, j;
        
        for(i=0; i<Start.data.size(); i++)
        {
            send = Start.data.get(i);
            if(send.getAcn() == Start.ac)
                break;
        }
        
        if(i == Start.data.size())
        {
            JOptionPane.showMessageDialog(null, "Your Account Number Not Found!!");
        }
        else
        {
            for(j=0; j<Start.data.size(); j++)
            {
                recv = Start.data.get(j);
                if(recv.getAcn() == Start.Recv_ac)
                    break;
            }
            if(j == Start.data.size())
            {
                JOptionPane.showMessageDialog(null, "Receiver Account Number Not Found!!");
            }
            else recv.Transfer(send);
        }
        
        toaccount.setText("");
        myaccount.setText("");
        amount.setText("");
         }
        
    }//GEN-LAST:event_submitMouseClicked

    private void myaccountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myaccountKeyReleased
        // TODO add your handling code here:
        try {
            String s = myaccount.getText();
            int i;
            for(i=0; i<s.length(); i++)
            {
                if(Character.isLetter(s.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Account Number should be in digit");
                    submit.setEnabled(false);
                } else submit.setEnabled(true);
            }
                 
        } catch(Exception e) {}
    }//GEN-LAST:event_myaccountKeyReleased

    private void toaccountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toaccountKeyReleased
        // TODO add your handling code here:
        try {
            String s = toaccount.getText();
            int i;
            for(i=0; i<s.length(); i++)
            {
                if(Character.isLetter(s.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Account Number should be in digit");
                    submit.setEnabled(false);
                } else submit.setEnabled(true);
            }
                 
        } catch(Exception e) {}
    }//GEN-LAST:event_toaccountKeyReleased

    private void amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyReleased
        // TODO add your handling code here:
        try {
            String s = amount.getText();
            int i;
            for(i=0; i<s.length(); i++)
            {
                if(Character.isLetter(s.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Amount should be in digit");
                    submit.setEnabled(false);
                } else submit.setEnabled(true);
            }
                 
        } catch(Exception e) {}
    }//GEN-LAST:event_amountKeyReleased

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    public static javax.swing.JLabel balance;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel cancel;
    private javax.swing.JTextField myaccount;
    private javax.swing.JLabel submit;
    private javax.swing.JTextField toaccount;
    public static javax.swing.JLabel withdraw;
    // End of variables declaration//GEN-END:variables
}