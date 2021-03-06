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
public class Deposit extends javax.swing.JFrame {

    /**
     * Creates new form Deposit
     */
    public Deposit() {
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

        amount = new javax.swing.JTextField();
        account = new javax.swing.JTextField();
        cancel = new javax.swing.JLabel();
        submit = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        withdraw = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(321, 100, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        amount.setBorder(null);
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });
        getContentPane().add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 111, 170, 29));

        account.setBorder(null);
        account.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                accountKeyReleased(evt);
            }
        });
        getContentPane().add(account, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 52, 170, 29));

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicsBank/cancel.png"))); // NOI18N
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicsBank/SUBMIT.png"))); // NOI18N
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        info.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 250, -1));

        balance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        balance.setForeground(new java.awt.Color(0, 102, 153));
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 250, -1));

        withdraw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        withdraw.setForeground(new java.awt.Color(153, 0, 0));
        withdraw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 260, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicsBank/rawImages/deposit.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelMouseClicked

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        // TODO add your handling code here:
         if(account.getText().length()==0 || amount.getText().length()==0) {
            JOptionPane.showMessageDialog( null, "Seems like fields are empty !!!");
        }
         else {
            
             Start.ac = Long.parseLong(account.getText());
        Start.B = Double.parseDouble(amount.getText());

        Start q = null;
        int i;

        for(i = 0; i<Start.data.size(); i++)
        {
            q = Start.data.get(i);
            if(q.getAcn() == Start.ac)
            break;
        }

        if(i == Start.data.size())

        JOptionPane.showMessageDialog(null, "Account number not found!!");

        else q.Deposit();

        account.setText("");
        amount.setText("");

         }
        
    }//GEN-LAST:event_submitMouseClicked

    private void accountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountKeyReleased
        // TODO add your handling code here:
        try {
            String s = account.getText();
            int i;
            for(i=0; i<s.length(); i++)
            {
                if(Character.isLetter(s.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Account Number should be in digit");
                    submit.setEnabled(false);
                } else submit.setEnabled(true);
            }
                 
        } catch(Exception e) {}
    }//GEN-LAST:event_accountKeyReleased

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
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account;
    private javax.swing.JTextField amount;
    public static javax.swing.JLabel balance;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel cancel;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel submit;
    public static javax.swing.JLabel withdraw;
    // End of variables declaration//GEN-END:variables
}
