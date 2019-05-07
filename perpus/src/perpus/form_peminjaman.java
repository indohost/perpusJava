/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import java.awt.Desktop;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SYADIF
 */
public class form_peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form form_peminjaman
     */
    public Statement st;
    public ResultSet rs;
   
    private String tgl_pinjam, tgl_kembali;
    public DefaultTableModel tabmodel, tabmodel2;
    private int jumlahdata;
    
    Connection cn = koneksi.koneksi.getkoneksi(); 
    
    public form_peminjaman() {
        initComponents();
        judul();
        judul_pinjam();
        tampildata();
        tampildatasementara();
        tampil_combo_kd_buku();
        tampil_combo_nis();
        tampil_nama();
       
    }
    
    public void pinjam (){
       Date tgl = new Date();
       dt_pinjam.setDate(tgl);
       
    }
    
    public void kembali(){
       Date tgl = new Date();
       dt_kembali.setDate(tgl);
    }
    
    public void judul(){
        Object [] judul = {"kd_buku", "jdl_buku", "tgl_terbit", "pengarang", "penerbit"};
        tabmodel = new DefaultTableModel(null, judul);
        tbl_data.setModel(tabmodel);
    }
        
    public void tampildata(){
        try {
            st = cn.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("select * from tbl_buku");
            while (rs.next() ){
                Object[] data = {
                    rs.getString("kd_buku"),
                    rs.getString("jdl_buku"),
                    rs.getString("tgl_terbit"),
                    rs.getString("pengarang"),
                    rs.getString("penerbit"),
             
                };
                tabmodel.addRow(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void tampildatasementara(){
        try {
            st = cn.createStatement();
            tabmodel2.getDataVector().removeAllElements();
            tabmodel2.fireTableDataChanged();
            rs = st.executeQuery("select * from tbl_pinjam");
            while (rs.next() ){
                Object[] data = {
                    rs.getString("nis"),
                    rs.getString("kd_buku"),
                    rs.getString("jdl_buku"),
                    rs.getString("pengarang"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_kembali"),
                };
                tabmodel2.addRow(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void tampil_combo_kd_buku() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from tbl_buku");
            while (rs.next()) {
                cb_kdbuku.addItem(rs.getString("kd_buku"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tampil_combo_nis() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from tbl_anggota");
            while (rs.next()) {
                cb_nis.addItem(rs.getString("nis"));              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tampil_isi(){
        try {
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            st = cn.createStatement();
            rs = st.executeQuery("select * from tbl_anggota where nis like '%" + cb_nis.getSelectedItem() + "%' or  nama like '%" + txt_nama.getText() +  "%' ");
            while (rs.next()){
                Object[] data = {
                    rs.getString("nis"),
                    rs.getString("nama")            
                };
                tabmodel.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    
    public void judul_pinjam() {
        Object [] judul_pinjam = {"nis","kd_buku", "jdl_buku", "pengarang", "tgl_pinjam", "tgl_kembali"};
        tabmodel2 = new DefaultTableModel(null, judul_pinjam);
        tbl_pinjam.setModel(tabmodel2);
        
    }
    public void reset(){
        txt_judul.setText("");
        txt_pengarang.setText("");

        btn_cetak.setEnabled(true);
        btn_cari.setEnabled(true);
    }
    
    public void tampil_nis(){
        try
        {
            st = cn.createStatement();
            rs = st.executeQuery("select * from tbl_anggota where nis='" + cb_nis.getSelectedItem() + "'");

            while(rs.next())
                {
                    txt_nama.setText(rs.getString("nama"));
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"GAGAL");
        }
        
    }
    
    public void tampil_data(){
        try
        {
            st = cn.createStatement();
            rs = st.executeQuery("select * from tbl_buku where kd_buku='" + cb_kdbuku.getSelectedItem() + "'");

            while(rs.next())
                {
                    txt_judul.setText(rs.getString("jdl_buku"));
                    txt_pengarang.setText(rs.getString("pengarang"));                    
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"GAGAL");
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

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        btn_cari = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cb_nis = new javax.swing.JComboBox<>();
        txt_nama = new javax.swing.JTextField();
        dt_pinjam = new com.toedter.calendar.JDateChooser();
        dt_kembali = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_pinjam = new javax.swing.JTable();
        btn_cetak = new javax.swing.JButton();
        txt_judul = new javax.swing.JTextField();
        txt_pengarang = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_kdbuku = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_data.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                tbl_dataAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        btn_cari.setBackground(new java.awt.Color(255, 153, 0));
        btn_cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaksi Peminjaman Buku");

        btn_menu.setBackground(new java.awt.Color(255, 153, 0));
        btn_menu.setForeground(new java.awt.Color(255, 255, 255));
        btn_menu.setText("Menu");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btn_cari)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_menu)
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_menu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cari)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NIS");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tgl Pinjam");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tgl Kembali");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nama Siswa");

        cb_nis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Nis" }));
        cb_nis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_nisMouseClicked(evt);
            }
        });
        cb_nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dt_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nama)
                    .addComponent(cb_nis, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(dt_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(dt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cb_nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        tbl_pinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_pinjam);

        btn_cetak.setBackground(new java.awt.Color(255, 153, 0));
        btn_cetak.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak.setText("Cetak");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        txt_judul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_judulActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(255, 153, 0));
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("+");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Judul");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pengarang");

        cb_kdbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kode Buku" }));
        cb_kdbuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_kdbukuMouseClicked(evt);
            }
        });
        cb_kdbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kdbukuActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kode Buku");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cetak))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txt_judul, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cb_kdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(29, 29, 29)
                                .addComponent(txt_pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_tambah))
                        .addGap(27, 27, 27)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pengarang)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(cb_kdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(txt_judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cetak)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
       try {
            Desktop.getDesktop().browse(new URL("http://localhost:82/perpus/laporan.php").toURI());
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        try {
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            st = cn.createStatement();
            rs = st.executeQuery("select * from tbl_buku where kd_buku like '%" + txt_cari.getText() + "%' or  jdl_buku like '%" + txt_cari.getText() + "%' or tgl_terbit like '%" + txt_cari.getText() + "%' or pengarang like '%" + txt_cari.getText() + "%' or penerbit like '%" + txt_cari.getText() + "%' or jml_buku like '%" + txt_cari.getText() +  "%' ");
            while (rs.next()){
                Object[] data = {
                    rs.getString("kd_buku"),
                    rs.getString("jdl_buku"),
                    rs.getString("tgl_terbit"),
                    rs.getString("pengarang"),
                    rs.getString("penerbit"),
            
                };
                tabmodel.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_cariKeyReleased

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        // TODO add your handling code here:
        try{
            int jawab;
            if ((JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin ingin keluar dari form peminjaman data?", "konfirmasi", JOptionPane.YES_NO_OPTION) ) == 0)
            {
                form_menu n = new form_menu();
                n.setVisible(true);
                this.setVisible(false);
            } else {
                form_peminjaman n = new form_peminjaman();
                n.setVisible(true);
                this.setVisible(false);    
            }
        }catch (Exception e){
            e.printStackTrace();
        } 

    }//GEN-LAST:event_btn_menuActionPerformed

     private void tampil_nama() {
         //jComboBox1.addItem("");
        try {
            String sql = "select nama from tbl_anggota";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cb_nis.addItem(rs.getString(0));
            }

        } catch (Exception e) {
        }
    }
    
    private void txt_judulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_judulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_judulActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:\
               if (cb_kdbuku.getSelectedItem().equals("Pilih Kode Buku") || cb_nis.getSelectedItem().equals("Pilih Nis") || 
                txt_nama.getText().equals("") || txt_judul.getText().equals("") ||
                txt_pengarang.getText().equals("") || dt_kembali.getDate() == null || dt_pinjam.getDate() == null)
               {
                  JOptionPane.showMessageDialog(null, "data tidak ada");            
               } else {
                      try {

                        st = cn.createStatement();
                        st.execute("insert into tbl_pinjam values ('" + tgl_pinjam + "', '" + tgl_kembali + "', '" + cb_nis.getSelectedItem() + "', '" + txt_nama.getText() + "', '" + cb_kdbuku.getSelectedItem() + "', '" + txt_judul.getText() + "', '" + txt_pengarang.getText() + "')");

                        tampildatasementara();

                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                        cb_kdbuku.setSelectedItem(null);
                        cb_nis.setSelectedItem(null);
                        txt_nama.setText("");
                        txt_judul.setText("");
                        txt_pengarang.setText("");
                        dt_pinjam.setDate(null);
                        dt_kembali.setDate(null);

                    } catch (Exception e){
                        e.printStackTrace();
                    }
               }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void dt_pinjamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dt_pinjamPropertyChange
        // TODO add your handling code here:
        if(dt_pinjam.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tgl_pinjam = format.format(dt_pinjam.getDate());
        }
    }//GEN-LAST:event_dt_pinjamPropertyChange

    private void dt_kembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dt_kembaliPropertyChange
        // TODO add your handling code here:
        if(dt_kembali.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tgl_kembali = format.format(dt_kembali.getDate());
        }
    }//GEN-LAST:event_dt_kembaliPropertyChange

    private void cb_kdbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kdbukuActionPerformed
        // TODO add your handling code here:
       tampil_data();
    }//GEN-LAST:event_cb_kdbukuActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void cb_nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nisActionPerformed
        // TODO add your handling code here:
        tampil_nis();
    }//GEN-LAST:event_cb_nisActionPerformed

    private void tbl_dataAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_tbl_dataAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_dataAncestorMoved

    private void cb_kdbukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_kdbukuMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cb_kdbukuMouseClicked

    private void cb_nisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_nisMouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_cb_nisMouseClicked

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
            java.util.logging.Logger.getLogger(form_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cb_kdbuku;
    private javax.swing.JComboBox<String> cb_nis;
    private com.toedter.calendar.JDateChooser dt_kembali;
    private com.toedter.calendar.JDateChooser dt_pinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTable tbl_pinjam;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_judul;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_pengarang;
    // End of variables declaration//GEN-END:variables
}
