
package LogicaP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Cconexionp {
    Connection conectar = null;
    String user ="root";
    String pass ="admin";
    String bd ="parqueadero_pits";
    String ip ="localhost";
    String puerto ="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexionp(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar=DriverManager.getConnection(cadena, user, pass);
           
//            JOptionPane.showMessageDialog(null, "se conecto a la base de datos correctamente");
            
            
        } catch (ClassNotFoundException | SQLException e) {
             //JOptionPane.showMessageDialog(null, "NO se conecto a la base de datos correctamente");
        }
        return conectar;
    }
}
