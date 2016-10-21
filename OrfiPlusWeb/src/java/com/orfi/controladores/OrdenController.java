package com.orfi.controladores;

import com.orfi.Facades.JoyaFacade;
import com.orfi.Facades.OrdenFacade;
import com.orfi.entity.Joya;
import com.orfi.entity.Orden;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ordenController")
@ViewScoped
public class OrdenController extends AbstractController<Orden> {
private OrdenFacade ordenfacade;
    public OrdenController() {
        // Inform the Abstract parent controller of the concrete Orden Entity
        super(Orden.class);
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from Orden?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", this.getSelected().getPersonaList());
        }
        return "/protegido/pages/persona/index";
    }

    /**
     * Sets the "items" attribute with a collection of Joya entities that are
     * retrieved from Orden?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Joya page
     */
    public String navigateJoyaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Joya_items", this.getSelected().getJoyaList());
        }
        return "/protegido/pages/joya/index";
    }
    
     

}
