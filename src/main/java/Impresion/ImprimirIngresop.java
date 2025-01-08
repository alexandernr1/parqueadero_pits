package Impresion;

import DatosP.Dingresop;
import LogicaP.Cconexionp;
import LogicaP.Tiempopro;
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

public class ImprimirIngresop {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    PrinterMatrix printer = new PrinterMatrix();

    public boolean ImprimirFactuIngreso() throws FileNotFoundException, IOException, SQLException {
        sSQL = "SELECT * FROM ingreso ORDER BY idingreso DESC LIMIT 1";

        try ( Statement statement = cn.createStatement();  ResultSet resultSet = statement.executeQuery(sSQL)) {

            while (resultSet.next()) {
                Dingresop dts = new Dingresop();

                dts.setFechaingreso(resultSet.getString("fechaingreso"));
                dts.setPlaca(resultSet.getString("placa"));
                dts.setTiposervicio(resultSet.getString("tiposervicio"));
                dts.setTipovehiculo(resultSet.getString("tipovehiculo"));
                dts.setNumero(resultSet.getString("numero"));
                dts.setCalle(resultSet.getString("calle"));
                dts.setEmpleado(resultSet.getString("empleado"));
                String tipoVehiculo = resultSet.getString("tipovehiculo"); // Extraer el valor del ResultSet

                // Imprimir los datos
                Tiempopro fecha = new Tiempopro();
               String fechaactual = fecha.getFechacomp();

                Extenso extenso = new Extenso();
                extenso.setNumber(101.85);
                printer.setOutSize(19, 32);
                printer.printTextWrap(1, 2, 10, 32, "PITS S.A.S ");
                printer.printTextWrap(2, 3, 12, 80, "NIT: 901 121 607 ");
                printer.printTextWrap(3, 3, 14, 80, "GT JMC 0,2 Via Guarne");
                printer.printTextWrap(6, 3, 4, 80, "Tel: 604 4086060");
                printer.printTextWrap(4, 3, 15, 80, "Rionegro");
                printer.printTextWrap(5, 3, 8, 80, "Responsable de Iva");
                printer.printTextWrap(7, 3, 4, 80, "Fecha Ingreso: " + dts.getFechaingreso());
                printer.printTextWrap(8, 3, 4, 80, "Placa:" + dts.getPlaca());
                printer.printTextWrap(9, 3, 4, 80, "Modalidad de tarifa: " + dts.getTiposervicio());
                printer.printTextWrap(10, 3, 4, 80, "Tipo vehiculo:" + dts.getTipovehiculo());
                printer.printTextWrap(11, 3, 4, 80, "Numero: $" + dts.getNumero());
                printer.printTextWrap(12, 3, 4, 80, "Zona:" + dts.getCalle());
                printer.printTextWrap(13, 3, 4, 80, "REGLAMENTO");
                if (tipoVehiculo.equals("AUTO")) {
                    printer.printTextWrap(14, 3, 4, 80, "No se responde por");
                } else if (tipoVehiculo.equals("MOTO")) {
                    printer.printTextWrap(15, 3, 4, 80, "No se responde por objetos dejados en la moto que no sea el caso");
                }
                printer.printTextWrap(16, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(17, 3, 4, 80, "Empleado de turno: " + dts.getEmpleado());
                printer.printTextWrap(18, 3, 4, 80, "fecha impresion:" + fechaactual);
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
