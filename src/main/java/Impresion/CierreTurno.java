
package Impresion;

import DatosP.Dsalidaturnop;
import LogicaP.Cconexionp;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;


public class CierreTurno {
    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    PrinterMatrix printer = new PrinterMatrix();
    
    
    
     public boolean  cierreTurno() throws FileNotFoundException, IOException, SQLException {
        sSQL = "SELECT * FROM salida_turno ORDER BY idfinturno DESC LIMIT 1";

        try ( Statement statement = cn.createStatement();  ResultSet resultSet = statement.executeQuery(sSQL)) {

            while (resultSet.next()) {
                Dsalidaturnop dts = new Dsalidaturnop();
               
               
                dts.setTurno(resultSet.getString("turno"));
                dts.setNumero_turno(resultSet.getString("numero_turno"));
                 dts.setEmpleado(resultSet.getString("empleado"));
                  dts.setFechaingreso(resultSet.getString("fechaingreso"));
                dts.setFechasalida(resultSet.getString("fechasalida"));
                dts.setTotalautos(resultSet.getString("totalautos"));
                dts.setTotalmotos(resultSet.getString("totalmotos"));
                dts.setEfectivo(resultSet.getInt("efectivo"));
                dts.setTarjeta(resultSet.getInt("tarjeta"));
                dts.setTransferencia(resultSet.getInt("transferencia"));
                dts.setOtros_ingresos(resultSet.getInt("otros_ingresos"));
                dts.setEfectivo_liquido(resultSet.getInt("efectivo_liquido"));
                dts.setTotal_recaudado(resultSet.getInt("total_recaudado"));
                dts.setObservaciones(resultSet.getString("observaciones"));
               

                

                Extenso extenso = new Extenso();
                extenso.setNumber(101.85);
                printer.setOutSize(21, 32);
                printer.printTextWrap(1, 2, 10, 32, "PITS S.A.S ");
                printer.printTextWrap(2, 3, 12, 80, "NIT: 901 121 607 ");
                printer.printTextWrap(3, 3, 14, 80, "GT JMC 0,2 Via Guarne");
                printer.printTextWrap(6, 3, 4, 80, "Tel: 604 4086060");
                printer.printTextWrap(4, 3, 15, 80, "Rionegro");
                printer.printTextWrap(5, 3, 8, 80, "Responsable de Iva");

               
                printer.printTextWrap(6, 3, 4, 80, "Turno:" + dts.getTurno());
                printer.printTextWrap(7, 3, 4, 80, "Numero Turno: " + dts.getNumero_turno());
                 printer.printTextWrap(8, 3, 4, 80, "Empleado: " + dts.getEmpleado());
                 printer.printTextWrap(9, 3, 4, 80, "Fecha Ingreso: " + dts.getFechaingreso());
                printer.printTextWrap(10, 3, 4, 80, "Fecha Salida: " + dts.getFechasalida());
                printer.printTextWrap(11, 3, 4, 80, "Total Autos," + dts.getTotalautos());

                printer.printTextWrap(12, 3, 4, 80, "Total MOtos: $" + dts.getTotalmotos());
                printer.printTextWrap(13, 3, 4, 80, "Efectivo:" + dts.getEfectivo());
                printer.printTextWrap(14, 3, 4, 80, "Tarjeta:" + dts.getTarjeta());

                printer.printTextWrap(15, 3, 4, 80, "Transferencia: " + dts.getTransferencia());
                printer.printTextWrap(16, 3, 4, 80, "Otros ingresos:" + dts.getOtros_ingresos());
                printer.printTextWrap(17, 3, 4, 80, "Efectivo Liquido:" + dts.getEfectivo_liquido());
                printer.printTextWrap(18, 3, 4, 80, "Totla Rcaudado: " + dts.getTotal_recaudado());
                printer.printTextWrap(19, 3, 4, 80, "Observaciones:" + dts.getObservaciones());

            }

        }

        printer.toFile("impresion.txt");

        try ( FileOutputStream fos = new FileOutputStream("impresion.txt", true)) {
            byte[] cutCommand = new byte[]{0x1D, 0x56, 0x41}; // Comando ESC/POS para cortar el papel
            fos.write(cutCommand);
            fos.write(cutCommand);//PRUEBA CORTE DE IMPRESIÓN
        } catch (IOException e) {
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");

        } catch (FileNotFoundException f) {
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc documeDoc = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attribute = new HashPrintRequestAttributeSet();
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(documeDoc, attribute);
            } catch (PrintException e) {
                System.out.println("ERROR: " + e);
            }
        } else {
            System.out.println("No hay una impresora conectada");
        }

        return true;
    }
    
}
