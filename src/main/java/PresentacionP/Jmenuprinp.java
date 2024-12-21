package PresentacionP;

import LogicaP.Cconexionp;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;

public class Jmenuprinp extends javax.swing.JFrame {
    

    public static Boolean sesionIniciada = false;
    private LoguinDeAdminp Javanzadop;
   

    public Jmenuprinp() {

        initComponents();
        setLocationRelativeTo(null);
//        setTitle("SISTEMA SIHOMULTISERV");

        setLocationRelativeTo(this);
        inhabilitar();
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setBounds(0, 0, screenSize.width, screenSize.height);
//        setVisible(true);

    }

    static void inhabilitar() {
        lblidpersona.setVisible(false);
        lblnombres.setVisible(false);
        lblapellidos.setVisible(false);
        lblacceso.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        lblnombres = new javax.swing.JLabel();
        lblapellidos = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        lblidpersona = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        btnparqueadero = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 204, 204));

        lblnombres.setText("nombres");

        lblapellidos.setText("apellidos");

        lblacceso.setText("acceso");

        lblidpersona.setText("idpersona");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblnombres)
                    .addComponent(lblacceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblidpersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1012, 1012, 1012))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(lblnombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblacceso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblidpersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblapellidos)
                .addContainerGap(467, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.add(jMenu3);

        jMenu1.setBackground(new java.awt.Color(0, 204, 204));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inicio.png"))); // NOI18N
        jMenu1.setText("MENU PRINCIPAL");

        btnparqueadero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estacionamiento.png"))); // NOI18N
        btnparqueadero.setText("PARQUEADERO");
        btnparqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnparqueaderoActionPerformed(evt);
            }
        });
        jMenu1.add(btnparqueadero);

        jMenuItem3.setText("LAVANDERO");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Configuraciones.png"))); // NOI18N
        jMenu2.setText("CONFIGURACIÓN");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/datosmaestros.png"))); // NOI18N
        jMenuItem5.setText("DATOS MESTROS");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ayuda.png"))); // NOI18N
        jMenuItem6.setText("AYUDA");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Javanzadop = new LoguinDeAdminp();
        Javanzadop.toFront();
        Javanzadop.setVisible(true);
        sesionIniciada = true;
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnparqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnparqueaderoActionPerformed
       // Mostrar la interfaz del parquedero
    Jmenuparqueadero form = new Jmenuparqueadero();
    escritorio.add(form);
    form.toFront();
    form.setVisible(true);

    // Conectar a la base de datos del parquedero
    Cconexionp conexionParquedero = new Cconexionp();
    Connection conParquedero = conexionParquedero.establecerConexionp();
    
    if (conParquedero != null) {
//        System.out.println("Conectado a la base de datos del parquedero");
    } else {
//        System.out.println("Error al conectar a la base de datos del parquedero");
    }
    }//GEN-LAST:event_btnparqueaderoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Jmenuprinp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnparqueadero;
    private javax.swing.JPanel escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblapellidos;
    public static javax.swing.JLabel lblidpersona;
    public static javax.swing.JLabel lblnombres;
    // End of variables declaration//GEN-END:variables
}
