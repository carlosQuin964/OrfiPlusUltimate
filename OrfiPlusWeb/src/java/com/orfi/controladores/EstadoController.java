package com.orfi.controladores;

import com.orfi.entity.Estado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "estadoController")
@ViewScoped
public class EstadoController extends AbstractController<Estado> {

    public EstadoController() {
        // Inform the Abstract parent controller of the concrete Estado Entity
        super(Estado.class);
    }

    /**
     * Sets the "items" attribute with a collection of Joya entities that are
     * retrieved from Estado?cap_first and returns the navigation outcome.
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
