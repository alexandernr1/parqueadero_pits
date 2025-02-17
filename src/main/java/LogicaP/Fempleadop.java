package LogicaP;

import DatosP.Dempleadop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fempleadop {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrarp(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"idempleado", "Nombres", "Apellidos", "Tipodocumento", "Documento", "Teléfono", "Dirección", "Email", "pais", "ciudad", "Acceso", "Login", "Password", "Estado", "eps", "arl"};

        String[] registro = new String[16];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM empleado WHERE documento LIKE ? ORDER BY idempleado";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("idempleado");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("tipodocumento");
                registro[4] = rs.getString("documento");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("email");
                registro[8] = rs.getString("pais");
                registro[9] = rs.getString("ciudad");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");
                registro[14] = rs.getString("eps");
                registro[15] = rs.getString("arl");

                totalregistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarvistap(String buscar) throws SQLException {
        DefaultTableModel modelo;

        String[] titulos = {"idempleado", "Nombres", "Apellidos", "Tipodocumento", "Documento", "Teléfono", "Dirección", "Email", "pais", "ciudad", "Acceso", "Login", "Password", "Estado", "eps", "arl"};

        String[] registro = new String[16];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM empleado WHERE documento LIKE ? ORDER BY idempleado ";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);
        try {

            while (rs.next()) {
                registro[0] = rs.getString("idempleado");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("tipodocumento");
                registro[4] = rs.getString("documento");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("email");
                registro[8] = rs.getString("pais");
                registro[9] = rs.getString("ciudad");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");
                registro[14] = rs.getString("eps");
                registro[15] = rs.getString("arl");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public boolean insertar(Dempleadop dts) throws SQLException {
        sSQL = "insert into empleado (nombres, apellidos, tipodocumento, documento, telefono, direccion, email, pais, ciudad, acceso, login, password, estado, eps, arl)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {

            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTipodocumento());
            pst.setString(4, dts.getDocumento());
            pst.setString(5, dts.getTelefono());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getEmail());
            pst.setString(8, dts.getPais());
            pst.setString(9, dts.getCiudad());
            pst.setString(10, dts.getAcceso());
            pst.setString(11, dts.getLogin());
            pst.setString(12, dts.getPassword());
            pst.setString(13, dts.getEstado());
            pst.setString(14, dts.getEps());
            pst.setString(15, dts.getArl());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dempleadop dts) throws SQLException {
         sSQL = "UPDATE empleado SET nombres=?,apellidos=?,tipodocumento=?,documento=?,"
                + "telefono=?, direccion=?,email=?,pais=?,ciudad=?,acceso=?,login=?,password=?,estado=?,eps=?,arl=? "
                + "WHERE idempleado=?";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTipodocumento());
            pst.setString(4, dts.getDocumento());
            pst.setString(5, dts.getTelefono());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getEmail());
            pst.setString(8, dts.getPais());
            pst.setString(9, dts.getCiudad());
            pst.setString(10, dts.getAcceso());
            pst.setString(11, dts.getLogin());
            pst.setString(12, dts.getPassword());
            pst.setString(13, dts.getEstado());
            pst.setString(14, dts.getEps());
            pst.setString(15, dts.getArl());
            pst.setInt(16, dts.getIdempleado());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar EL INGRESO: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(Dempleadop dts) throws SQLException {
        sSQL = "delete from empleado where idempleado=?";

        PreparedStatement pst = null;
        try {

            pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdempleado());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la INGRESO: " + e.getMessage());
            return false;
        }

    }

    public Dempleadop login(String login, String password) throws SQLException {
        sSQL = "SELECT idempleado, nombres, apellidos, "
                + "acceso, login, password, estado, eps, arl FROM empleado "
                + "WHERE login = ? AND password = ? AND estado = 'A'";

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, login);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("idempleado");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String acceso = rs.getString("acceso");
                String loginUsuario = rs.getString("login");
                String passwordUsuario = rs.getString("password");
                String estado = rs.getString("estado");

                return new Dempleadop(id, nombres, apellidos, acceso, loginUsuario, passwordUsuario, estado);
            } else {
                return null; // Si no se encuentra el usuario
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
