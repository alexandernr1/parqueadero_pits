package PresentacionP;

import DatosP.Dingresop;
import DatosP.Dinicioturnop;
import DatosP.Dsalidap;
import DatosP.Dzona;
import Impresion.ImprimirSalidap;
import LogicaP.Cconexionp;
import LogicaP.Fsalidap;
import LogicaP.Fzonap;
import LogicaP.Lingresop;
import LogicaP.Tiempopro;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jsalidap extends javax.swing.JFrame {

    Tiempopro time = new Tiempopro();
    PreparedStatement pst;
    ResultSet rs;

    public Jsalidap() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("SALIDA VEHICULO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrarTiempo();
        agregarWindowFocusListener();
        vehiculosEnParqueo();
        inicioenceros();
        ocultar();
    }
    private String accion = "guardar";

    private void mostrarTiempo() {

        txtfechasalida.setText(time.getFechacomp() + " " + time.getHoracomp());
    }

    private void agregarWindowFocusListener() {
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

                generarnumero();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // No hacer nada cuando la ventana pierde el foco
            }
        });
    }

    private void limpiar() {

        txtplaca.setText("");
        cbotipovehiculo.setSelectedItem("SELECCIONAR");
        cbotipovehiculo.setSelectedItem("SELECCIONAR");
        txtfechaentrada.setText("");
        txtcliente.setText("O");
        txtzona.setText("");
        txtdias.setText("0");
        txthoras.setText("0");
        txtminutos.setText("0");
        mostrarTiempo();//actualiza la fecha de salida
        vehiculosEnParqueo();//actualiza los vehiculos activos en el parqueadero

        txtvalor.setText("0");
        txtdescuento.setText("0");
        txtIVA_19.setText("0");
        txtvalorSinIVA.setText("0");
        txtsubtotal.setText("0");
        txtefectivo.setText("0");
        txttarjeta.setText("0");
        txttransferencia.setText("0");
        txttotal.setText("0");

        txtidempleado.setText("0");
        txtidpago.setText("0");
        txtidinicio_turno.setText("0");
    }

    private void inicioenceros() {
        txtvalor.setText("0");
        txtdescuento.setText("0");
        txtIVA_19.setText("0");
        txtvalorSinIVA.setText("0");
        txtsubtotal.setText("0");
        txtefectivo.setText("0");
        txttarjeta.setText("0");
        txttransferencia.setText("0");
        txttotal.setText("0");

    }

    private void ocultar() {
        lblturno.setVisible(false);
        txtidempleado.setVisible(false);
        txtidingreso.setVisible(false);
        txtidinicio_turno.setVisible(false);
        txtidpago.setVisible(false);

    }

    private void generarnumero() {
        Fsalidap func = new Fsalidap();
        int numero = func.generarComprobante();
        txtnumerofactura.setText(String.valueOf(numero));
    }

    private void vehiculosEnParqueo() {

        Fsalidap sumaParqueo = new Fsalidap();

        int[] resultados = sumaParqueo.contarEstadoActivo();
        int Autos = resultados[0];
        int Motos = resultados[1];
        txtAutos.setText(String.valueOf(Autos));
        txtMotos.setText(String.valueOf(Motos));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtfechaentrada = new javax.swing.JTextField();
        txtfechasalida = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtidingreso = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnguardar1 = new javax.swing.JButton();
        txtidpago = new javax.swing.JTextField();
        txtidinicio_turno = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtturnoentrada = new javax.swing.JTextField();
        txtempleadoentrada = new javax.swing.JTextField();
        txtempleadosalida = new javax.swing.JTextField();
        txtturnosalida = new javax.swing.JTextField();
        txtidempleado = new javax.swing.JTextField();
        lblturno = new javax.swing.JLabel();
        txtnumerofactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtzona = new javax.swing.JTextField();
        cbotiposervicio = new javax.swing.JComboBox<>();
        cbotipovehiculo = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAutos = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtMotos = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtvalorSinIVA = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtIVA_19 = new javax.swing.JTextField();
        txtdias = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txthoras = new javax.swing.JTextField();
        txtminutos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txttransferencia = new javax.swing.JTextField();
        txttarjeta = new javax.swing.JTextField();
        txtefectivo = new javax.swing.JTextField();
        txtdescuento9 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Cliente:");

        txtcliente.setEditable(false);
        txtcliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Tipo servicio:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Placa:");

        txtplaca.setBackground(new java.awt.Color(255, 255, 204));
        txtplaca.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtplaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplacaActionPerformed(evt);
            }
        });
        txtplaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtplacaKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Tipo Vehiculo:");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Fecha salida:");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Fecha entrada:");

        txtfechaentrada.setEditable(false);
        txtfechaentrada.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txtfechasalida.setEditable(false);
        txtfechasalida.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Numero:");

        txtidingreso.setText("0");

        btnguardar.setBackground(new java.awt.Color(204, 204, 204));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnguardar.setText("Salida");
        btnguardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnguardar1.setBackground(new java.awt.Color(204, 204, 204));
        btnguardar1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.GIF"))); // NOI18N
        btnguardar1.setText("Nuevo");
        btnguardar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnguardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnguardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar1ActionPerformed(evt);
            }
        });

        txtidpago.setText("0");

        txtidinicio_turno.setText("0");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Turno entrada:");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Turno salida:");

        txtturnoentrada.setEditable(false);

        txtempleadoentrada.setEditable(false);

        txtempleadosalida.setEditable(false);

        txtturnosalida.setEditable(false);

        txtidempleado.setText("0");

        lblturno.setText("turno");

        txtnumerofactura.setEditable(false);
        txtnumerofactura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtnumerofactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("N° Factura:");

        txtzona.setEditable(false);
        txtzona.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtzona.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtzona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtzonaActionPerformed(evt);
            }
        });

        cbotiposervicio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbotiposervicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "DIA", "DIA TRNSPORTE", "DIA MOTO", "CONVENIO CARGA", "HORA", "ADICIONALES", "CONVENIO HOSTAL" }));
        cbotiposervicio.setEnabled(false);
        cbotiposervicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbotiposervicioMouseClicked(evt);
            }
        });
        cbotiposervicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotiposervicioActionPerformed(evt);
            }
        });

        cbotipovehiculo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbotipovehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "MOTO", "AUTO", " " }));
        cbotipovehiculo.setEnabled(false);
        cbotipovehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipovehiculoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("Calle:");

        txtcalle.setEditable(false);
        txtcalle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtcalle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcalleActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/car (1).png"))); // NOI18N
        jLabel1.setText(":");

        txtAutos.setEditable(false);
        txtAutos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/harley-davidson.png"))); // NOI18N
        jLabel27.setText(":");

        txtMotos.setEditable(false);
        txtMotos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtzona, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnumerofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcalle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbotipovehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbotiposervicio, 0, 183, Short.MAX_VALUE)
                                    .addComponent(txtfechaentrada)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMotos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(lblturno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtturnoentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtturnosalida, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtempleadoentrada)
                                    .addComponent(txtempleadosalida, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtidinicio_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtplaca)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbotipovehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbotiposervicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtzona, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcalle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtnumerofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblturno)
                    .addComponent(txtidinicio_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtturnoentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtempleadoentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtturnosalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtempleadosalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27)
                        .addComponent(txtMotos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setText("Antes de IVA:");

        txtvalorSinIVA.setEditable(false);
        txtvalorSinIVA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("IVA(19%):");

        txtIVA_19.setEditable(false);
        txtIVA_19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtIVA_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIVA_19ActionPerformed(evt);
            }
        });
        txtIVA_19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIVA_19KeyPressed(evt);
            }
        });

        txtdias.setEditable(false);
        txtdias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiasActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Dias:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Horas:");

        txthoras.setEditable(false);
        txthoras.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txthoras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txthoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthorasActionPerformed(evt);
            }
        });

        txtminutos.setEditable(false);
        txtminutos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtminutos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtminutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminutosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Minutos:");

        txtvalor.setEditable(false);
        txtvalor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Valor:");

        txtsubtotal.setEditable(false);
        txtsubtotal.setBackground(new java.awt.Color(255, 255, 204));
        txtsubtotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Subtotal:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Efectivo:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Tarjeta:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Transferencia:");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Total:");

        txttotal.setEditable(false);
        txttotal.setBackground(new java.awt.Color(255, 255, 204));
        txttotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        txttransferencia.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txttransferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttransferenciaKeyPressed(evt);
            }
        });

        txttarjeta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txttarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttarjetaActionPerformed(evt);
            }
        });
        txttarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttarjetaKeyPressed(evt);
            }
        });

        txtefectivo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtefectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtefectivoActionPerformed(evt);
            }
        });
        txtefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtefectivoKeyPressed(evt);
            }
        });

        txtdescuento9.setEditable(false);
        txtdescuento9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("Impuesto 9%:");

        txtdescuento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtdescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescuentoActionPerformed(evt);
            }
        });
        txtdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyPressed(evt);
            }
        });

        jButton1.setText("copia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("Descuento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel9)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel10)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtdias, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txthoras, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtminutos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtvalorSinIVA)
                                .addComponent(txtIVA_19)
                                .addComponent(txtsubtotal)
                                .addComponent(txtefectivo)
                                .addComponent(txttarjeta)
                                .addComponent(txttransferencia)
                                .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addComponent(txtvalor, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtdescuento9))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtminutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtvalorSinIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIVA_19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescuento9)
                    .addComponent(jLabel20))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtdiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiasActionPerformed

    private void txtplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplacaActionPerformed

    private void txthorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthorasActionPerformed

    private void txtminutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtminutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtminutosActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        Dsalidap dts = new Dsalidap();
        Fsalidap func = new Fsalidap();

        dts.setIdingreso(Integer.parseInt(txtidingreso.getText()));
        dts.setPlaca(txtplaca.getText());
        int tipovehiculo = cbotipovehiculo.getSelectedIndex();
        dts.setTipovehiculo((String) cbotipovehiculo.getItemAt(tipovehiculo));
        int tiposervicio = cbotiposervicio.getSelectedIndex();
        dts.setTiposervicio((String) cbotiposervicio.getItemAt(tiposervicio));
        dts.setCliente(txtcliente.getText());
        dts.setFechaentrada(txtfechaentrada.getText());
        dts.setFechasalida(txtfechasalida.getText());
        dts.setZona(txtzona.getText());
        dts.setNumfactura(txtnumerofactura.getText());
        dts.setNumrecibo(txtAutos.getText());
        dts.setDias(Integer.parseInt(txtdias.getText()));
        dts.setHoras(Integer.parseInt(txthoras.getText()));
        dts.setMinutos(Integer.parseInt(txtminutos.getText()));
        dts.setValor(Integer.parseInt(txtvalor.getText().replace(",", "")));
        dts.setAntesiva(Integer.parseInt(txtvalorSinIVA.getText().replace(",", "")));
        dts.setIva19(Integer.parseInt(txtIVA_19.getText().replace(",", "")));
        dts.setImpuesto9(Integer.parseInt(txtdescuento9.getText().replace(",", "")));
        dts.setSubtotal(Integer.parseInt(txtsubtotal.getText().replace(",", "")));
        dts.setEfectivo(Integer.parseInt(txtefectivo.getText().replace(",", "")));
        dts.setTarjeta(Integer.parseInt(txttarjeta.getText().replace(",", "")));
        dts.setTransferencia(Integer.parseInt(txttransferencia.getText().replace(",", "")));
        dts.setTotal(Integer.parseInt(txttotal.getText().replace(",", "")));
        dts.setTurno(lblturno.getText());
        dts.setTurnoentrada(txtturnoentrada.getText());
        dts.setEmpleadoentrada(txtempleadoentrada.getText());
        dts.setTurnosalida(txtturnosalida.getText());
        dts.setEmpleadosalida(txtempleadosalida.getText());
        dts.setDescuento(Integer.parseInt(txtdescuento.getText().replace(",", "")));
        dts.setTotalautos(txtAutos.getText());
        dts.setTotalmotos(txtMotos.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "Salida de vehiculo satisfactori");

                Fzonap fundesocupar = new Fzonap();
                Dzona dtszona = new Dzona();
                dtszona.setNumero(txtzona.getText());
                fundesocupar.Desocupar(dtszona);

                Lingresop cambioestado = new Lingresop();
                Dingresop dtsestado = new Dingresop();
                dtsestado.setIdingreso(Integer.parseInt(txtidingreso.getText()));
                cambioestado.CambioEstado(dtsestado);

                int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Deseas imprimir?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    ImprimirSalidap imprimir = new ImprimirSalidap();
                    try {
                        imprimir.ImprimirFacturaPago();
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Error: Archivo no encontrado.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Jsalidap.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Jsalidap.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar1ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnguardar1ActionPerformed

    private void txtIVA_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIVA_19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIVA_19ActionPerformed

    private void txtIVA_19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIVA_19KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIVA_19KeyPressed

    private void txtdescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescuentoActionPerformed

    private void txtdescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
                int valor = Integer.parseInt(txtvalor.getText().replace(",", ""));
                int Descuento = Integer.parseInt(txtdescuento.getText().replace(",", ""));

                int resta = (valor - Descuento);
                txtdescuento.setText(formatoMiles.format(resta));
            } catch (NumberFormatException e) {
            }

        }


    }//GEN-LAST:event_txtdescuentoKeyPressed

    private void txtplacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtplacaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            inicioenceros();
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            Cconexionp conexion = new Cconexionp();

            try ( Connection conectar = conexion.establecerConexionp()) {
                pst = conectar.prepareStatement("select * from ingreso where placa=? and estado = 'Activo'");
                pst.setString(1, txtplaca.getText().trim());
                rs = pst.executeQuery();

                if (rs.next()) {
                    // Datos obtenidos de la consulta
                    txtidingreso.setText(String.valueOf(rs.getInt("idingreso")));
                    txtfechaentrada.setText(rs.getString("fechaingreso"));
                    txtcliente.setText(rs.getString("cliente"));
                    txtzona.setText(rs.getString("zona"));
                    cbotipovehiculo.setSelectedItem(rs.getString("tipovehiculo"));
                    cbotiposervicio.setSelectedItem(rs.getString("tiposervicio"));
                    txtcalle.setText(rs.getString("calle"));

                    // Parsear las fechas de ingreso y salida
                    String fechaHoraIngreso = rs.getString("fechaingreso").trim();
                    String fechaHoraSalida = txtfechasalida.getText();
                    LocalDateTime fechaIngreso = LocalDateTime.parse(fechaHoraIngreso, DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a", Locale.ENGLISH));
                    LocalDateTime fechaSalida = LocalDateTime.parse(fechaHoraSalida, DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a", Locale.ENGLISH));

                    // Verificar si las fechas son diferentes
                    boolean cambioDeFecha = !fechaIngreso.toLocalDate().equals(fechaSalida.toLocalDate());

                    Duration duracion = Duration.between(fechaIngreso, fechaSalida);
                    long totalMinutos = duracion.toMinutes();

                    // Variables para días, horas y minutos
                    long dias = 0;
                    long horas = 0;
                    long minutos = 0;

                    if (totalMinutos <= 15) {
                        // Dentro del tiempo de gracia inicial de 15 minutos, no se cobra nada
                        txtdias.setText("0");
                        txthoras.setText("0");
                        txtminutos.setText("0");
                        txtvalor.setText("0");
                        JOptionPane.showMessageDialog(null, "Dentro del tiempo de gracia. No hay cobro.");
                        return;
                    }

                    if (totalMinutos > (4 * 60 + 15)) {
                        // Cobrar el día completo si supera las 4 horas y 15 minutos
                        dias = 1;

                        // Restar los 4 horas y 15 minutos del cálculo
                        long minutosRestantes = totalMinutos - (4 * 60 + 15);

                        // Calcular días adicionales si excede un día completo después de los primeros 4h15m
                        if (minutosRestantes >= (24 * 60)) {
                            dias += minutosRestantes / (24 * 60);
                            minutosRestantes %= (24 * 60);
                        }

                        // Calcular horas y minutos adicionales después de los días completos
                        horas = minutosRestantes / 60;
                        minutos = minutosRestantes % 60;
                    } else {
                        // Si no supera las 4h15m, calcular horas y minutos directamente
                        horas = totalMinutos / 60;
                        minutos = totalMinutos % 60;
                    }

                    // Mostrar los valores calculados
                    txtdias.setText(String.valueOf(dias));
                    txthoras.setText(String.valueOf(horas));
                    txtminutos.setText(String.valueOf(minutos));

                    // Calcular el precio según el tipo de servicio
                    String placa = rs.getString("placa").trim();
                    String tiposervicio = rs.getString("tiposervicio").trim();
                    Fsalidap precio = new Fsalidap();

                    switch (tiposervicio) {
                        case "DIA" -> {
                            int nuevoprecio = precio.tiposervicio(placa, tiposervicio);
                            int calculodias = (int) (dias * nuevoprecio);
                            int calculohoras = (int) ((nuevoprecio * 0.24) * horas); // Cálculo proporcional para horas
                            int suma = calculodias + calculohoras;
                            txtvalor.setText(formatoMiles.format(suma));
                        }
                        case "DIA TRANSPORTE" -> {
                            int nuevoprecio = precio.tiposervicio(placa, tiposervicio);
                            int calculodias = (int) (dias * nuevoprecio);
                            int calculohoras = (int) ((nuevoprecio * 0.24) * horas);
                            int suma = calculodias + calculohoras;
                            txtvalor.setText(formatoMiles.format(suma));
                        }
                        case "DIA MOTO" -> {
                            int nuevoprecio = precio.tiposervicio(placa, tiposervicio);
                            int calculodias = (int) (dias * nuevoprecio);
                            int calculohoras = (int) ((nuevoprecio * 0.36) * horas);
                            int suma = calculodias + calculohoras;
                            txtvalor.setText(formatoMiles.format(suma));
                        }
                        case "CONVENIO CARGA" -> {
                            int nuevoprecio = precio.tiposervicio(placa, tiposervicio);
                            int calculodias = (int) (dias * nuevoprecio);
                            int calculohoras = (int) ((nuevoprecio * 0.4) * horas);
                            int suma = calculodias + calculohoras;
                            txtvalor.setText(formatoMiles.format(suma));
                        }
                        case "HORA" -> {
                            int nuevoprecio = precio.tiposervicio(placa, tiposervicio);
                            int calculodias = (int) (dias * nuevoprecio);
                            int calculohoras = (int) (nuevoprecio * horas); // Cobro por horas directas
                            int suma = calculodias + calculohoras;
                            txtvalor.setText(formatoMiles.format(suma));
                        }
                        case "ADICIONALES" -> {
                            int nuevoprecio = precio.tiposervicio(placa, tiposervicio);
                            int calculodias = (int) (dias * nuevoprecio);
                            int calculohoras = (int) ((nuevoprecio * 0.4) * horas);
                            int suma = calculodias + calculohoras;
                            txtvalor.setText(formatoMiles.format(suma));
                        }
                        case "CONVENIO HOSTAL" -> {
                            int nuevoprecio = precio.tiposervicio(placa, tiposervicio);
                            int calculodias = (int) (dias * nuevoprecio);
                            int calculohoras = (int) ((nuevoprecio * 0.4) * horas);
                            int suma = calculodias + calculohoras;
                            txtvalor.setText(formatoMiles.format(suma));
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, "Tipo de servicio no reconocido.");
                        }
                    }

// Mostrar datos finales
                    int Valorparqueo = Integer.parseInt(txtvalor.getText().replace(",", ""));
                    int valorsinIVA = (int) (Valorparqueo / 1.19);
                    txtvalorSinIVA.setText(formatoMiles.format(valorsinIVA));
                    int valorConIVA = (int) (valorsinIVA * 0.19);
                    txtIVA_19.setText(formatoMiles.format(valorConIVA));
                    int desc9 = (int) (valorsinIVA * 0.09);
                    txtdescuento9.setText(formatoMiles.format(desc9));

                    int valosiIVA = Integer.parseInt(txtvalorSinIVA.getText().replace(",", ""));
                    int Iva19 = Integer.parseInt(txtIVA_19.getText().replace(",", ""));

                    int subtotal = valosiIVA + Iva19 + 1;
                    int subtotalRedondeado = (int) (Math.ceil(subtotal / 100.0) * 100);
                    txtsubtotal.setText(formatoMiles.format(subtotalRedondeado));

                    // Mostrar datos del turno
                    Dinicioturnop datoempleado = new Fsalidap().empleado(placa);
                    if (datoempleado != null) {
                        txtturnoentrada.setText(String.valueOf(datoempleado.getNumeroTurno()));
                        txtempleadoentrada.setText(datoempleado.getEmpleado());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el NUMERO solicitado.");
                }
            } catch (SQLException | NumberFormatException e) {
            }
        }


    }//GEN-LAST:event_txtplacaKeyPressed

    private void cbotiposervicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotiposervicioActionPerformed
        // TODO add your handling code here:
        cbotiposervicio.addItemListener((ItemEvent evt1) -> {
            if (evt1.getStateChange() == ItemEvent.SELECTED) {
                String tiposervicioSeleccionado = (String) evt1.getItem();

                // Recalcular el precio basado en el nuevo tipo de servicio
                Fsalidap precio = new Fsalidap();
                int nuevoprecio = precio.recalculartiposervicio(tiposervicioSeleccionado);

                switch (tiposervicioSeleccionado) {
                    case "DIA TRANSPORTE" -> {
                        int dias = Integer.parseInt(txtdias.getText());
                        int horas = Integer.parseInt(txthoras.getText());
                        int calculodias = (int) (dias * nuevoprecio);
                        int calculohoras = (int) ((nuevoprecio * 0.24) * horas);
                        int suma = calculodias + calculohoras;
                        txtvalor.setText(NumberFormat.getNumberInstance(Locale.US).format(suma));
                    }
                    case "DIA MOTO" -> {
                        int dias = Integer.parseInt(txtdias.getText());
                        int horas = Integer.parseInt(txthoras.getText());
                        int calculodias = (int) (dias * nuevoprecio);
                        int calculohoras = (int) ((nuevoprecio * 0.36) * horas);
                        int suma = calculodias + calculohoras;
                        txtvalor.setText(NumberFormat.getNumberInstance(Locale.US).format(suma));
                    }
                    case "CONVENIO CARGA" -> {
                        int dias = Integer.parseInt(txtdias.getText());
                        int horas = Integer.parseInt(txthoras.getText());
                        int calculodias = (int) (dias * nuevoprecio);
                        int calculohoras = (int) ((nuevoprecio * 0.4) * horas);
                        int suma = calculodias + calculohoras;
                        txtvalor.setText(NumberFormat.getNumberInstance(Locale.US).format(suma));
                    }
                    case "HORA" -> {
                        int dias = Integer.parseInt(txtdias.getText());
                        int horas = Integer.parseInt(txthoras.getText());
                        int calculodias = (int) (dias * nuevoprecio);
                        int calculohoras = (int) (nuevoprecio * horas);
                        int suma = calculodias + calculohoras;
                        txtvalor.setText(NumberFormat.getNumberInstance(Locale.US).format(suma));
                    }
                    case "ADICIONALES" -> {
                        int dias = Integer.parseInt(txtdias.getText());
                        int horas = Integer.parseInt(txthoras.getText());
                        int calculodias = (int) (dias * nuevoprecio);
                        int calculohoras = (int) ((nuevoprecio * 0.4) * horas);
                        int suma = calculodias + calculohoras;
                        txtvalor.setText(NumberFormat.getNumberInstance(Locale.US).format(suma));
                    }
                    case "CONVENIO HOSTAL" -> {
                        int dias = Integer.parseInt(txtdias.getText());
                        int horas = Integer.parseInt(txthoras.getText());
                        int calculodias = (int) (dias * nuevoprecio);
                        int calculohoras = (int) ((nuevoprecio * 0.4) * horas);
                        int suma = calculodias + calculohoras;
                        txtvalor.setText(NumberFormat.getNumberInstance(Locale.US).format(suma));
                    }

                    default -> {
                    }

                }
                try {
                    NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
                    int Valorparqueo = Integer.parseInt(txtvalor.getText().replace(",", ""));
                    int valorsinIVA = (int) (Valorparqueo / 1.19);
                    txtvalorSinIVA.setText(formatoMiles.format(valorsinIVA));

                    int valorConIVA = (int) (valorsinIVA * 0.19);
                    txtIVA_19.setText(formatoMiles.format(valorConIVA));

                    // Obtener los valores de los campos de texto y convertirlos a enteros
                    int valosiIVA = Integer.parseInt(txtvalorSinIVA.getText().replace(",", ""));
                    int Iva19 = Integer.parseInt(txtIVA_19.getText().replace(",", ""));
                    int reten35 = Integer.parseInt(txtdescuento.getText().replace(",", ""));

                    int subtotal = valosiIVA + Iva19 - reten35 + 1;
                    //              int subtotalRedondeado = Math.round((float) subtotal);
                    int subtotalRedondeado = (int) (Math.ceil(subtotal / 100.0) * 100);
                    txtsubtotal.setText(formatoMiles.format(subtotalRedondeado));

                } catch (NumberFormatException e) {

                }

            }
        });

    }//GEN-LAST:event_cbotiposervicioActionPerformed

    private void cbotipovehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipovehiculoActionPerformed
        // TODO add your handling code here:
        cbotipovehiculo.transferFocus();
    }//GEN-LAST:event_cbotipovehiculoActionPerformed

    private void cbotiposervicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbotiposervicioMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cbotiposervicioMouseClicked

    private void txtzonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtzonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtzonaActionPerformed

    private void txtefectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtefectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtefectivoActionPerformed

    private void txtefectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotal.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txtefectivoKeyPressed

    private void txttarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttarjetaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txttarjetaActionPerformed

    private void txttarjetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttarjetaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotal.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttarjetaKeyPressed

    private void txttransferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttransferenciaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            NumberFormat formatoMiles = NumberFormat.getNumberInstance(Locale.US);
            try {
                // Obtener los valores de los campos de texto y convertirlos a enteros
                int efectivo = Integer.parseInt(txtefectivo.getText().replace(",", ""));
                int tarjeta = Integer.parseInt(txttarjeta.getText().replace(",", ""));
                int transferencia = Integer.parseInt(txttransferencia.getText().replace(",", ""));

                int totalPago = efectivo + tarjeta + transferencia;
                txttotal.setText(formatoMiles.format(totalPago));

            } catch (NumberFormatException e) {
                // Manejar la excepción si alguno de los campos de texto no contiene un número válido
                JOptionPane.showMessageDialog(null, "Error: uno o más campos no contienen un número válido");
            }

        }
    }//GEN-LAST:event_txttransferenciaKeyPressed

    private void txtcalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Deseas imprimir?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            ImprimirSalidap imprimir = new ImprimirSalidap();
            try {
                imprimir.ImprimirFacturaPago();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error: Archivo no encontrado.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(Jsalidap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Jsalidap.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            java.util.logging.Logger.getLogger(Jsalidap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jsalidap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jsalidap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jsalidap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jsalidap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardar1;
    private javax.swing.JComboBox<String> cbotiposervicio;
    private javax.swing.JComboBox<String> cbotipovehiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblturno;
    private javax.swing.JTextField txtAutos;
    private javax.swing.JTextField txtIVA_19;
    private javax.swing.JTextField txtMotos;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtdescuento9;
    private javax.swing.JTextField txtdias;
    private javax.swing.JTextField txtefectivo;
    private javax.swing.JTextField txtempleadoentrada;
    public static javax.swing.JTextField txtempleadosalida;
    private javax.swing.JTextField txtfechaentrada;
    private javax.swing.JTextField txtfechasalida;
    private javax.swing.JTextField txthoras;
    private javax.swing.JTextField txtidempleado;
    private javax.swing.JTextField txtidingreso;
    private javax.swing.JTextField txtidinicio_turno;
    private javax.swing.JTextField txtidpago;
    private javax.swing.JTextField txtminutos;
    private javax.swing.JTextField txtnumerofactura;
    private javax.swing.JTextField txtplaca;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttarjeta;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttransferencia;
    private javax.swing.JTextField txtturnoentrada;
    public static javax.swing.JTextField txtturnosalida;
    private javax.swing.JTextField txtvalor;
    private javax.swing.JTextField txtvalorSinIVA;
    private javax.swing.JTextField txtzona;
    // End of variables declaration//GEN-END:variables
}
