package com.orfi.controladores;

import com.orfi.entity.AuditoriaJoya;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "auditoriaJoyaController")
@ViewScoped
public class AuditoriaJoyaController extends AbstractController<AuditoriaJoya> {

    public AuditoriaJoyaController() {
        // Inform the Abstract parent controller of the concrete AuditoriaJoya Entity
        super(AuditoriaJoya.class);
    }

}
