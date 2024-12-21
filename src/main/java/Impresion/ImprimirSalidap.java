package Impresion;

import DatosP.Dsalidap;
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
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class ImprimirSalidap {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    PrinterMatrix printer = new PrinterMatrix();
    Tiempopro fecha = new Tiempopro();
    Tiempopro hora = new Tiempopro();

    public boolean ImprimirFacturaPago() throws FileNotFoundException, IOException, SQLException {
        sSQL = "SELECT * FROM salida ORDER BY idsalida DESC LIMIT 1";

        try ( Statement statement = cn.createStatement();  ResultSet resultSet = statement.executeQuery(sSQL)) {

            while (resultSet.next()) {
                Dsalidap dts = new Dsalidap();
                dts.setNumfactura(resultSet.getString("numfactura"));
                dts.setFechaentrada(resultSet.getString("fechaentrada"));
                dts.setFechasalida(resultSet.getString("fechasalida"));
                dts.setPlaca(resultSet.getString("placa"));
                dts.setTiposervicio(resultSet.getString("tiposervicio"));
                dts.setDias(resultSet.getInt("dias"));
                dts.setHoras(resultSet.getInt("horas"));
                dts.setMinutos(resultSet.getInt("minutos"));
                dts.setAntesiva(resultSet.getInt("antesiva"));
                dts.setIva19(resultSet.getInt("iva19"));
                dts.setImpuesto9(resultSet.getInt("impuesto9"));
                dts.setValor(resultSet.getInt("valor"));
                dts.setTotal(resultSet.getInt("total"));
                dts.setEmpleadosalida(resultSet.getString("empleadosalida"));

                // Imprimir los datos
                fecha.getFechacomp();
                hora.getHoracomp();

                Extenso extenso = new Extenso();
                extenso.setNumber(101.85);
                printer.setOutSize(31, 32);
                printer.printTextWrap(1, 2, 10, 32, "PITS S.A.S ");
                printer.printTextWrap(2, 3, 12, 80, "NIT: 901 121 607 ");
                printer.printTextWrap(3, 3, 14, 80, "GT JMC 0,2 Via Guarne");
                printer.printTextWrap(6, 3, 4, 80, "Tel: 604 4086060");
                printer.printTextWrap(4, 3, 15, 80, "Rionegro");
                printer.printTextWrap(5, 3, 8, 80, "Responsable de Iva");

//                printer.printTextWrap(6, 3, 4, 80, "Resolucion de la DIAN: 000000000");
//                 printer.printTextWrap(6, 3, 4, 80, "Habilitada desde: 000000");
                printer.printTextWrap(9, 3, 4, 80, "Numero Factura: " + dts.getNumfactura());
                printer.printTextWrap(9, 3, 4, 80, "Fecha: " + fecha);

                printer.printTextWrap(7, 3, 4, 80, "Fecha Ingreso: " + dts.getFechaentrada());
                printer.printTextWrap(8, 3, 4, 80, "Fecha Salida: " + dts.getFechasalida());
                printer.printTextWrap(13, 3, 4, 80, "Placa:" + dts.getPlaca());
                printer.printTextWrap(10, 3, 4, 80, "Modalidad de tarifa: " + dts.getTiposervicio());
                printer.printTextWrap(11, 3, 4, 80, "Duracion:" + "Dias," + dts.getDias() + "Horas," + dts.getHoras() + "Minutos," + dts.getMinutos());

                printer.printTextWrap(12, 3, 4, 80, "Subtotal: $" + dts.getAntesiva());
                printer.printTextWrap(13, 3, 4, 80, "Iva:" + dts.getIva19());
                printer.printTextWrap(20, 3, 4, 80, "Contribucion: $" + dts.getImpuesto9());

                printer.printTextWrap(14, 3, 4, 80, "valor: " + dts.getValor());
                printer.printTextWrap(14, 3, 4, 80, "Descuento:");
                printer.printTextWrap(14, 3, 4, 80, "valor a apagar: " + dts.getTotal());

                // Mostrar solo las formas de pago que tienen valor
                int currentLine = 19; // Posición de impresión dinámica
                if (dts.getEfectivo() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Efectivo: $" + dts.getEfectivo());
                }
                if (dts.getTarjeta() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Tarjeta: $" + dts.getTarjeta());
                }
                if (dts.getTransferencia() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Transferencias: $" + dts.getTransferencia());
                }
                printer.printTextWrap(21, 3, 4, 80, "El cobro de la contribucion corresponde al decreto 299"
                        + " del municipio de rionegro");
                // Finalización del ticket
                printer.printTextWrap(27, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(28, 3, 4, 80, "Empleado: " + dts.getEmpleadosalida());
                printer.printTextWrap(29, 3, 4, 80, "fecha impresion:" + fecha + hora);
            }

        }

        printer.toFile("impresion.txt");

        try ( FileOutputStream fos = new FileOutputStream("impresion.txt", true)) {
            byte[] cutCommand = new byte[]{0x1D, 0x56, 0x41}; // Comando ESC/POS para cortar el papel
            fos.write(cutCommand);
            fos.write(cutCommand);//PRUEBA CORTE DE IMPRESIÓN
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc documeDoc = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attribute = new HashPrintRequestAttributeSet();
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(documeDoc, attribute);
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
            }
        } else {
            System.out.println("No hay una impresora conectada");
        }

        return true;
    }

}
