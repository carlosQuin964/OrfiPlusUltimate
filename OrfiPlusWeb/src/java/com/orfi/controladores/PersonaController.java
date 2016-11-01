package com.orfi.controladores;

import com.orfi.Facades.PersonaFacade;
import com.orfi.entity.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    private Persona personas;
    private List<Persona> per;
    @EJB
    private PersonaFacade personaFacade;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona Entity
        super(Persona.class);
    }

    public Persona getPersonas() {
        return personas;
    }

    public void setPersonas(Persona personas) {
        this.personas = personas;
    }

    @PostConstruct
    public void init(){
        personas = new Persona();
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

    public List<Persona> consultarPersonas() {
        if (per == null) {
            per = this.personaFacade.consultarPersonas();
        }
        return per;
    }

}
