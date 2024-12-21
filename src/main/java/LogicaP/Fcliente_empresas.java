package LogicaP;

import DatosP.Dcliente_empresas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fcliente_empresas {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "Placa", "Tipo vehiculo", "Cliente", "Telefono", "Tipo servicio", "Estado", "observaciones"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM cliente_empresa WHERE placa LIKE ? ORDER BY idcliente";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idcliente");
                registro[1] = rs.getString("placa");
                registro[2] = rs.getString("tipo_vehiculo");
                registro[3] = rs.getString("cliente");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("tipo_servicio");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("observaciones");

                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Dcliente_empresas dts) {
        sSQL = "insert into cliente_empresa ( placa, tipo_vehiculo, cliente, telefono, tipo_servicio, estado, observaciones)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getPlaca());
            pst.setString(2, dts.getTipo_vehiculo());
            pst.setString(3, dts.getCliente());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getTipo_servicio());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getObservaciones());

            int n = pst.executeUpdate();

//        JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dcliente_empresas dts) throws SQLException {
        // Actualizar la sentencia SQL para incluir la cláusula WHERE
        sSQL = "UPDATE cliente_empresa SET placa=?, tipo_vehiculo=?, cliente=?, telefono=?, tipo_servicio=?, estado=?, observaciones=?"
                + " WHERE idtarifas=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {

            // Establecer los parámetros en el orden correcto
            pst.setString(1, dts.getPlaca());
            pst.setString(2, dts.getTipo_vehiculo());
            pst.setString(3, dts.getCliente());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getTipo_servicio());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getObservaciones());
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
