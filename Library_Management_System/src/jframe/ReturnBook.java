/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author ACER
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    
    // Updating book count
    public void  updateBookCount(){
         int bookId = Integer.parseInt(txt_bookId.getText());
         
         try {
            Connection con = DBConnection.getConnection(); // connect to the databse
            String sql = "update book_details set quentity = quentity -1  where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            if ( rowCount > 0){
                JOptionPane.showMessageDialog(this, " Book Count Updated ");
                int initialCount = Integer.parseInt(lbl_issueDate.getText());
                lbl_issueDate.setText(Integer.toString(initialCount -1 ));
                
            }else {
                JOptionPane.showMessageDialog(this, " Can't Update Book ");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    // To fetch the issue book details from the databse and display to book details panel
    public void getIssueBookDetails(){
        
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                lbl_issueId.setText(rs.getString("id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_studentName.setText(rs.getString("student_name"));
                lbl_issueDate.setText(rs.getString("issue_date"));
                lbl_dueDate.setText(rs.getString("due_date"));
                
                lbl_bookError.setText("");
                
            }else{
                lbl_bookError.setText(" No Record Found ");
                
                lbl_issueId.setText("");
                lbl_bookName.setText("");
                lbl_studentName.setText("");
                lbl_issueDate.setText("");
                lbl_dueDate.setText("");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    // Return the book
    public boolean returnBook(){
        boolean isReturned = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status = ? where student_id = ? and book_id = ? and status = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "returned");
            pst.setInt(2, studentId);
            pst.setInt(3, bookId);
            pst.setString(4, "pending");
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0 ){
                isReturned = true;
                
            }else{
                isReturned = false;
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturned;
        
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panal_main = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_issueDate = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_issueId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_issueDate1 = new javax.swing.JLabel();
        lbl_issueDate2 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        btn_issuedBook = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_issuedBook1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panal_main.setBackground(new java.awt.Color(255, 255, 255));
        panal_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 22, 116));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicons8_Book_26px.png"))); // NOI18N
        jLabel12.setText("  Book Details");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 200, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(5, 5));
        jPanel6.setMinimumSize(new java.awt.Dimension(5, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 115, 300, -1));

        lbl_issueDate.setBackground(new java.awt.Color(255, 255, 255));
        lbl_issueDate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 220, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Name :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 200, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student Name :");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 200, -1));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Issue Id :");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 200, -1));

        lbl_issueId.setBackground(new java.awt.Color(255, 255, 255));
        lbl_issueId.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_issueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 220, 30));

        lbl_bookName.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 230, 30));

        lbl_studentName.setBackground(new java.awt.Color(255, 255, 255));
        lbl_studentName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 220, 30));

        lbl_bookError.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookError.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, 340, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Issue Date :");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 200, -1));

        lbl_issueDate1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_issueDate1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_issueDate1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 220, 30));

        lbl_issueDate2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_issueDate2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_issueDate2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 220, 30));

        lbl_dueDate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, 230, 30));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Due Date :");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 200, -1));

        panal_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 480, 820));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 22, 116));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel1.setText(" Return Book");
        panal_main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 130, 240, 50));

        jPanel2.setBackground(new java.awt.Color(153, 22, 116));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panal_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 180, 280, 10));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 22, 116));
        jLabel11.setText("Enter Book Id :");
        panal_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 330, 150, 30));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 22, 116)));
        txt_bookId.setOpaque(false);
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panal_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 310, 290, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 22, 116));
        jLabel14.setText("Enter Student Id :");
        panal_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 410, 160, 30));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 22, 116)));
        txt_studentId.setOpaque(false);
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panal_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 400, 290, 40));

        btn_issuedBook.setBackground(new java.awt.Color(0, 102, 204));
        btn_issuedBook.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_issuedBook.setText("Return Book");
        btn_issuedBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issuedBookActionPerformed(evt);
            }
        });
        panal_main.add(btn_issuedBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 640, 180, 60));

        jPanel5.setBackground(new java.awt.Color(0, 91, 138));

        jLabel8.setBackground(new java.awt.Color(102, 186, 202));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Back");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panal_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 70));

        btn_issuedBook1.setBackground(new java.awt.Color(153, 22, 116));
        btn_issuedBook1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_issuedBook1.setText("FIND");
        btn_issuedBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issuedBook1ActionPerformed(evt);
            }
        });
        panal_main.add(btn_issuedBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 550, 180, 60));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Webp.net-resizeimage (1).jpg"))); // NOI18N
        jLabel18.setText("Issue Id :");
        panal_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 770, 780));

        getContentPane().add(panal_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1790, 820));

        setSize(new java.awt.Dimension(1796, 850));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        HomePage home = new HomePage ();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
       
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void btn_issuedBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issuedBookActionPerformed
        
     
        
        
        
    }//GEN-LAST:event_btn_issuedBookActionPerformed

    private void btn_issuedBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issuedBook1ActionPerformed
        getIssueBookDetails(); // call the getIssueBookDetails method
    }//GEN-LAST:event_btn_issuedBook1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_issuedBook;
    private javax.swing.JButton btn_issuedBook1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueDate1;
    private javax.swing.JLabel lbl_issueDate2;
    private javax.swing.JLabel lbl_issueId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panal_main;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
