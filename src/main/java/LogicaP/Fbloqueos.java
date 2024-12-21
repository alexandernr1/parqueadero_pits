package LogicaP;

import DatosP.Dbloqueos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fbloqueos {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "Tipo bloqueo", "Codigo"};

        String[] registro = new String[3];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM bloqueos WHERE codigo LIKE ? ORDER BY idbloqueo";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idbloqueo");
                registro[1] = rs.getString("tipo_bloqueo");
                registro[2] = rs.getString("codigo");

                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Dbloqueos dts) {
        sSQL = "insert into bloqueos ( tipo_bloqueo, codigo)"
                + " values (?, ?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getTipo_bloqueo());
            pst.setString(2, dts.getCodigo());

            int n = pst.executeUpdate();

//        JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dbloqueos dts) throws SQLException {
        // Actualizar la sentencia SQL para incluir la cláusula WHERE
        sSQL = "UPDATE bloqueos SET tipo_bloqueo=?, codigo=? WHERE idbloqueo=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {

            // Establecer los parámetros en el orden correcto
            pst.setString(1, dts.getTipo_bloqueo());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getIdbloqueo());

            // Ejecutar la actualización
            int n = pst.executeUpdate();

            // Devolver true si al menos una fila fue actualizada
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(Dbloqueos dts) {
        sSQL = "delete from bloqueos where idbloqueo=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdbloqueo());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            return false;
        }

    }

    public boolean verificarBloqueo(String codigo) {
        boolean bloqueado = false;
        sSQL = "SELECT codigo FROM bloqueos WHERE codigo = ?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setString(1, codigo);  // Establecer el código a buscar
            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    bloqueado = true;  // Si se encuentra el código, significa que está bloqueado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Agrega un mensaje de error para facilitar la depuración
        }
        return bloqueado;
    }

}
