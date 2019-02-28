
package Widget;

import java.awt.EventQueue;

public class ShutdownWidget extends javax.swing.JPanel {

    String OS ="";
    public ShutdownWidget() {
        initComponents();
        OS = System.getProperty("os.name");
        if(OS.contains("Windows"))
        {
            System.out.println("Haa " + OS);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

public static void main(String[] args)
{
    EventQueue.invokeLater(new Runnable(){
        
        public void run()
        {
            
          new ShutdownWidget().setVisible(true);
        }
    });
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


