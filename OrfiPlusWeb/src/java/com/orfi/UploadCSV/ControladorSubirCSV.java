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
import com.orfi.Facades.PersonaFacade;
import com.orfi.entity.Persona;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;

public class ControladorSubirCSV {

    private CSVReader csvReader;
    private FileUploadView cargador;
    private List<Persona> personasLista;
    private Persona personaEntity;
    private String[] nextLine;
    private List list;
    private CsvToBean csv = new CsvToBean();
    
    @EJB
    private PersonaFacade personaFacade;

    public void LeerArchivo(String ruta) throws IOException {
        try {
            csvReader = new CSVReader(new FileReader(ruta), ',', '"', 1);
            list = csv.parse(setColumMapping(), csvReader);
        } catch (Exception e) {
        } finally {
            for (Object object : list) {
                personaEntity = (Persona) object;
                personaFacade.create(personaEntity);
            }
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
