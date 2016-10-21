package com.orfi.controladores;

import com.orfi.entity.Persona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona Entity
        super(Persona.class);
    }

    /**
     * Sets the "items" attribute with a collection of Rol entities that are
     * retrieved from Persona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Rol page
     */
    public String navigateRolList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rol_items", this.getSelected().getRolList());
        }
        return "/protegido/pages/rol/index";
    }

    /**
     * Sets the "items" attribute with a collection of Orden entities that are
     * retrieved from Persona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Orden page
     */
    public String navigateOrdenList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Orden_items", this.getSelected().getOrdenList());
        }
        return "/protegido/pages/orden/index";
    }

}
