/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    DefaultTableModel model;
    public ViewAllRecord() {
        initComponents();
        setIssueBokDetailsToTable(); // call the method
    }
    
    // To set the issue book  details in to the table 
    public void setIssueBokDetailsToTable(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root",""); //DB connection
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details"); // select all the data from issue_book__details table
            
            while (rs.next()){ // continue issue_book_details table addtions
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate =rs.getString("due_date");
                String status =rs.getString("status");
                
                Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                
                model.addRow(obj);
                
            }
            
        }catch (Exception e) {
            e.printStackTrace(); // catch the setIssueBookDetailsToTable method
            
        }
        
    }
    
    // Clear table method
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tbl_issueBookDetails.getModel();
        model.setRowCount(0);
    }
    
    // To fetch the record using date field
    public void search(){
        Date ufromDate = date_fromDate.getDatoFecha();//util package date (ufromDate mean util from Date)
        Date uToDate = date_toDate.getDatoFecha();//util package date (uToDate mean util To Date)
        
        Long l1 = ufromDate.getTime(); // get date  as a Long
        Long l2 = uToDate.getTime(); // get date as a Long
        
        // converting util package date o SQL pakage date ( If we did't do this we can't access SQl date)
        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection(); // DB connection
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){ // continue search
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate =rs.getString("due_date");
                String status =rs.getString("status");
                
                Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                
                model.addRow(obj);
                
            }
        } catch (Exception e) {
            e.printStackTrace();// catch the search method
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
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        jButton1 = new javax.swing.JButton();
        panal_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 91, 138));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicons8_Book_26px.png"))); // NOI18N
        jLabel12.setText(" View All Record ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 290, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(5, 5));
        jPanel6.setMinimumSize(new java.awt.Dimension(5, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 470, -1));

        date_fromDate.setBackground(new java.awt.Color(153, 22, 116));
        date_fromDate.setForeground(new java.awt.Color(153, 22, 116));
        date_fromDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_fromDate.setPlaceholder("Select Issued Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 280, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Issue Date");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 110, 40));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Due Date");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 110, 40));

        date_toDate.setBackground(new java.awt.Color(153, 22, 116));
        date_toDate.setForeground(new java.awt.Color(153, 22, 116));
        date_toDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_toDate.setPlaceholder("Select Due Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, 280, -1));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 160, 180, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 240));

        panal_table.setBackground(new java.awt.Color(255, 255, 255));
        panal_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_issueBookDetails.setBackground(new java.awt.Color(204, 204, 204));
        tbl_issueBookDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 153))); // NOI18N
        tbl_issueBookDetails.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setAlignmentX(5.0F);
        tbl_issueBookDetails.setAlignmentY(5.0F);
        tbl_issueBookDetails.setRowHeight(40);
        tbl_issueBookDetails.setRowMargin(10);
        tbl_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issueBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        panal_table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1380, -1));

        getContentPane().add(panal_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1480, 620));

        setSize(new java.awt.Dimension(1499, 904));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issueBookDetailsMouseClicked

    

    }//GEN-LAST:event_tbl_issueBookDetailsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearTable(); //  call the clearTable method (first clear the table details then call the search method)
        search(); // call the search method
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panal_table;
    private javax.swing.JTable tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}
