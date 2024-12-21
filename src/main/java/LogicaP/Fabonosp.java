package LogicaP;

import DatosP.Dabonosp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fabonosp {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "Fecha" , "Cliente", "Valor_abonos", "Efectivo", "Tarjeta", "Transferencia", "Total", "Saldo", "N° Turno", "Responsable", "Turno"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM abonos WHERE cliente LIKE ? ORDER BY idabonos";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idabonos");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("cliente");
                registro[3] = rs.getString("valor_abonos");
                registro[4] = rs.getString("efectivo");
                registro[5] = rs.getString("tarjeta");
                registro[6] = rs.getString("transferencia");
                registro[7] = rs.getString("total");
                registro[8] = rs.getString("saldo");
                registro[9] = rs.getString("turno");
                registro[10] = rs.getString("responsable");
                registro[11] = rs.getString("turno");

                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Dabonosp dts) {
        sSQL = "insert into abonos ( fecha, cliente, valor_abonos, efectivo, tarjeta, transferencia, total, saldo, numturno, responsable, turno )"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

             pst.setString(1, dts.getFecha());
            pst.setString(2, dts.getCliente());
            pst.setInt(3, dts.getValor_abonos());
            pst.setInt(4, dts.getEfectivo());
            pst.setInt(5, dts.getTarjeta());
            pst.setInt(6, dts.getTransferencia());
            pst.setInt(7, dts.getTotal());
            pst.setInt(8, dts.getSaldo());
            pst.setString(9, dts.getNumturno());
            pst.setString(10, dts.getResponsable());
            pst.setString(11, dts.getTurno());

            int n = pst.executeUpdate();

//        JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dabonosp dts) throws SQLException {
        // Actualizar la sentencia SQL para incluir la cláusula WHERE
        sSQL = "UPDATE abonos SET cliente=?, valor_abonos=?, efectivo=?, tarjeta=?, transferencia=?, total=?, "
                + "saldo=?, numturno=?, responsable=?, turno=? WHERE idtarifas=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {

            pst.setString(1, dts.getCliente());
            pst.setInt(2, dts.getValor_abonos());
            pst.setInt(3, dts.getEfectivo());
            pst.setInt(4, dts.getTarjeta());
            pst.setInt(5, dts.getTransferencia());
            pst.setInt(6, dts.getTotal());
            pst.setInt(7, dts.getSaldo());
            pst.setString(8, dts.getNumturno());
            pst.setString(9, dts.getResponsable());
            pst.setString(10, dts.getTurno());
            // Ejecutar la actualización
            int n = pst.executeUpdate();

            // Devolver true si al menos una fila fue actualizada
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar: " + e.getMessage());
            return false;
        }
    }
}
