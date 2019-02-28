/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversion;

import java.util.Stack;

/**
 *
 * @author rizwan
 */
public class InfixToPostfix extends javax.swing.JFrame {

    /**
     * Creates new form InfixToPostfix
     */
    public InfixToPostfix() {
        initComponents();
    }
    
    public void Convert(String exp)
    {
        String Output = "" ;
        Stack s = new Stack();
        boolean fI = false;
        for(int i = 0; i<exp.length(); i++)
        {
            char pointer = exp.charAt(i);
            if(!iSOperator(pointer))
            {
                Output =  Output + Character.toString(pointer);
                if(i== (exp.length() -1))
                {
                    while(!s.empty())
                    {
                        Output = Output + s.pop();
                    }
                } else 
                {
                    if(fI)
                    {
                        if(pMin(pointer) && pMin((Character)s.peek()))
                        {
                            Output = Output + s.pop();
                            s.push(pointer);
                            if(i== (exp.length() -1))
                            {
                               while(!s.empty())
                                {
                                    Output = Output + s.pop();
                                }
                            }
                        }
                        else if(mDiv(pointer) && mDiv((Character)s.peek()))
                        {
                            Output = Output + s.pop();
                            s.push(pointer);
                            if(i== (exp.length() -1))
                            {
                               while(!s.empty())
                                {
                                    Output = Output + s.pop();
                                }
                            }
                        }
                        else if(pMin(pointer) && mDiv((Character)s.peek()))
                        {
                            Output = Output + s.pop();
                            s.push(pointer);
                            if(i== (exp.length() -1))
                            {
                               while(!s.empty())
                                {
                                    Output = Output + s.pop();
                                }
                            }
                        }
                        else if(mDiv(pointer) && pMin((Character)s.peek()))
                        {
                            s.push(pointer);
                            if(i== (exp.length() -1))
                            {
                               while(!s.empty())
                                {
                                    Output = Output + s.pop();
                                }
                            }
                        }
                        else
                        {
                            Output =  Output + Character.toString(pointer);
                            if(i== (exp.length() -1))
                            {
                               while(!s.empty())
                                {
                                    Output = Output + s.pop();
                                }
                            }
                        }
                    }
                    
                }
            } 
            else 
            {
                s.push(pointer);
                fI = true; 
            }
        }
        System.out.println(Output);
    }
    public boolean iSOperator(char op)
    {
        switch(op)
        {
            case '+' :
                return true;
            case '/' :
                return true;
            case '*' :
                return true;
            case '-' :
                return true; 
            case '^' :
                return true;
            default : return false;
             
        }
    }
    
    public boolean pMin(char op)
    {
        switch(op)
        {
            case '+' :
                return true;
            case '-' :
                return true;
            default : return false; 
        }
    }
    
    public boolean mDiv(char op)
    {
        switch(op)
        {
            case '*' :
                return true;
            case '/' :
                return true;
            default : return false; 
        }
    }
    
    
    public void Exp(String ex)
    {
        Stack st = new Stack();
        String ans = "";
        for(int i =0 ; i<ex.length(); i++)
        {
            char cur = ex.charAt(i);
            if(!iSOperator(cur)){
                ans = ans + Character.toString(cur);
            } else {
                st.push(cur);
            }
            if(i==(ex.length()-1))
            {
                while(!st.empty())
                {
                   ans = ans+st.pop(); 
                }
            }
        }
        get.setText(ans);
    }
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        display = new javax.swing.JTextField();
        get = new javax.swing.JLabel();
        btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        get.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        get.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn.setText("get");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(get, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btn)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(get, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btn)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed

        Exp(display.getText());

    }//GEN-LAST:event_btnActionPerformed

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
            java.util.logging.Logger.getLogger(InfixToPostfix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfixToPostfix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfixToPostfix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfixToPostfix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfixToPostfix().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JTextField display;
    private javax.swing.JLabel get;
    // End of variables declaration//GEN-END:variables
}
