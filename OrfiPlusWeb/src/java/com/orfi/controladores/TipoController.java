package com.orfi.controladores;

import com.orfi.entity.Joya;
import com.orfi.entity.Tipo;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

@Named(value = "tipoController")
@ViewScoped
public class TipoController extends AbstractController<Tipo> {

    @EJB
    private Tipo tipoFacade;
    
    public TipoController() {
        // Inform the Abstract parent controller of the concrete Tipo Entity
        super(Tipo.class);
    }

    /**
     * Sets the "items" attribute with a collection of Joya entities that are
     * retrieved from Tipo?cap_first and returns the navigation outcome.
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
