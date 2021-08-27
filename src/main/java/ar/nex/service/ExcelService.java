package ar.nex.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.nex.entity.empleado.Empleado;
import ar.nex.entity.empleado.Vacacion;
import ar.nex.repository.EmpleadoRepository;
import ar.nex.repository.VacacionRepository;
import ar.nex.util.DateAux;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@Service
public class ExcelService {
    @Autowired
    VacacionRepository vacacionRepo;

    @Autowired
    EmpleadoRepository empleadoRepo;

    private int diasDisponibles(List<Vacacion> vacaciones) {

        int dias = 0;
        if (vacaciones != null) {
            for (Vacacion v : vacaciones) {
                dias += v.getDias();
            }
        }

        return dias;
    }

    public ByteArrayInputStream todosToExcel(List<Empleado> empleados) {
        String[] HEADERS = { "Empleado", "Fecha Alta", "Antiguedad", "Dias Disponibles", "Categoria", "Puesto" };
        String SHEET = "Vacaciones";
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            DateAux dateAux = new DateAux();

            // Header
            Row headerRow = sheet.createRow(0);
            headerRow.setHeight((short) 400);
            CellStyle styleHeader = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeight(12);
            styleHeader.setFont(font);
            styleHeader.setAlignment(HorizontalAlignment.CENTER);

            for (int col = 0; col < HEADERS.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERS[col]);
                cell.setCellStyle(styleHeader);
            }

            // Body
            CellStyle style = workbook.createCellStyle();
            CellStyle styleDate = workbook.createCellStyle();
            CellStyle styleCenter = workbook.createCellStyle();
            font = workbook.createFont();
            font.setFontHeight(12);
            style.setFont(font);
            styleDate.setFont(font);
            styleCenter.setFont(font);
            styleDate.setAlignment(HorizontalAlignment.CENTER);
            styleCenter.setAlignment(HorizontalAlignment.CENTER);
            CreationHelper createHelper = workbook.getCreationHelper();
            styleDate.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

            int rowIdx = 1;
            for (Empleado empleado : empleados) {
                Row row = sheet.createRow(rowIdx++);
                row.setHeight((short) 400);

                Cell cell = row.createCell(0);//
                cell.setCellValue(empleado.getApellido() + " " + empleado.getNombre());
                cell.setCellStyle(style);

                cell = row.createCell(1);
                cell.setCellValue(empleado.getFechaAlta());
                cell.setCellStyle(styleDate);

                cell = row.createCell(2);// Antiguedad
                cell.setCellValue(dateAux.getEdad(empleado.getFechaAlta()));
                cell.setCellStyle(styleCenter);

                cell = row.createCell(3);// Dias Disponibles
                cell.setCellValue(diasDisponibles(empleado.getVacaciones()));
                cell.setCellStyle(styleCenter);

                cell = row.createCell(4);
                cell.setCellValue(empleado.getCategoria().getNombre());
                cell.setCellStyle(style);

                cell = row.createCell(5);
                cell.setCellValue(empleado.getPuesto().getNombre());
                cell.setCellStyle(style);

            }

            for (int col = 0; col < HEADERS.length; col++) {
                sheet.autoSizeColumn(col);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }

    }

    public ByteArrayInputStream unoToExcel(List<Vacacion> vacaciones) {

        String[] HEADERS = { "Fecha", "Detalle", "Dias", "Año", "Fecha Inicio", "Info" };
        String SHEET = "Vacaciones";
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);
            headerRow.setHeight((short) 400);
            CellStyle styleHeader = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeight(12);
            styleHeader.setFont(font);
            styleHeader.setAlignment(HorizontalAlignment.CENTER);

            for (int col = 0; col < HEADERS.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERS[col]);
                cell.setCellStyle(styleHeader);
            }

            // Body
            CellStyle style = workbook.createCellStyle();
            CellStyle styleDate = workbook.createCellStyle();
            font = workbook.createFont();
            font.setFontHeight(12);
            style.setFont(font);
            styleDate.setFont(font);
            styleDate.setAlignment(HorizontalAlignment.CENTER);
            CreationHelper createHelper = workbook.getCreationHelper();
            styleDate.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

            int rowIdx = 1;
            for (Vacacion vaca : vacaciones) {
                Row row = sheet.createRow(rowIdx++);
                row.setHeight((short) 400);

                Cell cell = row.createCell(0);//
                cell.setCellValue(vaca.getFecha());
                cell.setCellStyle(styleDate);

                cell = row.createCell(1);
                cell.setCellValue(vaca.getDetalle());
                cell.setCellStyle(style);

                cell = row.createCell(2);
                cell.setCellValue(vaca.getDias());
                cell.setCellStyle(style);
                // cell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);

                cell = row.createCell(3);
                cell.setCellValue(vaca.getAnio());
                cell.setCellStyle(style);

                cell = row.createCell(4);// .setCellValue(vaca.getFechaToma());
                cell.setCellValue(vaca.getFechaToma());
                cell.setCellStyle(styleDate);

                row.createCell(5).setCellValue(vaca.getInfo());
            }

            for (int col = 0; col < HEADERS.length; col++) {
                sheet.autoSizeColumn(col);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

}