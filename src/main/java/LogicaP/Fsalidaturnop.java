package LogicaP;

import DatosP.Dsalidaturnop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Alexander nieves romero
 */
public class Fsalidaturnop {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;

    public boolean insertar(Dsalidaturnop dts) {
        sSQL = "insert into salida_turno ( idfinturno, idinicioturno, turno, numero_turno, empleado, fechaingreso, fechasalida, recibos, totalautos,"
                + "totalmotos, base, efectivo, tarjeta, transferencia, otros_ingresos, efectivo_liquido, total_recaudado, estado, observaciones)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdfinturno());
            pst.setInt(2, dts.getIdinicioturno());
            pst.setString(3, dts.getTurno());
            pst.setString(4, dts.getNumero_turno());
            pst.setString(5, dts.getEmpleado());
            pst.setString(6, dts.getFechaingreso());
            pst.setString(7, dts.getFechasalida());
            pst.setString(8, dts.getRecibos());
            pst.setString(9, dts.getTotalautos());
            pst.setString(10, dts.getTotalmotos());
            pst.setInt(11, dts.getBase());
            pst.setInt(12, dts.getEfectivo());
            pst.setInt(13, dts.getTarjeta());
            pst.setInt(14, dts.getTransferencia());
            pst.setInt(15, dts.getOtros_ingresos());
            pst.setInt(16, dts.getEfectivo_liquido());
            pst.setInt(17, dts.getTotal_recaudado());
            pst.setInt(18, dts.getBase());
            pst.setString(19, dts.getObservaciones());

            int n = pst.executeUpdate();

//        JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public ResultSet realizarConsulta(String inicioturno) throws SQLException {

        sSQL = "select *from inicio_turno where numero_turno=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setString(1, inicioturno);

        return pst.executeQuery();
    }

    public String estadoturno() {
        String estado = "";
        String sSQL = "select estado from inicio_turno ORDER BY numero_turno DESC LIMIT 1;";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                estado = rs.getString("estado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado del turno: " + e.getMessage());
        }

        return estado;
    }

    public int numeroturno() {
        int numeroturno = 0;
        sSQL = "SELECT numero_turno FROM inicio_turno WHERE estado = 'Activo' ORDER BY numero_turno DESC LIMIT 1";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                numeroturno = rs.getInt("numero_turno");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el numero del turno: " + e.getMessage());
        }

        return numeroturno;
    }

    public int[] totalmedio_pagos(int numeroturno) {
        int[] mediosDePago = new int[3]; // Un array para almacenar los totales de efectivo, tarjeta y transferencia

        // Consulta SQL para obtener los totales de medios de pago durante un turno activo
        String sSQL = "SELECT SUM(efectivo) AS efectivo, SUM(tarjeta) AS tarjeta, SUM(transferencia) AS transferencia "
                + "FROM salida WHERE turnosalida = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, numeroturno);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    mediosDePago[0] = rs.getInt("efectivo"); // Total en efectivo
                    mediosDePago[1] = rs.getInt("tarjeta");  // Total en tarjeta
                    mediosDePago[2] = rs.getInt("transferencia"); // Total en transferencia
                }
            }

            return mediosDePago; // Retornar el array con los totales
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener totales en medios de pago: " + e.getMessage());
            return new int[]{0, 0, 0}; // En caso de error, retornar un array con valores 0
        }
    }

    public String Consultaempleado(int idturno) throws SQLException {
        String empleado1 = "";
        sSQL = "SELECT empleado FROM inicio_turno WHERE idturno =? AND estado ='Activo';";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, idturno);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    empleado1 = rs.getString("empleado");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el dato del empleado: " + e.getMessage());
        }

        return empleado1;
    }

}
