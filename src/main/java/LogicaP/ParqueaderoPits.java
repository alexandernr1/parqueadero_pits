package LogicaP;

import Presentacionp.LoguinDeSistemap;

public class ParqueaderoPits {

    public static void main(String[] args) {
        LoguinDeSistemap prin = new LoguinDeSistemap();
        prin.setVisible(true);

        Cconexionp conexionParquedero = new Cconexionp();
        conexionParquedero.establecerConexionp();
            System.out.println("Conectado a la base de datos del parquedero.");

    }

}
