package LogicaP;

import DatosP.Dingresop;
import DatosP.Dinicioturnop;
import DatosP.Dsalidap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Fsalidap {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;
    Statement st;
    ResultSet rs;

    public boolean insertar(Dsalidap dts) {
        sSQL = "insert into salida (idingreso,placa,tipovehiculo,"
                + "tiposervicio, cliente, fechaentrada,fechasalida,zona,numfactura,numrecibo,dias,horas,minutos,"
                + "valor, antesiva,iva19,impuesto9,subtotal,efectivo,tarjeta,transferencia,total,turno,"
                + "turnoentrada,empleadoentrada,turnosalida,empleadosalida, descuento, totalautos, totalmotos)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdingreso());
            pst.setString(2, dts.getPlaca());
            pst.setString(3, dts.getTipovehiculo());
            pst.setString(4, dts.getTiposervicio());
            pst.setString(5, dts.getCliente());
            pst.setString(6, dts.getFechaentrada());
            pst.setString(7, dts.getFechasalida());
            pst.setString(8, dts.getZona());
            pst.setString(9, dts.getNumfactura());
            pst.setString(10, dts.getNumrecibo());
            pst.setInt(11, dts.getDias());
            pst.setInt(12, dts.getHoras());
            pst.setInt(13, dts.getMinutos());
            pst.setInt(14, dts.getValor());
            pst.setInt(15, dts.getAntesiva());
            pst.setInt(16, dts.getIva19());
            pst.setInt(17, dts.getImpuesto9());
            pst.setInt(18, dts.getSubtotal());
            pst.setInt(19, dts.getEfectivo());
            pst.setInt(20, dts.getTarjeta());
            pst.setInt(21, dts.getTransferencia());
            pst.setInt(22, dts.getTotal());
            pst.setString(23, dts.getTurno());
            pst.setString(24, dts.getTurnoentrada());
            pst.setString(25, dts.getEmpleadoentrada());
            pst.setString(26, dts.getTurnosalida());
            pst.setString(27, dts.getEmpleadosalida());
            pst.setInt(28, dts.getDescuento());
            pst.setString(29, dts.getTotalautos());
            pst.setString(30, dts.getTotalmotos());

            int n = pst.executeUpdate();

//            JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public Dinicioturnop numeroturnop() {
        int numeroturno = 0;
        int idturno = 0;
        sSQL = "SELECT numero_turno, idturno FROM inicio_turno WHERE estado = 'Activo' ORDER BY numero_turno DESC LIMIT 1";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                numeroturno = rs.getInt("numero_turno");
                idturno = rs.getInt("idturno");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el numero del turno: " + e.getMessage());
        }

        return new Dinicioturnop(numeroturno, idturno);
    }

    public Dinicioturnop empleado(String placa) {
        Dinicioturnop datoempleado = null;
        sSQL = "SELECT numeroturno, empleado FROM ingreso WHERE placa = ? AND estado = 'Activo'";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setString(1, placa); // Asigna el valor de la placa al parámetro de la consulta

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) { // Verifica si hay resultados
                    // Procesa el resultado si es necesario, por ejemplo:
                    int numeroTurno = rs.getInt("numeroturno");
                    String empleado = rs.getString("empleado");
//                    System.out.println("Turno: " + numeroTurno + ", Empleado: " + empleado);

                    datoempleado = new Dinicioturnop(numeroTurno, empleado);

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el empleado: " + e.getMessage());
        }

        return datoempleado; // Retorna false si no se encuentra un registro
    }

    public int generarComprobante() {
        String serie = "";
        sSQL = "SELECT MAX(CAST(numfactura AS UNSIGNED)) FROM salida WHERE numfactura REGEXP '^[0-9]+$';";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                serie = rs.getString(1);
                if (serie != null) {
                    // Incrementar el valor de serie
                    return Integer.parseInt(serie) + 1;
                } else {
                    // Si no hay registros, el primer número de turno es 1
                    return 1;
                }
            } else {
                // Si la consulta no devuelve resultados, también retornamos 1
                return 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el número: " + e.getMessage());
            return 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir el número: " + e.getMessage());
            return 0;
        }
    }

    public int[] contarEstadoActivo() {
        int[] conteos = new int[2]; // Índice 0 para Autos, índice 1 para Motos
        String sqlAuto = "SELECT COUNT(tipovehiculo) AS estado FROM ingreso WHERE estado = 'Activo' AND tipovehiculo = 'AUTO'";
        String sqlMoto = "SELECT COUNT(tipovehiculo) AS estado FROM ingreso WHERE estado = 'Activo' AND tipovehiculo = 'MOTO'";

        try {
            // Consulta para Autos
            PreparedStatement pstAuto = cn.prepareStatement(sqlAuto);
            ResultSet rsAuto = pstAuto.executeQuery();
            if (rsAuto.next()) {
                conteos[0] = rsAuto.getInt("estado");
            }

            // Consulta para Motos
            PreparedStatement pstMoto = cn.prepareStatement(sqlMoto);
            ResultSet rsMoto = pstMoto.executeQuery();
            if (rsMoto.next()) {
                conteos[1] = rsMoto.getInt("estado");
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        return conteos; // Retornar los resultados
    }

    //consulta para traer el tipo de servicio de ingreso y hacer el calculo
    public int tiposervicio(String Placa, String tiposervicio) {
        int precio = 0;
        sSQL = "SELECT t.precio "
                + "FROM tarifas t "
                + "JOIN ingreso i ON i.tiposervicio = t.tipo_servicio "
                + "WHERE i.tiposervicio = ? AND i.placa = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            // Asigna el valor de la placa al parámetro de la consulta
            pst.setString(1, tiposervicio);
            pst.setString(2, Placa);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) { // Verifica si hay resultados
                    // Procesa el resultado si es necesario, por ejemplo:
                    precio = rs.getInt("precio");

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el precio: " + e.getMessage());
        }

        return precio; // Retorna false si no se encuentra un registro
    }

    //consulta para recalcular el tipo de servicio
    public int recalculartiposervicio(String tiposervicio) {
        int precio = 0;
        sSQL = "select precio from tarifas where tipo_servicio = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            // Asigna el valor de la placa al parámetro de la consulta
            pst.setString(1, tiposervicio);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) { // Verifica si hay resultados
                    // Procesa el resultado si es necesario, por ejemplo:
                    precio = rs.getInt("precio");

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el precio: " + e.getMessage());
        }

        return precio; // Retorna false si no se encuentra un registro
    }

    public void llenarcboturno(JComboBox<String> combo) {

        DefaultComboBoxModel<String> com = new DefaultComboBoxModel<>();  // Modelo para el JComboBox
        combo.setModel(com);  // Asignamos el modelo al combo
        Cconexionp conexion = new Cconexionp();  // Conexión a la base de datos

        com.addElement("PLACA");  // Primer elemento del ComboBox

        try {
            // Establecer la conexión y ejecutar la consulta SQL
            Connection conectar = conexion.establecerConexionp();
            st = conectar.createStatement();
            rs = st.executeQuery("select placa from ingreso where estado = 'Activo' order by calle");

            // Recorrer los resultados de la consulta
            while (rs.next()) {
                // Obtener placa desde el ResultSet
                String placa = rs.getString("placa");

                // Agregar la placa modelo del ComboBox
                com.addElement(placa);

                
                Lingresop func = new Lingresop();
                Dingresop placas = new Dingresop();
                placas.setPlaca(placa);
                func.agregarplaca(placas);  
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
