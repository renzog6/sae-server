package ar.nex.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import ar.nex.entity.empleado.Vacacion;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@Service
public class PDFService {

    @Autowired
    ResourceLoader resourceLoader;

    public ByteArrayInputStream getNotificacion(Vacacion vacacion) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {

            Resource resource = resourceLoader.getResource("classpath:notificacion_vacaciones.pdf");
            InputStream input = resource.getInputStream();
            // File file = resource.getFile();

            PDDocument pDDocument = PDDocument.load(input);
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();

            PDField field = pDAcroForm.getField("fecha");
            String pattern = "EEEE dd MMMM yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("es", "AR"));
            String date = simpleDateFormat.format(vacacion.getFecha());
            field.setValue("Villa Minetti, " + date);

            field = pDAcroForm.getField("nombreEmpleado");
            String nombreEmpleado = vacacion.getEmpleado().getApellido();
            nombreEmpleado += " " + vacacion.getEmpleado().getNombre();
            field.setValue(nombreEmpleado);

            field = pDAcroForm.getField("anio");
            field.setValue(String.valueOf(vacacion.getAnio()));

            field = pDAcroForm.getField("dias");
            field.setValue(String.valueOf(vacacion.getDias() * -1));

            field = pDAcroForm.getField("desde");
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            date = simpleDateFormat.format(vacacion.getFechaToma());
            field.setValue(date);

            field = pDAcroForm.getField("hasta");
            Calendar c = Calendar.getInstance();
            c.setTime(vacacion.getFechaToma());
            c.add(Calendar.DATE, (vacacion.getDias() * -1) - 1);
            // dt = c.getTime();
            date = simpleDateFormat.format(c.getTime());
            field.setValue(date);

            pDDocument.save(out);
            pDDocument.close();

            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("fail to import data to PDF file: " + e.getMessage());
        }
    }

}
