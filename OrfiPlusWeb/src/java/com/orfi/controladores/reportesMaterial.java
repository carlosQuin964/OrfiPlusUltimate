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
@Named(value = "reportesMaterial")
@RequestScoped
public class reportesMaterial {
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
        joyas = joyaFacade.findAll();
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;
        int contador4 = 0;
       

        for (Joya joyas1 : joyas) {

           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Oro")) {
                contador1++;
                circle1.put("Oro", contador1);
            }
           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Plata")) {
                contador2++;
                circle1.put("Plata", contador2);
            }
           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Bañado en Oro")) {
                contador3++;
                circle1.put("Bañado en Oro", contador3);
            }
           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Bañado en Plata")) {
                contador4++;
                circle1.put("Bañado en Plata", contador4);
            }
            
        }

       

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
       

        for (Joya joyas1 : joyas) {

           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Oro")) {
                contador1++;
                pieChartModel.set("Oro", contador1);
            }
           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Plata")) {
                contador2++;
                pieChartModel.set("Plata", contador2);
            }
           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Bañado en Oro")) {
                contador3++;
                pieChartModel.set("Bañado en Oro", contador3);
            }
           if (joyas1.getIdMaterial().getMaterial().equalsIgnoreCase("Bañado en Plata")) {
                contador4++;
                pieChartModel.set("Bañado en Plata", contador4);
            }
            
        }

        pieChartModel.setTitle("Material");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);

    }
}
