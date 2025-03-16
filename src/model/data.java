/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package model;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class data extends javax.swing.JFrame {

    Koleksidata koleksi = new Koleksidata();

    public <T> void showMessage(T message) {
        JOptionPane.showMessageDialog(this, message.toString(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void tampilkanData(List<? extends inventory> daftar) {
        for (inventory item : daftar) {
            System.out.println("ID: " + item.getId() + ", Nama: " + item.getNama());
        }
    }

    private void resizeListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeColumns();
            }
        });
    }

    private void resizeColumns() {
        int tW = button.getWidth();
        TableColumnModel jTableColumnModel = tabel.getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();

        // Gunakan persentase default untuk setiap kolom
        float defaultWidth = 100.0f / cantCols;

        for (int i = 0; i < cantCols; i++) {
            TableColumn column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(defaultWidth * tW);
            column.setPreferredWidth(pWidth);
        }
        tabel.setRowHeight(27);
    }

    private String fileSizeOf(File file) {
        DecimalFormat format = new DecimalFormat("#.##");
        long MB = 1024 * 1024;
        long KB = 1024;
        final double length = file.length();
        if (length > MB) {
            return format.format(length / MB) + " MB";
        }
        if (length > KB) {
            return format.format(length / KB) + " KB";
        }
        return format.format(length) + " B";
    }

    private String extensionOf(File file) {
        String fileExtension = "";
        String fileName = file.getName();
        if (fileName.contains(".") && fileName.lastIndexOf(".") != 0) {
            fileExtension
                    = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return fileExtension;
    }

    private void addFiles(File[] files) {
        for (File file : files) {
            if (!file.getName().toLowerCase().endsWith(".csv")) {
                JOptionPane.showMessageDialog(this, "File " + file.getName() + " bukan format CSV!", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    // Cek apakah data memiliki 4 kolom
                    if (data.length < 4) {
                        JOptionPane.showMessageDialog(this,
                                "Format salah di baris: " + line, "Error",
                                JOptionPane.ERROR_MESSAGE);
                        continue;  // Lewati baris yang tidak sesuai format
                    }

                    try {
                        int id = Integer.parseInt(data[0].trim());
                        String nama = data[1].trim();
                        String kategori = data[2].trim();
                        int stok = Integer.parseInt(data[3].trim());

                        inventory item = new inventory(id, nama, kategori, stok);
                        koleksi.add(item);
                        koleksi.fireTableDataChanged(); 

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this,
                                "Data tidak valid di baris: " + line, "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Terjadi kesalahan saat membaca file: " + file.getName(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addFolder(File dir) {
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
                    addFiles(new File[]{file});
                }
            }
        }
    }

    public data() {
        initComponents();
        tabel.setModel(koleksi);
        resizeColumns();
        resizeListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popuptombol = new javax.swing.JPopupMenu();
        addFile = new javax.swing.JMenuItem();
        AddFolder = new javax.swing.JMenuItem();
        Clear = new javax.swing.JMenuItem();
        pnfooter = new javax.swing.JPanel();
        button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        addFile.setText("Add File");
        addFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileActionPerformed(evt);
            }
        });
        popuptombol.add(addFile);

        AddFolder.setText("Add Folder");
        AddFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFolderActionPerformed(evt);
            }
        });
        popuptombol.add(AddFolder);

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        popuptombol.add(Clear);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button.setText("File");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnfooterLayout = new javax.swing.GroupLayout(pnfooter);
        pnfooter.setLayout(pnfooterLayout);
        pnfooterLayout.setHorizontalGroup(
            pnfooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnfooterLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(655, Short.MAX_VALUE))
        );
        pnfooterLayout.setVerticalGroup(
            pnfooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnfooterLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(pnfooter, java.awt.BorderLayout.PAGE_END);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "Kategori", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        popuptombol.show(button, 0, button.getHeight());
    }//GEN-LAST:event_buttonActionPerformed

    private void addFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        fc.setDialogTitle("Add Files");
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new FileNameExtensionFilter("CSV File (*.csv)", "csv"));
        fc.setApproveButtonText("Add Files");

        int show = fc.showOpenDialog(this);
        if (show == JFileChooser.APPROVE_OPTION) {
            File[] files = fc.getSelectedFiles();
            addFiles(files); // Perbaikan: Menggunakan addFiles()
        }
    }//GEN-LAST:event_addFileActionPerformed

    private void AddFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFolderActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Add Inventory Category");
        fc.setApproveButtonText("Add Category");

        int show = fc.showOpenDialog(this);
        if (show == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            addFolder(file);
        }
    }//GEN-LAST:event_AddFolderActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        koleksi.clear();
        JOptionPane.showMessageDialog(this, "Semua data inventory telah dihapus.", "Clear Inventory", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_ClearActionPerformed

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
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddFolder;
    private javax.swing.JMenuItem Clear;
    private javax.swing.JMenuItem addFile;
    private javax.swing.JButton button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnfooter;
    private javax.swing.JPopupMenu popuptombol;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
