/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.MaterialFacade;
import com.orfi.entity.Material;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@Named(value = "ReporteMaterial")
@RequestScoped
public class ReporteMaterial {
    @EJB
    private MaterialFacade MaterialFacade;
    private List<Material> material;

    @PostConstruct
    public void init() {
        material = MaterialFacade.findAll();
    }
    public void exportarPDF() throws JRException, IOException {
        //Exportacion a PDF
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,Object>parametros=new HashMap<>();
       
        String path = fc.getExternalContext().getRealPath("./reportes/Materiales.jasper");
        File archivo=new File(path);
        JasperPrint jasper=JasperFillManager.fillReport(archivo.getPath(),parametros, new JRBeanCollectionDataSource(material));
        HttpServletResponse response=(HttpServletResponse) fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition","attachment;filename=reportedeMateriales-"+new Date()+".pdf");
        ServletOutputStream stream=response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasper, stream);
        stream.flush();
        stream.close();
        fc.responseComplete();
        
    }
    
}
