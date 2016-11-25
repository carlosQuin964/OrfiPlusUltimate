/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.UploadCSV;

/**
 *
 * @author Sergio
 */
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.orfi.Facades.DisenioFacade;
import com.orfi.Facades.EstadoFacade;
import com.orfi.Facades.JoyaFacade;
import com.orfi.Facades.MaterialFacade;
import com.orfi.Facades.OrdenFacade;
import com.orfi.Facades.PersonaFacade;
import com.orfi.Facades.TipoFacade;
import com.orfi.entity.Disenio;
import com.orfi.entity.Estado;
import com.orfi.entity.Joya;
import com.orfi.entity.Material;
import com.orfi.entity.Orden;
import com.orfi.entity.Persona;
import com.orfi.entity.Tipo;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "subirCSV")
@RequestScoped
public class ControladorSubirCSV implements Serializable {

    private CSVReader csvReader;
    private String clase;
    private FileUploadView cargador;
    private List<Persona> personasLista;
    private String[] nextLine;
    private List list;
    private CsvToBean csv = new CsvToBean();

    private Disenio disenioEntity;
    private Estado estadoEntity;
    private Joya joyaEntity;
    private Material materialEntity;
    private Orden ordenEntity;
    private Persona personaEntity;
    private Tipo tipoEntity;

    @EJB
    private DisenioFacade disenioFacade;
    @EJB
    private EstadoFacade estadoFacade;
    @EJB
    private JoyaFacade joyaFacade;
    @EJB
    private MaterialFacade materialFacade;
    @EJB
    private OrdenFacade ordenFacade;
    @EJB
    private PersonaFacade personaFacade;
    @EJB
    private TipoFacade tipoFacade;

    public String getClase() {
        return clase;
    }

    public void setClase (String clase) {
        this.clase = clase;
    }

    public void LeerArchivo(String ruta) {
        
        try {
            System.out.println("crear objeto lector");
            csvReader = new CSVReader(new FileReader(ruta), ',', '"', 1);
            System.out.println("lee el archivo y lo carga en una lista");
            list = csv.parse(setColumMapping(), csvReader);
        } catch (Exception e) {
        } finally {
            System.out.println("va a entrar al swtich");
            switch (Integer.parseInt(clase)) {

                case 1:
                    for (Object object : list) {
                        disenioEntity = (Disenio) object;
                        disenioFacade.create(disenioEntity);
                    }
                    break;
                case 2:
                    for (Object object : list) {
                        joyaEntity = (Joya) object;
                        joyaFacade.create(joyaEntity);
                    }
                    break;
                case 3:
                    for (Object object : list) {
                        materialEntity = (Material) object;
                        materialFacade.create(materialEntity);
                    }
                    break;
                case 4:
                    for (Object object : list) {

                        ordenEntity = (Orden) object;
                        ordenFacade.create(ordenEntity);
                    }
                    break;
                case 5:
                    for (Object object : list) {

                        personaEntity = (Persona) object;
                        personaFacade.create(personaEntity);
                    }
                    break;
                case 6:
                    for (Object object : list) {

                        tipoEntity = (Tipo) object;
                        tipoFacade.create(tipoEntity);
                    }
                    break;
                default:
                    break;
            }
            System.out.println("salio del switch");
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Persona.class);
        String[] columns = new String[]{"id", "firstName", "lastName", "country", "age"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
