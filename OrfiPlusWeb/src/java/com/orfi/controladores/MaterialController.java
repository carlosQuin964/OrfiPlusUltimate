package com.orfi.controladores;

import com.orfi.entity.Material;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "materialController")
@ViewScoped
public class MaterialController extends AbstractController<Material> {

    public MaterialController() {
        // Inform the Abstract parent controller of the concrete Material Entity
        super(Material.class);
    }

    /**
     * Sets the "items" attribute with a collection of Joya entities that are
     * retrieved from Material?cap_first and returns the navigation outcome.
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
