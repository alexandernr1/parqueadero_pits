package Reportes;

import DatosP.Dinicioturnop;
import LogicaP.Cconexionp;
import LogicaP.Finicioturnop;
import java.awt.Desktop;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class Metodo_Excel_xlsx {

    private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexionp();
    private String sSQL = "";
    Statement st;
    ResultSet rs;

    public void llenarcboturno(JComboBox<String> combo) {

        DefaultComboBoxModel<String> com = new DefaultComboBoxModel<>();  // Modelo para el JComboBox
        combo.setModel(com);  // Asignamos el modelo al combo
        Cconexionp conexion = new Cconexionp();  // Conexión a la base de datos

        com.addElement("Seleccione un turno");  // Primer elemento del ComboBox

        try {
            // Establecer la conexión y ejecutar la consulta SQL
            Connection conectar = conexion.establecerConexionp();
            st = conectar.createStatement();
            rs = st.executeQuery("SELECT turno FROM inicio_turno"
                    + " ORDER BY idturno DESC LIMIT 10");

            // Recorrer los resultados de la consulta
            while (rs.next()) {
                // Obtener el turno desde el ResultSet
                String turno = rs.getString("turno");

                // Agregar el turno al modelo del ComboBox
                com.addElement(turno);

                // Si tienes un método en Finicioturno para agregar el turno
                Finicioturnop func = new Finicioturnop();
                Dinicioturnop turnos = new Dinicioturnop();
                turnos.setTurno(turno);
                func.agregarturno(turnos);  // Si agregas turnos a algún objeto o lista en Finicioturno
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public DefaultTableModel exportarReporteDia(JComboBox<String> turno1, JComboBox<String> turno2, JComboBox<String> turno3, JTable tablalistado) {

        DefaultTableModel model = (DefaultTableModel) tablalistado.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de llenarla

        // Obtener los valores seleccionados de los combos
        String turnoSeleccionado1 = (String) turno1.getSelectedItem();
        String turnoSeleccionado2 = (String) turno2.getSelectedItem();
        String turnoSeleccionado3 = (String) turno3.getSelectedItem();

        String[] titulos = {"PLACA", "TIPO VEHI", "TIPO SERVI", "FECHA ENTRA", "FECHA SALI", "NUMERO", "EFECTIVO",
            "TARJETA", "TRANSFERENCIA", "TOTAL", "RESPONSABLE SALIDA"};
        model.setColumnIdentifiers(titulos);

        sSQL = "SELECT * FROM parqueadero_pits.salida WHERE turno IN (?, ?, ?)";

        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            // Asignar parámetros
            pst.setString(1, turnoSeleccionado1);
            pst.setString(2, turnoSeleccionado2);
            pst.setString(3, turnoSeleccionado3);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String[] registro = new String[11];
                registro[0] = rs.getString("placa");
                registro[1] = rs.getString("tipovehiculo");
                registro[2] = rs.getString("tiposervicio");
                registro[3] = rs.getString("fechaentrada");
                registro[4] = rs.getString("fechasalida");
                registro[5] = rs.getString("zona");
                registro[6] = rs.getString("efectivo");
                registro[7] = rs.getString("tarjeta");
                registro[8] = rs.getString("transferencia");
                registro[9] = rs.getString("total");
                registro[10] = rs.getString("empleadosalida");

                model.addRow(registro);
            }
            return model;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    public void exportarExcel(JTable tablalistado) {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(tablalistado);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                XSSFWorkbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Reporte");
                Row rowCol = sheet.createRow(0);

                // Crear una fuente personalizada
                XSSFFont fuenteTitulo = new GeneradorFuente.Builder()
                        .setNombreFuente("Arial")
                        .setConNegrita(true)
                        .setTamanioFuente((short) 12)
                        .setColorDefecto(IndexedColors.WHITE.getIndex())
                        .build(wb);

                // Crear un estilo personalizado
                XSSFCellStyle estiloTitulo = new GeneradorEstilo.Builder()
                        .setFuente(fuenteTitulo)
                        .setColorDefecto(IndexedColors.BLUE.getIndex())
                        .setTipoPatron(FillPatternType.SOLID_FOREGROUND)
                        .setAlineacionHorizontal(HorizontalAlignment.CENTER)
                        .setAlineacionVertical(VerticalAlignment.CENTER)
                        .setBordeArriba(BorderStyle.THIN)
                        .setBordeAbajo(BorderStyle.THIN)
                        .setBordeDerecho(BorderStyle.THIN)
                        .setBordeIzquierdo(BorderStyle.THIN)
                        .build(wb);

                // Aplicar estilo a los títulos
                for (int i = 0; i < tablalistado.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tablalistado.getColumnName(i));
                    cell.setCellStyle(estiloTitulo);
                }

                // Estilo para los datos
                XSSFFont fuenteDatos = new GeneradorFuente.Builder()
                        .setNombreFuente("Calibri")
                        .setTamanioFuente((short) 12)
                        .build(wb);

                XSSFCellStyle estiloDatos = new GeneradorEstilo.Builder()
                        .setFuente(fuenteDatos)
                        .setBordeArriba(BorderStyle.THIN)
                        .setBordeAbajo(BorderStyle.THIN)
                        .setBordeDerecho(BorderStyle.THIN)
                        .setBordeIzquierdo(BorderStyle.THIN)
                        .setAlineacionHorizontal(HorizontalAlignment.LEFT)
                        .setAlineacionVertical(VerticalAlignment.CENTER)
                        .build(wb);

                // Llenar los datos
                for (int j = 0; j < tablalistado.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tablalistado.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tablalistado.getValueAt(j, k) != null) {
                            cell.setCellValue(tablalistado.getValueAt(j, k).toString());
                        }
                        cell.setCellStyle(estiloDatos);
                    }
                }
                // Ajustar automáticamente el ancho de las columnas
                for (int i = 0; i < tablalistado.getColumnCount(); i++) {
                    sheet.autoSizeColumn(i);
                }

                // Guardar el archivo
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error al generar el archivo Excel");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

}
