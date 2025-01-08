package PresentacionP;

import Impresion.ImprimirArqueo;
import LogicaP.Lingresop;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Jlista extends javax.swing.JFrame {

    public Jlista() {
        initComponents();
        setTitle("Lista Vehiculos Activos");
        mostrar("");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        configurarTabla();

    }
    private void configurarTabla() {
        // Aquí configuras el comportamiento y el estilo de la tabla
        tablalistado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablalistado.setRowHeight(25); // Ajusta la altura de las filas
        tablalistado.setRowMargin(5); // Espacio entre filas

        // Cambiar color del encabezado usando un renderer personalizado
        JTableHeader header = tablalistado.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setBackground(new Color(255, 255, 153));
                cell.setForeground(Color.BLACK); // Texto para encabezado
                cell.setFont(new Font("SansSerif", Font.BOLD, 14)); // Fuente personalizada
                return cell;
            }
        });
    }
    

    private void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            Lingresop func = new Lingresop();
            modelo = func.mostrarIngreso(buscar);

            tablalistado.setModel(modelo);
//            ocultar_columnas();
            lblregistro.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblregistro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablalistado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblregistro.setText("jLabel1");

        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblregistro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblregistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblregistro)
                    .addComponent(jButton1))
                .addContainerGap(410, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        //        btnguardar.setText("Editar");
        //        habilitar();
        //        btneliminar.setEnabled(true);
        //        accion = "editar";
        //
        //        int fila = tablalistado.rowAtPoint(evt.getPoint());
        //
        //        txtidempleado.setText(tablalistado.getValueAt(fila, 0).toString());
        //        txtnombres.setText(tablalistado.getValueAt(fila, 1).toString());
        //        txtapellidos.setText(tablalistado.getValueAt(fila, 2).toString());
        //        comtipodocumento.setSelectedItem(tablalistado.getValueAt(fila, 3).toString());
        //        txtnumdocumento.setText(tablalistado.getValueAt(fila, 4).toString());
        //        txttelefono.setText(tablalistado.getValueAt(fila, 5).toString());
        //        txtdireccion.setText(tablalistado.getValueAt(fila, 6).toString());
        //        txtemail.setText(tablalistado.getValueAt(fila, 7).toString());
        //        txtpais.setText(tablalistado.getValueAt(fila, 8).toString());
        //        txtciudad.setText(tablalistado.getValueAt(fila, 9).toString());
        //        cboacceso.setSelectedItem(tablalistado.getValueAt(fila, 10).toString());
        //        txtlogin.setText(tablalistado.getValueAt(fila, 11).toString());
        //        txtpassword.setText(tablalistado.getValueAt(fila, 12).toString());
        //        cboestado.setSelectedItem(tablalistado.getValueAt(fila, 13).toString());
        //        txteps.setText(tablalistado.getValueAt(fila, 14).toString());
        //        txtarl.setText(tablalistado.getValueAt(fila, 15).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        ImprimirArqueo lista = new ImprimirArqueo();
        try {
            lista.ImprimirArqueo();
        } catch (IOException ex) {
            Logger.getLogger(Jlista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Jlista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrintException ex) {
            Logger.getLogger(Jlista.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(Jlista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jlista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jlista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jlista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jlista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblregistro;
    private javax.swing.JTable tablalistado;
    // End of variables declaration//GEN-END:variables
}
