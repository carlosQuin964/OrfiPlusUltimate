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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.PieChartModel;import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.PieChartModel;

@Named(value = "ChartView")
@RequestScoped
public class ChartView {

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
        int contador6 = 0;

        for (Joya joyas1 : joyas) {

           if (joyas1.getIdTipo().getTipo().equalsIgnoreCase("Anillo")) {
                contador1++;
                pieChartModel.set("Anillo", contador1);
            }
            if (joyas1.getIdTipo().getTipo().equalsIgnoreCase("Pulsera")) {
                contador2++;
                pieChartModel.set("Pulsera", contador2);
            }
            if (joyas1.getIdTipo().getTipo().equalsIgnoreCase("Cadena")) {
                contador3++;
                pieChartModel.set("Cadena", contador3);
            }
            if (joyas1.getIdTipo().getTipo().equalsIgnoreCase("Aretes")) {
                contador4++;
                pieChartModel.set("Aretes", contador4);
            }
            if (joyas1.getIdTipo().getTipo().equalsIgnoreCase("candongas")) {
                contador5++;
                pieChartModel.set("candongas", contador5);
            }
            if (joyas1.getIdTipo().getTipo().equalsIgnoreCase("manilla")) {
                contador6++;
                pieChartModel.set("manilla", contador6);
            }
        }

        pieChartModel.setTitle("Joyas");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);

    }

}

