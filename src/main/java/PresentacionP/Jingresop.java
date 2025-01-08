package PresentacionP;

import LogicaP.Tiempopro;
import DatosP.Dingresop;
import DatosP.Dzona;
import Impresion.ImprimirIngresop;
import LogicaP.Cconexionp;
import LogicaP.Fbloqueos;
import LogicaP.Fzonap;
import LogicaP.Lingresop;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Jingresop extends javax.swing.JFrame {

    Tiempopro time = new Tiempopro();
    PreparedStatement pst;
    ResultSet rs;

    public Jingresop() {
        initComponents();
        mostrar("");
        configurarTabla();
        setLocationRelativeTo(null);
        setTitle("INGRESO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inhabilitar();
        mostrarTiempo();
    }
    private String accion = "guardar";

    private void mostrarTiempo() {

        txtfechaingreso.setText(time.getFechacomp() + " " + time.getHoracomp());
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

        // Establecer colores alternos en las filas
        tablalistado.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Color de las filas alternas
                if (!isSelected) {
                    if (row % 2 == 0) {
                        cell.setBackground(Color.LIGHT_GRAY); // Filas pares
                        cell.setForeground(Color.WHITE);
                    } else {
                        cell.setBackground(Color.WHITE); // Filas impares
                        cell.setForeground(Color.BLACK);
                    }
                } else {
                    cell.setBackground(new Color(255, 255, 153)); // Color para fila seleccionada
                    cell.setForeground(Color.BLACK);
                }

                return cell;
            }
        });
    }

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(9).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(9).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(9).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(13).setPreferredWidth(0);
    }

    private void inhabilitar() {
        mostrarTiempo();
        lblturnos.setVisible(false);
        txtidingreso.setVisible(false);
        txtidinicio_turno.setVisible(false);
        txtplaca.setText("");
        cbotipovehiculo.setSelectedItem("SELECCIONAR");
        cbotiposervicio.setSelectedItem("SELECCIONAR");
        txtcliente.setText("o");
        txtzona.setText("");
        txtobservaciones.setText("Ninguna");
        cboestado.setSelectedItem("Activo");
        txtnumero.setText("");
        txtzona.setText("");
        txtcalle.setText("");

    }

    private void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            Lingresop func = new Lingresop();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lblregistro.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtobservaciones = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        txtfechaingreso = new javax.swing.JTextField();
        cbotipovehiculo = new javax.swing.JComboBox<>();
        cbotiposervicio = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnumeroturno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtempleado = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnguardar1 = new javax.swing.JButton();
        lblturnos = new javax.swing.JLabel();
        txtidinicio_turno = new javax.swing.JTextField();
        cboestado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtidingreso = new javax.swing.JTextField();
        txtzona = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lblregistro = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Tipo Vehiculo:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Tipo Servicio:");

        txtobservaciones.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtobservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtobservacionesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Placa:");

        txtplaca.setBackground(new java.awt.Color(255, 255, 204));
        txtplaca.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplacaActionPerformed(evt);
            }
        });

        txtcliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        txtfechaingreso.setEditable(false);
        txtfechaingreso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtfechaingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaingresoActionPerformed(evt);
            }
        });

        cbotipovehiculo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbotipovehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "MOTO", "AUTO", " " }));
        cbotipovehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipovehiculoActionPerformed(evt);
            }
        });

        cbotiposervicio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbotiposervicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "DIA", "DIA TRNSPORTE", "DIA MOTO", "CONVENIO CARGA", "HORA", "ADICIONALES", "CONVENIO HOSTAL" }));
        cbotiposervicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotiposervicioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Buscar * N°:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Fecha ingreso:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Turno:");

        txtnumeroturno.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Responsable:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Observaciones:");

        txtempleado.setEditable(false);
        txtempleado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtempleadoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(204, 204, 204));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnguardar.setText("Ingresar");
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

        lblturnos.setText("TURNO");

        txtidinicio_turno.setText("IDIT");

        cboestado.setEditable(true);
        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Finalizado" }));
        cboestado.setEnabled(false);
        cboestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboestadoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Estado:");

        txtidingreso.setText("IDIN");

        txtzona.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtzona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtzonaKeyPressed(evt);
            }
        });

        txtnumero.setEditable(false);
        txtnumero.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Numero:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Calle:");

        txtcalle.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumeroturno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(txtobservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3)))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblturnos)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtidinicio_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtzona, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbotiposervicio, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                    .addComponent(cbotipovehiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboestado, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                .addComponent(txtcalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbotipovehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbotiposervicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtzona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtcalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtobservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidinicio_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnumeroturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblturnos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btnguardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablalistado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        lblregistro.setText("Total:");

        btnbuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnbuscar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        txtbuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar  * placa:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbuscar)
                        .addGap(4, 4, 4)
                        .addComponent(btneliminar)
                        .addGap(47, 47, 47)
                        .addComponent(lblregistro)
                        .addGap(140, 140, 140))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblregistro)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfechaingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaingresoActionPerformed
        // TODO add your handling code here:
        txtfechaingreso.transferFocus();
    }//GEN-LAST:event_txtfechaingresoActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
        txtcliente.transferFocus();
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtobservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtobservacionesActionPerformed
        // TODO add your handling code here:
        txtobservaciones.transferFocus();
    }//GEN-LAST:event_txtobservacionesActionPerformed

    private void txtplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplacaActionPerformed
        txtplaca.transferFocus();
    }//GEN-LAST:event_txtplacaActionPerformed

    private void txtempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtempleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtempleadoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txtplaca.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "DEBES INGRESAR UNA PLACA");
            txtplaca.requestFocus();
            return;
        }
        if (txtfechaingreso.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "VERIFICA QUE ESTE LA FECHA POR FAVOR");
            txtfechaingreso.requestFocus();
            return;
        }

        if (cbotipovehiculo.getSelectedIndex() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "DEBES SELECCIONAR UN TIPO DE VEHICULO");
            cbotipovehiculo.requestFocus();
            return;
        }

        if (cbotiposervicio.getSelectedIndex() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "DEBES SELCCIONAR UN TIPO DE SERVICIO");
            cbotiposervicio.requestFocus();
            return;
        }
        if (txtzona.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "VERIFICA QUE ESTES ASIGNANDO UN LUGAR EN EL PARQUEADERO");
            txtzona.requestFocus();
            return;
        }

        Dingresop dts = new Dingresop();
        Lingresop func = new Lingresop();

        dts.setCalle(txtcalle.getText().trim());
//        dts.setIdinicioturno(Integer.parseInt(txtidinicio_turno.getText()));
        dts.setTurno(lblturnos.getText());
        dts.setNumeroturno(txtnumeroturno.getText().trim());
        dts.setEmpleado(txtempleado.getText().trim());
        dts.setPlaca(txtplaca.getText().trim());
        dts.setFechaingreso(txtfechaingreso.getText().trim());
        int tipovehiculo = cbotipovehiculo.getSelectedIndex();
        dts.setTipovehiculo((String) cbotipovehiculo.getItemAt(tipovehiculo));
        int tiposervicio = cbotiposervicio.getSelectedIndex();
        dts.setTiposervicio((String) cbotiposervicio.getItemAt(tiposervicio));
        dts.setCliente(txtcliente.getText());
        dts.setZona(txtzona.getText().trim());
        dts.setNumero(txtnumero.getText().trim());
        dts.setObservaciones(txtobservaciones.getText());
        int estado = cboestado.getSelectedIndex();
        dts.setEstado((String) cboestado.getItemAt(estado));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, " INGRESO SATISFACTORIAMENTE");
                mostrar("");
                Fzonap func3 = new Fzonap();
                Dzona dts3 = new Dzona();
                dts3.setNumero(txtnumero.getText());
                func3.ocupar(dts3);
                inhabilitar();
                
                ImprimirIngresop ingreso =  new ImprimirIngresop();
                try {
                    ingreso.ImprimirFactuIngreso();
                } catch (IOException ex) {
                    Logger.getLogger(Jingresop.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Jingresop.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
            }

        } else if (accion.equals("editar")) {
            dts.setIdingreso(Integer.parseInt(txtidingreso.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "EDITADO SATISFACTORIAMENTE");
                mostrar("");
                inhabilitar();

            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar1ActionPerformed
        // TODO add your handling code here:
//        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        inhabilitar();
    }//GEN-LAST:event_btnguardar1ActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked

        btnguardar.setText("Editar");
//        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());
        txtidingreso.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidinicio_turno.setText(tablalistado.getValueAt(fila, 1).toString());
        lblturnos.setText(tablalistado.getValueAt(fila, 2).toString());
        txtnumeroturno.setText(tablalistado.getValueAt(fila, 3).toString());
        txtempleado.setText(tablalistado.getValueAt(fila, 4).toString());
        txtplaca.setText(tablalistado.getValueAt(fila, 5).toString());
        txtfechaingreso.setText(tablalistado.getValueAt(fila, 6).toString());
        cbotipovehiculo.setSelectedItem(tablalistado.getValueAt(fila, 7).toString());
        cbotiposervicio.setSelectedItem(tablalistado.getValueAt(fila, 8).toString());
        txtcliente.setText(tablalistado.getValueAt(fila, 9).toString());
        txtzona.setText(tablalistado.getValueAt(fila, 10).toString());
        txtnumero.setText(tablalistado.getValueAt(fila, 11).toString());
        txtcalle.setText(tablalistado.getValueAt(fila, 12).toString());
        txtobservaciones.setText(tablalistado.getValueAt(fila, 13).toString());
        cboestado.setSelectedItem(tablalistado.getValueAt(fila, 14).toString());


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        if (!txtidingreso.getText().equals("")) {
            String confirmacion = JOptionPane.showInputDialog(
                    null,
                    "Por favor, ingrese el código a eliminar:",
                    "Eliminar Código",
                    JOptionPane.QUESTION_MESSAGE
            );
            System.out.println("codigo" + confirmacion);

            if (confirmacion != null && !confirmacion.trim().isEmpty()) {

                Fbloqueos codigo = new Fbloqueos();
                boolean Eliminado = codigo.verificarBloqueo(confirmacion);

                if (Eliminado) {
                    Dingresop dts = new Dingresop();
                    Lingresop func = new Lingresop();

                    dts.setIdingreso(Integer.parseInt(txtidingreso.getText()));
                    func.eliminar(dts);
                    mostrar("");
                    JOptionPane.showMessageDialog(null, " Eliminado correctamente.");
                    inhabilitar();

                } else {
                    JOptionPane.showMessageDialog(null, "El CODIGO NO EXISTE.");
                }

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void cbotipovehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipovehiculoActionPerformed
        // TODO add your handling code here:
        cbotipovehiculo.transferFocus();
    }//GEN-LAST:event_cbotipovehiculoActionPerformed

    private void cbotiposervicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotiposervicioActionPerformed
        // TODO add your handling code here:
        cbotiposervicio.transferFocus();
    }//GEN-LAST:event_cbotiposervicioActionPerformed

    private void cboestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboestadoActionPerformed
        // TODO add your handling code here:
        cboestado.transferFocus();
    }//GEN-LAST:event_cboestadoActionPerformed

    private void txtzonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtzonaKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Cconexionp conexion = new Cconexionp();

            try {
                // Preparamos la consulta
                try ( Connection conectar = conexion.establecerConexionp()) {
                    // Preparamos la consulta
                    pst = conectar.prepareStatement("select * from zona where numero=?");
                    pst.setString(1, txtzona.getText());

                    rs = pst.executeQuery();

                    if (rs.next()) {
                        String estado = rs.getString("estado");
                        if ("Ocupado".equalsIgnoreCase(estado)) {
                            JOptionPane.showMessageDialog(null, "El Lugar se encuentra Ocupado.");
                        }
                        if ("Mantenimeinto".equalsIgnoreCase(estado)) {
                            JOptionPane.showMessageDialog(null, "El Lugar se encuentra en Manenimiento.");
                        }

                        if ("Disponible".equals(estado)) {
                            txtnumero.setText(rs.getString("numero"));
                            txtcalle.setText(rs.getString("calle"));

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el NUMERO solicitado.");
                    }
                }

            } catch (HeadlessException | SQLException ex) {

            }
        }
    }//GEN-LAST:event_txtzonaKeyPressed

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
            java.util.logging.Logger.getLogger(Jingresop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jingresop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jingresop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jingresop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jingresop().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardar1;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JComboBox<String> cbotiposervicio;
    private javax.swing.JComboBox<String> cbotipovehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblregistro;
    public static javax.swing.JLabel lblturnos;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtempleado;
    private javax.swing.JTextField txtfechaingreso;
    private javax.swing.JTextField txtidingreso;
    public static javax.swing.JTextField txtidinicio_turno;
    private javax.swing.JTextField txtnumero;
    public static javax.swing.JTextField txtnumeroturno;
    private javax.swing.JTextField txtobservaciones;
    private javax.swing.JTextField txtplaca;
    private javax.swing.JTextField txtzona;
    // End of variables declaration//GEN-END:variables
}
