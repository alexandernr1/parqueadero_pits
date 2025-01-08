package LogicaP;

import DatosP.Dtipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ftipo {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "Tipo servicio", "Tipo convenio", "Valor"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM tipo WHERE idtipo LIKE ? ORDER BY idtipo";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idtipo");
                registro[1] = rs.getString("tipo_servicio");
                registro[2] = rs.getString("tipo_convenio");
                registro[3] = rs.getString("valor");

                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Dtipo dts) {
        sSQL = "insert into tipo (  tipo_servicio, tipo_convenio, valor)"
                + " values (?, ?, ?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getTipo_servicio());
            pst.setString(2, dts.getTipo_convenio());
            pst.setString(3, dts.getValor());

            int n = pst.executeUpdate();

//        JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dtipo dts) throws SQLException {
        // Actualizar la sentencia SQL para incluir la cláusula WHERE
        sSQL = "UPDATE tipo SET tipo_servicio=?, tipo_convenio=?, valor=?"
                + " WHERE idtipo=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {

            // Establecer los parámetros en el orden correcto
            pst.setString(1, dts.getTipo_servicio());
            pst.setString(2, dts.getTipo_convenio());
            pst.setString(3, dts.getValor());
            pst.setInt(4, dts.getIdtipo());

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
