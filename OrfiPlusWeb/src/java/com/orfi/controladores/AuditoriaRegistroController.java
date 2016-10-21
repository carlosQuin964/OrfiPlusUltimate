package com.orfi.controladores;

import com.orfi.entity.AuditoriaRegistro;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "auditoriaRegistroController")
@ViewScoped
public class AuditoriaRegistroController extends AbstractController<AuditoriaRegistro> {

    public AuditoriaRegistroController() {
        // Inform the Abstract parent controller of the concrete AuditoriaRegistro Entity
        super(AuditoriaRegistro.class);
    }

}
