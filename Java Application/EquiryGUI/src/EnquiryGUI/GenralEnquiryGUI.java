/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnquiryGUI;

/**
 *
 * @author rizwan
 */
public class GenralEnquiryGUI extends javax.swing.JFrame {

    /**
     * Creates new form GenralEnquiryGUI
     */
    public GenralEnquiryGUI() {
        initComponents();
        header();
        body();
    }
    
    public void header()
    {
        String head = "<html> <style type=text/css> #txt { background-color:#79f0e3;  border:2px solid cyan; width:1000px;height:200px; text-align:center;  }  </style> <b>  <div id=txt> </div></b> </html>";
        String zeal = "<html> <style type=text/css> #zeal { color:231984; font-weight:bold; font-size:40px; text-decoration:underline; text-align:center; font-family:Times New Roman; }</style> <p id=zeal> Zeal educates </p> </html>";
        String title = "<html> <style type=text/css> #zeal { color:231984; font-weight:bold; font-size:18px; text-align:center; font-family:Brush Script MT; }</style> <p id=zeal> Education that changes life... </p> </html>";
        String bar = "<html> <style type=text/css> #txt {  background-color:#c4d87d; border:2px solid red; width:1000px;height:200px; text-align:center;  }  </style> <div id=txt> g </div></html>";
        
        header.setText(head);
        zealedu.setText(zeal);
        this.title.setText(title);
        this.bar.setText(bar);
        msg.setText("“ Education is provider of alernative view of the worlds and a strengthener of the will to explore them”");
    }
    public void body()
    {
        String bg = "<html> <style> #bg { background-color:white; height:500px; width:1000px; } </style> <div id=bg> </div> </html>";
        String lists = "<html> <ul> <li> Campus  <li> Lab <li> Hostel <li> Transport <li> Smart Classes <li>Science Park <li> Libarary <li> Sports <li> Seminar Room</ul> </html> ";
        body.setText(bg);
        facilities.setText("<html> <style type=text/css> #fac { height:150px; width:140px; }</style> <div id=fac><u> Facilities </u> </div></html>");
        list.setText(lists);
        ver.setText("<html> <style type=text/css> #chk { height:150px; width:1px;  border:2px solid black;}</style> <div id=chk>  </div> </html>");
        ver1.setText("<html> <style type=text/css> #chk { height:250px; width:1px;  border:2px solid black;}</style> <div id=chk>  </div> </html>");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zealedu = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        bar = new javax.swing.JLabel();
        facilities = new javax.swing.JLabel();
        list = new javax.swing.JLabel();
        ver = new javax.swing.JLabel();
        ver1 = new javax.swing.JLabel();
        body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        zealedu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zealedu.setText("zeal educates");
        getContentPane().add(zealedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1000, 60));

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("that changes lifes");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 1000, -1));
        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 120));

        msg.setFont(new java.awt.Font("Lucida Sans", 3, 17)); // NOI18N
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setText("“ Education is provider of alernative view of the worlds and a strengthener of the will to explore them”");
        getContentPane().add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));
        getContentPane().add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, 80));

        facilities.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        facilities.setText("Facilities");
        getContentPane().add(facilities, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 190, -1));

        list.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        list.setText("jLabel1");
        getContentPane().add(list, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 170));

        ver.setText("jLabel1");
        getContentPane().add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 1, 190));

        ver1.setText("jLabel1");
        getContentPane().add(ver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 1, 500));
        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GenralEnquiryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenralEnquiryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenralEnquiryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenralEnquiryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenralEnquiryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bar;
    private javax.swing.JLabel body;
    private javax.swing.JLabel facilities;
    private javax.swing.JLabel header;
    private javax.swing.JLabel list;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel title;
    private javax.swing.JLabel ver;
    private javax.swing.JLabel ver1;
    private javax.swing.JLabel zealedu;
    // End of variables declaration//GEN-END:variables
}
