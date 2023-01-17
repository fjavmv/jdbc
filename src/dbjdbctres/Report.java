package dbjdbctres;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;


public class Report {

    Connection connection = DbConection.abrirConexion();

    public Report() {
         generaReporteDb();
        //generaReporteDataSource();
        generarReporteConjrxml();
    }

    public void generarReporteConjrxml() {
        try {
            String template = "C:\\Users\\mende\\Desktop\\templates\\ac_1.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(template);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generaReporteDataSource() {
        try {
            File file = new File("C:\\Users\\mende\\Desktop\\templates\\Objeto.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObject(JRLoader.getInputStream(file));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report,null,DataSource.getDataSource());
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void generaReporteDb() {
        try {
            File file = new File("C:\\Users\\mende\\Desktop\\templates\\actoresB.jasper");
            FileInputStream inputStream = new FileInputStream(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, null, connection);
            //Permite generar un pdf de manera automatica
            //generarPdf(jasperPrint);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void generarPdf(JasperPrint jasperPrint) throws JRException {
        //A pdf
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("C:\\Users\\mende\\Desktop\\templates\\actores.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();
    }
}
