package PresentacionP;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Javanzadop extends javax.swing.JFrame {

    public Javanzadop() {
        initComponents();
        setTitle("AVANZADO");
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setSize(screenSize.width, screenSize.height);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnempleados = new javax.swing.JButton();
        btnhabitaciones = new javax.swing.JButton();
        lblacceso = new javax.swing.JLabel();
        btnCongelado = new javax.swing.JButton();
        btnReportes2 = new javax.swing.JButton();
        btnInformes1 = new javax.swing.JButton();
        btnbloqueos = new javax.swing.JButton();
        btnproducto = new javax.swing.JButton();
        jdmenu = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnempleados.setBackground(new java.awt.Color(255, 255, 204));
        btnempleados.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnempleados.setForeground(new java.awt.Color(0, 0, 102));
        btnempleados.setText("REGISTRO EMPLEADOS");
        btnempleados.setBorderPainted(false);
        btnempleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnempleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnempleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnempleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        btnhabitaciones.setBackground(new java.awt.Color(255, 255, 204));
        btnhabitaciones.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnhabitaciones.setForeground(new java.awt.Color(0, 0, 102));
        btnhabitaciones.setText("REGISTRO ZONAS");
        btnhabitaciones.setBorderPainted(false);
        btnhabitaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnhabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhabitacionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnhabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 30));
        jPanel1.add(lblacceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 18, 74, -1));

        btnCongelado.setBackground(new java.awt.Color(255, 255, 204));
        btnCongelado.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnCongelado.setForeground(new java.awt.Color(0, 0, 102));
        btnCongelado.setText("REGISTRO TARIFAS");
        btnCongelado.setBorderPainted(false);
        btnCongelado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCongelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongeladoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCongelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 30));

        btnReportes2.setBackground(new java.awt.Color(255, 255, 204));
        btnReportes2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnReportes2.setForeground(new java.awt.Color(0, 0, 102));
        btnReportes2.setText("REPORTES");
        btnReportes2.setBorderPainted(false);
        btnReportes2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportes2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 90, 30));

        btnInformes1.setBackground(new java.awt.Color(255, 255, 204));
        btnInformes1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnInformes1.setForeground(new java.awt.Color(0, 0, 102));
        btnInformes1.setText("INFORMES");
        btnInformes1.setBorderPainted(false);
        btnInformes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInformes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformes1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnInformes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 90, 30));

        btnbloqueos.setBackground(new java.awt.Color(255, 255, 204));
        btnbloqueos.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnbloqueos.setForeground(new java.awt.Color(0, 0, 102));
        btnbloqueos.setText("BLOQUEOS");
        btnbloqueos.setBorderPainted(false);
        btnbloqueos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbloqueos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbloqueosActionPerformed(evt);
            }
        });
        jPanel1.add(btnbloqueos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 100, 30));

        btnproducto.setBackground(new java.awt.Color(255, 255, 204));
        btnproducto.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnproducto.setForeground(new java.awt.Color(0, 0, 102));
        btnproducto.setText("VALOR TIPO SERVICIO");
        btnproducto.setBorderPainted(false);
        btnproducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 150, 30));

        javax.swing.GroupLayout jdmenuLayout = new javax.swing.GroupLayout(jdmenu);
        jdmenu.setLayout(jdmenuLayout);
        jdmenuLayout.setHorizontalGroup(
            jdmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
        );
        jdmenuLayout.setVerticalGroup(
            jdmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdmenu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhabitacionesActionPerformed
        Jzona Jzona = new Jzona();
        jdmenu.add(Jzona);

        Jzona.setVisible(true);
    }//GEN-LAST:event_btnhabitacionesActionPerformed

    private void btnempleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnempleadosActionPerformed
//        new Jregistroempleados().setVisible(true);
        Jempleadosp Jregistroempleados = new Jempleadosp();
        jdmenu.add(Jregistroempleados);
        Jregistroempleados.toFront();
        Jregistroempleados.setVisible(true);
    }//GEN-LAST:event_btnempleadosActionPerformed

    private void btnCongeladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongeladoActionPerformed
        // TODO add your handling code here:
        JTrifas_p conelado = new JTrifas_p();
        jdmenu.add(conelado);
        conelado.toFront();
        conelado.setVisible(true);
    }//GEN-LAST:event_btnCongeladoActionPerformed

    private void btnbloqueosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbloqueosActionPerformed
      
        Jbloqueos bloqueo = new Jbloqueos();
        jdmenu.add(bloqueo);
        bloqueo.toFront();
        bloqueo.setVisible(true);
    }//GEN-LAST:event_btnbloqueosActionPerformed

    private void btnReportes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportes2ActionPerformed
        // TODO add your handling code here:
        Jreportes reportes = new Jreportes();
        jdmenu.add(reportes);
        reportes.toFront();
        reportes.setVisible(true);
    }//GEN-LAST:event_btnReportes2ActionPerformed

    private void btnproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductoActionPerformed
        Jtipo Jproducto = new Jtipo();
        jdmenu.add(Jproducto);
        Jproducto.toFront();
        Jproducto.setVisible(true);
    }//GEN-LAST:event_btnproductoActionPerformed

    private void btnInformes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInformes1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Javanzadop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCongelado;
    private javax.swing.JButton btnInformes1;
    private javax.swing.JButton btnReportes2;
    private javax.swing.JButton btnbloqueos;
    private javax.swing.JButton btnempleados;
    private javax.swing.JButton btnhabitaciones;
    private javax.swing.JButton btnproducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane jdmenu;
    public static javax.swing.JLabel lblacceso;
    // End of variables declaration//GEN-END:variables
}
