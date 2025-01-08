package Impresion;

import LogicaP.Cconexionp;
import br.com.adilson.util.PrinterMatrix;
import java.io.*;
import java.sql.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;

public class ImprimirArqueo {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    PrinterMatrix printer = new PrinterMatrix();

    public boolean ImprimirArqueo() throws FileNotFoundException, IOException, SQLException, PrintException {
        sSQL = "select numero, calle, placa, tipovehiculo from ingreso where estado = 'Activo' order by calle";

        // Cambiar el tipo de ResultSet a TYPE_SCROLL_INSENSITIVE
        try (Statement statement = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery(sSQL)) {

            // Determina el tamaño del documento basado en los registros.
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
            }

            // Reinicia el ResultSet para iterar nuevamente desde el principio.
            resultSet.beforeFirst(); // Ahora es permitido con el nuevo tipo de ResultSet.

            // Configurar tamaño del documento (7 filas de encabezado + una fila por cada registro).
            printer.setOutSize(7 + rowCount, 40);

            // Imprimir encabezado
            printer.printTextWrap(1, 2, 10, 40, "PITS S.A.S ");
            printer.printTextWrap(2, 3, 12, 40, "NIT: 901 121 607 ");
            printer.printTextWrap(3, 3, 14, 40, "GT JMC 0,2 Via Guarne");
            printer.printTextWrap(4, 3, 4, 40, "Tel: 604 4086060");
            printer.printTextWrap(5, 3, 15, 40, "Rionegro");
            printer.printTextWrap(6, 3, 4, 40, "Lista de Vehiculos Activos");

            // Imprimir registros
            int row = 7; // Inicia después del encabezado
            int maxRows = 16;  // Límite de filas que la impresora puede manejar
            while (resultSet.next()) {
                if (row < maxRows) {
                    String numero = resultSet.getString("numero");
                    String calle = resultSet.getString("calle");
                    String placa = resultSet.getString("placa");
                    String tipovehiculo = resultSet.getString("tipovehiculo");

                    printer.printTextWrap(row, row + 1, 1, 40,
                            "Numero: " + numero + " | Calle: " + calle + " | Placa: " + placa + " | Tipo: " + tipovehiculo);
                    row++;
                } else {
                    // Si se excede el número de filas, detener la impresión
                    System.out.println("Se ha alcanzado el límite de filas de impresión.");
                    break;  // Termina la impresión si el límite es alcanzado
                }
            }
        }

        // Guardar el archivo de impresión
        printer.toFile("impresion.txt");

        // Añadir comando de corte
        try (FileOutputStream fos = new FileOutputStream("impresion.txt", true)) {
            byte[] cutCommand = new byte[]{0x1D, 0x56, 0x41};
            fos.write(cutCommand);
        }

        // Enviar archivo a la impresora
        try (FileInputStream inputStream = new FileInputStream("impresion.txt")) {
            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc documeDoc = new SimpleDoc(inputStream, docFormat, null);

            PrintRequestAttributeSet attribute = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                printJob.print(documeDoc, attribute);
            } else {
                System.out.println("No hay una impresora conectada");
            }
        }

        return true;
    }
}


