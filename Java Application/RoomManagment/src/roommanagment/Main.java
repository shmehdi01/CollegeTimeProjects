/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roommanagment;



import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static roommanagment.Login.conn;

/**
 *
 * @author rizwan
 */

public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    Date date;
    String putDate;
    String grandTotal;
    public Main() {
        initComponents();
        l.setText("Welcome Mr. " + Login.name );
        name.setText(Login.name);
         getDate();
         editProfile(false);
         Login.getConnection();
         update.setVisible(false);
         viewprofile.setVisible(false);
         cp.setVisible(false);
         lastStatement();
         totalEx();
         checkMode();
         closeWindow();
        
    }
    
    private void editProfile (boolean b)
    {
        ename.setVisible(b);
        efname.setVisible(b);
        emob.setVisible(b);
        eemail.setVisible(b);
        ecity.setVisible(b);
        ebranch.setVisible(b);
        
        vname.setVisible(!b);
        vfname.setVisible(!b);
        vmob.setVisible(!b);
        vemail.setVisible(!b);
        vcity.setVisible(!b);
        vbranch.setVisible(!b);
        
        updateprofile.setEnabled(b);
    }
    
    private void updateProfile(String query , String msg) 
    {
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            
             int i = pst.executeUpdate();
        if(i==1)
        {
            profile();
            JOptionPane.showMessageDialog(null, msg + "d Successfully");
            
        }
        else JOptionPane.showMessageDialog(null, msg + " Failed");
        
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    JFrame jf;
    private void closeWindow()
    {
        jf = this;
      
           addWindowListener((new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                if (JOptionPane.showConfirmDialog(jf,
                        "You will be Logout!!", "Sure Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        dispose();
                        new Login().setVisible(true);
                    //System.exit(0);
                }
                else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        }));
  
        
    }
    

    
    
    private void checkMode()
    {
        if(Login.getmode.equalsIgnoreCase("Admin"))
            create.setEnabled(true);
        else create.setEnabled(false);
    }
    
    Thread t;
    Runnable time = new Runnable() {
        @Override
        public void run() {
             
            try{
                while(true)
                {
                    date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E dd-MMM-yyyy | KK:mm:ss a");
        dt.setText(ft.format(date)+"");
                }
                
            }catch(Exception e){}
        
            }
    };
    public void getDate() 
    {
      t = new Thread(time);
        t.start();
    }
    
   
            
    int s = 0;
    String getSno = null;
    String getTotal = null;
    private void lastStatement()
    {
        
        try {
            String query = "SELECT * FROM " + Login.userid ;
            
            PreparedStatement pst = conn.prepareStatement(query);
            
            ResultSet rs = pst.executeQuery();
           
            while(rs.next())
            {
                getSno= rs.getString(1);
                getTotal = rs.getString(2);
                total.setText(rs.getString(2) + " Rs.");
                le.setText(rs.getString(3) + " Rs.");
                pr.setText(rs.getString(4));
                d.setText(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void totalEx()
    {
        try {
            
            String query2 = "SELECT SUM(Expense) FROM " + Login.userid ;
            
            PreparedStatement pst2 = conn.prepareStatement(query2);
           
            ResultSet rs2 = pst2.executeQuery();
            
            if(rs2.next())
            {
               grandTotal = rs2.getString(1);
               total.setText(rs2.getString(1) + " Rs."); 
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
  
    
    private void updateStatement()
    {
       String am = amount.getText();
       String p = purpose.getText();
       
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyy");
       putDate = sdf.format(date);
       String query = "INSERT INTO " + Login.userid + " (s_no, Total, Expense, purpose, date) VALUE(?,?,?,?,?)";
      
        try {
            PreparedStatement pst = conn.prepareStatement(query);

            s = Integer.parseInt(getSno);
            s++;
            
            pst.setString(1, Integer.toString(s)); // user
            pst.setString(2, grandTotal ); // total
            pst.setString(3, am);
            pst.setString(4, p);
            pst.setString(5, putDate);
            
            int i = pst.executeUpdate();
            
            if(i>0)
            {
                JOptionPane.showMessageDialog(null, "Updated Successfully");
            }
            System.out.println(s);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        update();
    }
    
    
         private void update()
                 
     {
         totalEx();
        try {
            PreparedStatement pst2 = conn.prepareStatement("UPDATE " + Login.userid + " SET Total = " + grandTotal + " WHERE s_no = " + s);
    
            int j = pst2.executeUpdate();
            if(j>0)
            {
                System.out.println("done");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    private void profile() throws SQLException
    {
        String q = "SELECT * FROM membersrecord where user = " + "'"+ Login.userid + "'";
        PreparedStatement pst = conn.prepareStatement(q); 
        ResultSet rs = pst.executeQuery();
        
        
        while(rs.next())
        {
            
            vname.setText(rs.getString(3).toUpperCase());
            vfname.setText( rs.getString(11).toUpperCase());
            vage.setText(rs.getString(5));
            vdob.setText( rs.getString(12));
            vgen.setText(rs.getString(4));
            vmob.setText( rs.getString(10));
            vemail.setText( rs.getString(7));
            vcity.setText(rs.getString(6).toUpperCase());
            vbranch.setText( rs.getString(9).toUpperCase());
        }
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        le = new javax.swing.JLabel();
        pr = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        side = new javax.swing.JPanel();
        view = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        create = new javax.swing.JButton();
        home_b = new javax.swing.JButton();
        update_b = new javax.swing.JButton();
        detail = new javax.swing.JButton();
        change = new javax.swing.JButton();
        l = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        purpose = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        enter = new javax.swing.JButton();
        warn = new javax.swing.JLabel();
        viewprofile = new javax.swing.JPanel();
        vname = new javax.swing.JLabel();
        vfname = new javax.swing.JLabel();
        vdob = new javax.swing.JLabel();
        vgen = new javax.swing.JLabel();
        vmob = new javax.swing.JLabel();
        vemail = new javax.swing.JLabel();
        vcity = new javax.swing.JLabel();
        vbranch = new javax.swing.JLabel();
        vage = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        editprofile = new javax.swing.JButton();
        updateprofile = new javax.swing.JButton();
        ename = new javax.swing.JTextField();
        efname = new javax.swing.JTextField();
        emob = new javax.swing.JTextField();
        eemail = new javax.swing.JTextField();
        ecity = new javax.swing.JTextField();
        ebranch = new javax.swing.JTextField();
        cp = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        checkmatch = new javax.swing.JLabel();
        op = new javax.swing.JPasswordField();
        np = new javax.swing.JPasswordField();
        rnp = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 150, 0, 0));
        setMinimumSize(new java.awt.Dimension(600, 350));
        setPreferredSize(new java.awt.Dimension(580, 420));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 102));
        jLabel5.setText("Last Expense :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 102));
        jLabel6.setText("Purpose :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 102));
        jLabel7.setText("Date :");

        le.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        le.setForeground(new java.awt.Color(0, 153, 102));
        le.setText("label");

        pr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pr.setForeground(new java.awt.Color(0, 153, 102));
        pr.setText("label");

        d.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        d.setForeground(new java.awt.Color(0, 153, 102));
        d.setText("label");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 102));
        jLabel2.setText("Total Expense :");

        total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(0, 153, 102));
        total.setText("Total");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d)
                            .addComponent(pr)
                            .addComponent(le))))
                .addGap(69, 69, 69))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(le))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(d))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total)
                    .addComponent(jLabel2))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 370, 310));

        side.setBackground(new java.awt.Color(255, 255, 255));
        side.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        view.setBackground(new java.awt.Color(0, 153, 153));
        view.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        view.setForeground(new java.awt.Color(255, 255, 255));
        view.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\profile.png")); // NOI18N
        view.setText("View Profile");
        view.setBorder(null);
        view.setOpaque(false);
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        side.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 30));

        logout.setBackground(new java.awt.Color(204, 0, 0));
        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\logout.png")); // NOI18N
        logout.setText("Logout");
        logout.setBorder(null);
        logout.setOpaque(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        side.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, 35));

        create.setBackground(new java.awt.Color(102, 0, 102));
        create.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\createmem.png")); // NOI18N
        create.setText("Create Member");
        create.setBorder(null);
        create.setOpaque(false);
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        side.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 160, 35));

        home_b.setBackground(new java.awt.Color(0, 153, 153));
        home_b.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        home_b.setForeground(new java.awt.Color(255, 255, 255));
        home_b.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\home.png")); // NOI18N
        home_b.setText("Home");
        home_b.setBorder(null);
        home_b.setOpaque(false);
        home_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_bActionPerformed(evt);
            }
        });
        side.add(home_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 30));

        update_b.setBackground(new java.awt.Color(0, 153, 153));
        update_b.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update_b.setForeground(new java.awt.Color(255, 255, 255));
        update_b.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\entry.png")); // NOI18N
        update_b.setText("Update Expense");
        update_b.setBorder(null);
        update_b.setOpaque(false);
        update_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_bActionPerformed(evt);
            }
        });
        side.add(update_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, 30));

        detail.setBackground(new java.awt.Color(0, 153, 153));
        detail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detail.setForeground(new java.awt.Color(255, 255, 255));
        detail.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\data.png")); // NOI18N
        detail.setText("Check Total Expense");
        detail.setBorder(null);
        detail.setOpaque(false);
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });
        side.add(detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 30));

        change.setBackground(new java.awt.Color(0, 153, 153));
        change.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\cp2.png")); // NOI18N
        change.setText("Change Password");
        change.setBorder(null);
        change.setOpaque(false);
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        side.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 160, 30));

        getContentPane().add(side, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 310));

        l.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l.setText("welcome ");
        l.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 270, 30));

        dt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dt.setText("date");
        getContentPane().add(dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setForeground(new java.awt.Color(0, 153, 102));
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setText("Account Name :");
        update.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Enter Amount :");
        update.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        jLabel4.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Purpose :");
        update.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });
        update.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 117, 139, -1));
        update.add(purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 160, 139, -1));

        name.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 153, 102));
        name.setText("name");
        update.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        enter.setText("Update");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });
        update.add(enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 198, -1, -1));

        warn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        warn.setForeground(new java.awt.Color(204, 0, 0));
        update.add(warn, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 144, -1, -1));

        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 370, 310));

        viewprofile.setBackground(new java.awt.Color(255, 255, 255));
        viewprofile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vname.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vname.setForeground(new java.awt.Color(0, 153, 153));
        vname.setText("name");
        viewprofile.add(vname, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 26, -1, -1));

        vfname.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vfname.setForeground(new java.awt.Color(0, 153, 153));
        vfname.setText("father");
        viewprofile.add(vfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 54, -1, -1));

        vdob.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vdob.setForeground(new java.awt.Color(0, 153, 153));
        vdob.setText("dob");
        viewprofile.add(vdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 118, -1, -1));

        vgen.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vgen.setForeground(new java.awt.Color(0, 153, 153));
        vgen.setText("gender");
        viewprofile.add(vgen, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 146, -1, -1));

        vmob.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vmob.setForeground(new java.awt.Color(0, 153, 153));
        vmob.setText("mob");
        viewprofile.add(vmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 174, -1, -1));

        vemail.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vemail.setForeground(new java.awt.Color(0, 153, 153));
        vemail.setText("email");
        viewprofile.add(vemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 202, -1, -1));

        vcity.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vcity.setForeground(new java.awt.Color(0, 153, 153));
        vcity.setText("city");
        viewprofile.add(vcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 230, -1, -1));

        vbranch.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vbranch.setForeground(new java.awt.Color(0, 153, 153));
        vbranch.setText("branch");
        viewprofile.add(vbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 258, -1, -1));

        vage.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        vage.setForeground(new java.awt.Color(0, 153, 153));
        vage.setText("age");
        viewprofile.add(vage, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 85, -1, -1));

        label.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(0, 153, 153));
        label.setText("Name:");
        viewprofile.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 26, -1, -1));

        label1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 153, 153));
        label1.setText("Father's Name :");
        viewprofile.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 54, -1, -1));

        label2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 153, 153));
        label2.setText("Age:");
        viewprofile.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 85, -1, -1));

        label3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 153, 153));
        label3.setText("DOB :");
        viewprofile.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 118, -1, -1));

        label4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 153, 153));
        label4.setText("Gender :");
        viewprofile.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 146, -1, -1));

        label5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label5.setForeground(new java.awt.Color(0, 153, 153));
        label5.setText("Mobile :");
        viewprofile.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 174, -1, -1));

        label6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label6.setForeground(new java.awt.Color(0, 153, 153));
        label6.setText("Email ID :");
        viewprofile.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 202, -1, -1));

        label7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label7.setForeground(new java.awt.Color(0, 153, 153));
        label7.setText("City");
        viewprofile.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 230, -1, -1));

        label8.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        label8.setForeground(new java.awt.Color(0, 153, 153));
        label8.setText("Branch :");
        viewprofile.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 258, -1, -1));

        editprofile.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        editprofile.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\edit.png")); // NOI18N
        editprofile.setText("Edit");
        editprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editprofileActionPerformed(evt);
            }
        });
        viewprofile.add(editprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        updateprofile.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateprofile.setIcon(new javax.swing.ImageIcon("C:\\Users\\rizwan\\Desktop\\RM\\update.png")); // NOI18N
        updateprofile.setText("Update");
        updateprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateprofileActionPerformed(evt);
            }
        });
        viewprofile.add(updateprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        ename.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        ename.setForeground(new java.awt.Color(0, 153, 153));
        ename.setBorder(null);
        ename.setCaretColor(new java.awt.Color(153, 0, 0));
        ename.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        viewprofile.add(ename, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 26, -1, -1));

        efname.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        efname.setForeground(new java.awt.Color(0, 153, 153));
        efname.setBorder(null);
        efname.setCaretColor(new java.awt.Color(153, 0, 0));
        efname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        viewprofile.add(efname, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 54, -1, -1));

        emob.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        emob.setForeground(new java.awt.Color(0, 153, 153));
        emob.setBorder(null);
        emob.setCaretColor(new java.awt.Color(153, 0, 0));
        emob.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        viewprofile.add(emob, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 174, -1, -1));

        eemail.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        eemail.setForeground(new java.awt.Color(0, 153, 153));
        eemail.setBorder(null);
        eemail.setCaretColor(new java.awt.Color(153, 0, 0));
        eemail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        viewprofile.add(eemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 202, -1, -1));

        ecity.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        ecity.setForeground(new java.awt.Color(0, 153, 153));
        ecity.setBorder(null);
        ecity.setCaretColor(new java.awt.Color(153, 0, 0));
        ecity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        viewprofile.add(ecity, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 230, -1, -1));

        ebranch.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        ebranch.setForeground(new java.awt.Color(0, 153, 153));
        ebranch.setBorder(null);
        ebranch.setCaretColor(new java.awt.Color(153, 0, 0));
        ebranch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        viewprofile.add(ebranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 258, -1, -1));

        getContentPane().add(viewprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 370, 340));

        cp.setBackground(new java.awt.Color(255, 255, 255));
        cp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Old Password");
        cp.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 79, -1, -1));

        jLabel9.setText("New Password");
        cp.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 120, -1, -1));

        jLabel10.setText("Re - Enter Password");
        cp.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 148, -1, -1));

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        cp.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 196, -1, -1));

        checkmatch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cp.add(checkmatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 171, -1, -1));
        cp.add(op, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 76, 148, -1));

        np.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                npKeyReleased(evt);
            }
        });
        cp.add(np, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 114, 148, -1));

        rnp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rnpKeyReleased(evt);
            }
        });
        cp.add(rnp, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 145, 148, -1));

        getContentPane().add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 370, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        home.setVisible(false);
        update.setVisible(false);
        cp.setVisible(false);
        viewprofile.setVisible(true);
        try {
            profile();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
         this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
       new Registration().setVisible(true);
    }//GEN-LAST:event_createActionPerformed

    private void home_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_bActionPerformed
        lastStatement();
        totalEx();
        home.setVisible(true);
        update.setVisible(false);
        viewprofile.setVisible(false);
        cp.setVisible(false);
    }//GEN-LAST:event_home_bActionPerformed

    private void update_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_bActionPerformed
        home.setVisible(false);
        update.setVisible(true);
         viewprofile.setVisible(false);
         cp.setVisible(false);
    }//GEN-LAST:event_update_bActionPerformed

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        new EntryDetail().setVisible(true);
    }//GEN-LAST:event_detailActionPerformed

    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
       
        if(amount.getText().isEmpty() || purpose.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Fields are empty");
        }
        else updateStatement();
       amount.setText("");
       purpose.setText("");
    }//GEN-LAST:event_enterActionPerformed

    private void amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyReleased
         boolean b = false;
        for(int i =0 ; i<amount.getText().length(); i++)
        {
            if(Character.isLetter(amount.getText().charAt(i)) || Character.isSpaceChar(amount.getText().charAt(i)))
                b = true;
        }
        if(b)
        {
            warn.setText("Enter valid amount");
            enter.setEnabled(false);
        }
        
        else 
        {
            warn.setText("");
            enter.setEnabled(true);
        }
        
               
               


    }//GEN-LAST:event_amountKeyReleased

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        home.setVisible(false);
        update.setVisible(false);
        cp.setVisible(true);
        viewprofile.setVisible(false);
    }//GEN-LAST:event_changeActionPerformed

    private void editprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editprofileActionPerformed
        editProfile(true);
        ename.setText(vname.getText());
        efname.setText(vfname.getText());
        emob.setText(vmob.getText());
        ecity.setText(vcity.getText());
        eemail.setText(vemail.getText());
        ebranch.setText(vbranch.getText());
        
    }//GEN-LAST:event_editprofileActionPerformed

    private void updateprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateprofileActionPerformed
        String query = "UPDATE membersrecord SET name = '" + ename.getText() + "', father = '" + efname.getText() +
                "', mobile = '" + emob.getText() + "', city ='" + ecity.getText() +"', email ='" + eemail.getText() +
                "', branch = '" + ebranch.getText() + "' WHERE user = '" + Login.userid + "'";
        //System.out.println(query);
        updateProfile(query, "Update");
        editProfile(false);
//        vname.setText(ename.getText());
//        vfname.setText(efname.getText());
//        vmob.setText(emob.getText());
//        vcity.setText(ecity.getText());
//        vemail.setText(eemail.getText());
//        vbranch.setText(ebranch.getText());
    }//GEN-LAST:event_updateprofileActionPerformed

    private void rnpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rnpKeyReleased
         try {
            if(rnp.getText().length() == 0)
            {
                checkmatch.setText("");
                
            }
           else if (rnp.getText().equals(np.getText()))
            {
                checkmatch.setForeground(Color.GREEN);
                checkmatch.setText("Password Match");
                submit.setEnabled(true);
            }
            else 
            {
               checkmatch.setForeground(Color.RED);
                checkmatch.setText("Password Did'nt Matching");
                submit.setEnabled(false);
            }
        }catch(Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_rnpKeyReleased

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
      
        if(op.getText().length()==0 || np.getText().length() == 0 ||rnp.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Fields are empty");
        }
        else
        {
           if(op.getText().equals(Login.getPass))
             {
                String query = "UPDATE membersrecord SET pass = '" + np.getText() + "' WHERE user = '" + Login.userid + "'";
                //System.out.println(Login.getPass); 
                updateProfile(query, "Password Change");
              }
            else JOptionPane.showMessageDialog(null, "Old password was incorrect"); 
        }
        
        
       
    }//GEN-LAST:event_submitActionPerformed

    private void npKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npKeyReleased
      
        try {
           if(np.getText().equals(Login.userid))
               checkmatch.setText("Password & username are same !!");
           else checkmatch.setText("");
       }catch(Exception e) {}
    }//GEN-LAST:event_npKeyReleased

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JButton change;
    private javax.swing.JLabel checkmatch;
    private javax.swing.JPanel cp;
    private javax.swing.JButton create;
    private javax.swing.JLabel d;
    private javax.swing.JButton detail;
    private javax.swing.JLabel dt;
    private javax.swing.JTextField ebranch;
    private javax.swing.JTextField ecity;
    private javax.swing.JButton editprofile;
    private javax.swing.JTextField eemail;
    private javax.swing.JTextField efname;
    private javax.swing.JTextField emob;
    private javax.swing.JTextField ename;
    private javax.swing.JButton enter;
    private javax.swing.JPanel home;
    private javax.swing.JButton home_b;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel l;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel le;
    private javax.swing.JButton logout;
    private javax.swing.JLabel name;
    private javax.swing.JPasswordField np;
    private javax.swing.JPasswordField op;
    private javax.swing.JLabel pr;
    private javax.swing.JTextField purpose;
    private javax.swing.JPasswordField rnp;
    private javax.swing.JPanel side;
    private javax.swing.JButton submit;
    private javax.swing.JLabel total;
    private javax.swing.JPanel update;
    private javax.swing.JButton update_b;
    private javax.swing.JButton updateprofile;
    private javax.swing.JLabel vage;
    private javax.swing.JLabel vbranch;
    private javax.swing.JLabel vcity;
    private javax.swing.JLabel vdob;
    private javax.swing.JLabel vemail;
    private javax.swing.JLabel vfname;
    private javax.swing.JLabel vgen;
    private javax.swing.JButton view;
    private javax.swing.JPanel viewprofile;
    private javax.swing.JLabel vmob;
    private javax.swing.JLabel vname;
    private javax.swing.JLabel warn;
    // End of variables declaration//GEN-END:variables
}
