package LogicaP;

import DatosP.Dtarifas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ftarifas {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "Tipo servicio", "Precio"};

        String[] registro = new String[3];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM tarifas WHERE tipo_servicio LIKE ? ORDER BY idtarifas";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idtarifas");
                registro[1] = rs.getString("tipo_servicio");
                registro[2] = rs.getString("precio");

                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Dtarifas dts) {
        sSQL = "insert into tarifas ( tipo_servicio, precio)"
                + " values (?, ?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getTipo_servicio());
            pst.setInt(2, dts.getPrecio());

            int n = pst.executeUpdate();

//        JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dtarifas dts) throws SQLException {
        // Actualizar la sentencia SQL para incluir la cláusula WHERE
        sSQL = "UPDATE tarifas SET tipo_servicio=?, precio=? WHERE idtarifas=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {

            // Establecer los parámetros en el orden correcto
            pst.setString(1, dts.getTipo_servicio());  // tipo_vehiculo
            pst.setInt(2, dts.getPrecio());  // precio
            pst.setInt(3, dts.getIdtarifas());  // idtarifas (el identificador que se debe actualizar)

            // Ejecutar la actualización
            int n = pst.executeUpdate();

            // Devolver true si al menos una fila fue actualizada
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(Dtarifas dts) throws SQLException {
        sSQL = "delete from tarifas where idtarifas=?";

        PreparedStatement pst = null;
        try {

            pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdtarifas());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la INGRESO: " + e.getMessage());
            return false;
        }

    }

}
