/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.PersonaFacade;
import com.orfi.entity.Persona;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 *
 * @author USUARIO
 */
@Named(value = "reporteController")
@RequestScoped
public class reporteController {
     @EJB
    private PersonaFacade usuarioFacade;
    private List<Persona> usuarios;

    @PostConstruct
    public void init() {
        usuarios = usuarioFacade.findAll();
    }

   public void exportarPDF() throws JRException, IOException, ClassNotFoundException, SQLException {
       //Exportacion a PDF
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/orfiplusdb", "Admin", "AdminAdmin");
   
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, Object> parametros = new HashMap<>();

        String path = fc.getExternalContext().getRealPath("./reportes/reporteUsuarios.jasper");
        File archivo = new File(path);
        JasperPrint jasper = JasperFillManager.fillReport(archivo.getPath(), parametros, con);
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment;filename=reporteUusuarios-" + new Date() + ".pdf");
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasper, stream);//Se comenta esta linea si no es para PDF

        /*Excell
        JRXlsExporter exporter=new JRXlsExporter(); .xls
         JRPptxExporter exporter=new JRPptxExporter(); Power Point .ppt
        JRDocxExporter exporter=new JRDocxExporter(); Word .doc
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasper);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,stream);
        exporter.exportReport();*/
        stream.flush();
        stream.close();
        fc.responseComplete();

        
    }
    
}
