/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.JoyaFacade;
import com.orfi.entity.Joya;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author USUARIO
 */
@Named(value = "reporteDisenio")
@RequestScoped
public class reporteDisenio {
     private DonutChartModel donutChartModel;
    private PieChartModel pieChartModel;
    private List<Joya> joyas;

    @EJB
    private JoyaFacade joyaFacade;

    @PostConstruct
    public void init() {
        generarReporte();
        generarReporte2();
    }

    public DonutChartModel getDonutChartModel() {
        return donutChartModel;
    }

    public void setDonutChartModel(DonutChartModel donutChartModel) {
        this.donutChartModel = donutChartModel;
    }

    public PieChartModel getPieChartModel() {
        return pieChartModel;
    }

    public void setPieChartModel(PieChartModel pieChartModel) {
        this.pieChartModel = pieChartModel;
    }

    public void generarReporte() {

        donutChartModel = new DonutChartModel();
        Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
        
        circle1.put("Daewo", 130);
        circle1.put("Ferrari", 120);
        circle1.put("BMW", 100);
        circle1.put("otro", 100);
        donutChartModel.addCircle(circle1);

        donutChartModel.setTitle("Autos en concesionario");
        donutChartModel.setLegendPosition("a");
        donutChartModel.setSliceMargin(5);
        donutChartModel.setShowDataLabels(true);
        donutChartModel.setDataFormat("value");
        donutChartModel.setShadow(false);

    }

    public void generarReporte2() {

        pieChartModel = new PieChartModel();
         joyas = joyaFacade.findAll();
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;
        int contador4 = 0;
        int contador5 = 0;

        for (Joya joyas1 : joyas) {

           if (joyas1.getIdDisenio().getDisenio().equalsIgnoreCase("diseño plano")) {
                contador1++;
                pieChartModel.set("diseño plano", contador1);
            }
            if (joyas1.getIdDisenio().getDisenio().equalsIgnoreCase("diseño mediacaña")) {
                contador2++;
                pieChartModel.set("diseño mediacaña", contador2);
            }
             if (joyas1.getIdDisenio().getDisenio().equalsIgnoreCase("diseño3")) {
                contador3++;
                pieChartModel.set("diseño3", contador3);
            }
             if (joyas1.getIdDisenio().getDisenio().equalsIgnoreCase("diseño calada")) {
                contador4++;
                pieChartModel.set("diseño calada", contador4);
            }
             if (joyas1.getIdDisenio().getDisenio().equalsIgnoreCase("diseño tejido basico")) {
                contador5++;
                pieChartModel.set("diseño tejido basico", contador5);
            }
          
            
        }

        pieChartModel.setTitle("Reporte Diseño");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);

    }
}
