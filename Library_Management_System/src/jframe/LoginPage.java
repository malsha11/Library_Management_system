/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     */
    public LoginPage() {
        initComponents(); 
    }
    
    // Validaion login
    public boolean validateLogin(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter username");
            return false;
        }
        
        if (pwd.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter password");
            return false;
        }
        return true;
    }
    
    // Varify cradit 
    public void login(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            PreparedStatement pst = con.prepareStatement("select * from users where name = ? and password = ? ");
            
            pst.setString(1, name);
            pst.setString(2, pwd);
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(this, "Login successful");
                HomePage home = new HomePage();
                home.setVisible(true);
                this.dispose();
                
            }else{
                JOptionPane.showMessageDialog(this, "incorrect username or password");
                
            }
        }catch (Exception e){
            e.printStackTrace();
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel1.setText("LIBRARY   MANAGEMENT   SYSTEM");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 0, 700, 130);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/library-2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 0, 980, 830);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 830));

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("Welcome  To");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -20, 350, 110));

        jPanel2.setBackground(new java.awt.Color(87, 169, 169));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setText("Login Page");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 240, 60));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 50, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel11.setText("Username");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 230, 30));

        txt_password.setBackground(new java.awt.Color(87, 169, 169));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setOpaque(false);
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 300, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel12.setText("Password");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 230, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 50, 50));

        txt_username.setBackground(new java.awt.Color(87, 169, 169));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setOpaque(false);
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 300, 40));

        jButton1.setBackground(new java.awt.Color(192, 228, 228));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 380, 50));

        jButton2.setBackground(new java.awt.Color(207, 207, 207));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("SIGNUP");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 380, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("You Can Login To Your Account Here");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 230, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 520, 830));

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 230, 60));

        setSize(new java.awt.Dimension(1541, 875));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validateLogin()){
            login();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        SignUpPage signUp= new SignUpPage();  // Go to SignUpPage Page
        signUp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
