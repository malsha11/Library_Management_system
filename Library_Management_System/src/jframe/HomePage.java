/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ACER
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    
    DefaultTableModel model;
    public HomePage() {
        initComponents();
        setStudentDetailsToTable(); // call the method
        setBookDetailsToTable(); // call the method
        setDataToCards(); //call the method
    }
    
    // To set the Students details in to the table 
    public void setStudentDetailsToTable(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root",""); //DB connection
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(" select * from student_details"); // select all the data from students_details table
            
            while (rs.next()){ // continue studentDetails table addtions
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String branch =rs.getString("branch");
                
                Object[] obj = {studentId,studentName,course,branch};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                
                model.addRow(obj);
                
            }
            
        }catch (Exception e) {
            e.printStackTrace(); // catch the setstudentDetailsToTable method
            
        }
        
    }
    
     // To set the book details in to the table 
    public void setBookDetailsToTable(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root",""); //DB connection
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(" select * from book_details"); // select all the data from book_details table
            
            while (rs.next()){ // continue bookDetails table addtions
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quentity =rs.getInt("quentity");
                
                Object[] obj = {bookId,bookName,author,quentity};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                
                model.addRow(obj);
                
            }
            
        }catch (Exception e) {
            e.printStackTrace(); // catch the setBookDetailsToTable method
            
        }
        
    }
    
    public void setDataToCards(){
        
        Statement st = null;
        ResultSet rs = null;
        
        long l = System.currentTimeMillis();
        Date todayDate = new Date(l);
        
        try {
            Connection con = DBConnection.getConnection();
            
            st = con.createStatement();
            PreparedStatement pst = con.prepareStatement("select * from book_details", ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            rs= pst.executeQuery();
            rs.last(); // go to last record and it will return the count of row
            lbl_numberOfBooks.setText(Integer.toString(rs.getRow()));
            
            
            PreparedStatement pst1 = con.prepareStatement("select * from student_details", ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            rs= pst1.executeQuery();
            rs.last(); // go to last record and it will return the count of row
            lbl_numberOfStudents.setText(Integer.toString(rs.getRow()));
            
            
            PreparedStatement pst2 = con.prepareStatement("select * from issue_book_details where status = '"+"pending"+"'", ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            rs= pst2.executeQuery();
            rs.last(); // go to last record and it will return the count of row
            lbl_issuedBooks.setText(Integer.toString(rs.getRow()));
            
            
             PreparedStatement pst3 = con.prepareStatement("select * from issue_book_details where due_date < '"+todayDate+"' and status = '"+"pending"+"'", ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            rs= pst3.executeQuery();
            rs.last(); // go to last record and it will return the count of row
            lbl_defaulterList.setText(Integer.toString(rs.getRow()));
                    
                    
            
        } catch (Exception e) {
            e.printStackTrace(); //catch the setDataCard method
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

        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lbl_numberOfStudents = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_numberOfBooks = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lbl_issuedBooks = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new javax.swing.JTable();

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(30000, 30000));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 50, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 5, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel2.setText("Welcome To Admin Panel");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, -1, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 310, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 65));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel5.setText("  Manage Books");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("  Home Page");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel7.setText("  Dashboard");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(23, 23, 23))
        );

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel8.setText("  Dashboard");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Conference_26px.png"))); // NOI18N
        jLabel9.setText("  Manage Students");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbl_logout.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Exit_26px.png"))); // NOI18N
        lbl_logout.setText("  Logout");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Books_26px.png"))); // NOI18N
        jLabel11.setText("  Issue Books");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel12.setText("  View Records");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicons8_Book_26px.png"))); // NOI18N
        jLabel14.setText("  View Issued Books");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel15.setText(" Defaulter List");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return book png.png"))); // NOI18N
        jLabel13.setText("  Return Books");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(59, 59, 59)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lbl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(771, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(761, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel11.setBackground(new java.awt.Color(199, 241, 241));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 102, 102)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numberOfStudents.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        lbl_numberOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_People_50px.png"))); // NOI18N
        lbl_numberOfStudents.setText("10");
        jPanel11.add(lbl_numberOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 130, -1));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 260, 140));

        jLabel16.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Student Details");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 240, -1));

        jPanel12.setBackground(new java.awt.Color(199, 241, 241));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 102, 102)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numberOfBooks.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        lbl_numberOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issue.png"))); // NOI18N
        lbl_numberOfBooks.setText("10");
        jPanel12.add(lbl_numberOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 130, -1));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 260, 140));

        jLabel19.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Number of Students");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 240, -1));

        jPanel13.setBackground(new java.awt.Color(199, 241, 241));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 102, 102)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_defaulterList.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Statics.png"))); // NOI18N
        lbl_defaulterList.setText("10");
        jPanel13.add(lbl_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 120, -1));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 110, 260, 140));

        jLabel21.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Defaulter List");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 240, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Issued books (Pending Books)");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 290, -1));

        jPanel14.setBackground(new java.awt.Color(199, 241, 241));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(204, 0, 51)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issuedBooks.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        lbl_issuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issuedBooks.setText("10");
        jPanel14.add(lbl_issuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 130, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Number of Students");
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 240, -1));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 260, 140));

        tbl_studentDetails.setBackground(new java.awt.Color(204, 204, 204));
        tbl_studentDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 153))); // NOI18N
        tbl_studentDetails.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setAlignmentX(5.0F);
        tbl_studentDetails.setAlignmentY(5.0F);
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.setRowMargin(10);
        jScrollPane1.setViewportView(tbl_studentDetails);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 1090, 280));

        jLabel26.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Number of Books");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 240, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Book Details");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 680, 240, -1));

        tbl_bookDetails.setBackground(new java.awt.Color(204, 204, 204));
        tbl_bookDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 153))); // NOI18N
        tbl_bookDetails.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book id", "Name", "Author", "Quentity"
            }
        ));
        tbl_bookDetails.setAlignmentX(5.0F);
        tbl_bookDetails.setAlignmentY(5.0F);
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.setRowMargin(10);
        jScrollPane2.setViewportView(tbl_bookDetails);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 720, 1080, 270));

        setSize(new java.awt.Dimension(1532, 1086));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        
        ManageStudents student = new ManageStudents(); // Go to ManageStudent page
        student.setVisible(true);
        dispose();        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
        ManageBooks books = new ManageBooks();  // Go to MannageBooks Page
        books.setVisible(true);
        dispose();
       
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
       
    }//GEN-LAST:event_jLabel5MouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
       
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
       
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        
    }//GEN-LAST:event_jPanel8MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        IssueBook book = new IssueBook(); // Go to the IssueBook Panel
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ReturnBook book1 = new ReturnBook(); // Go to Return Book page
        book1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        ViewAllRecord  allRecord = new ViewAllRecord(); // Go to ViewAllRecord page
        allRecord.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        IssueBookDetails  issueBook = new IssueBookDetails(); // Go to IssueBookDetails page
        issueBook.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        DefaulterList  list = new DefaulterList(); // Go to DefaulterList page
        list.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);// logout button code
        
        
    }//GEN-LAST:event_lbl_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issuedBooks;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_numberOfBooks;
    private javax.swing.JLabel lbl_numberOfStudents;
    private javax.swing.JTable tbl_bookDetails;
    private javax.swing.JTable tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
