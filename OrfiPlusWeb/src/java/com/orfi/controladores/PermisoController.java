package com.orfi.controladores;

import com.orfi.entity.Permiso;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "permisoController")
@ViewScoped
public class PermisoController extends AbstractController<Permiso> {

    @Inject
    private PermisoController pERMISOSidPERMISOSController;

    public PermisoController() {
        // Inform the Abstract parent controller of the concrete Permiso Entity
        super(Permiso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        pERMISOSidPERMISOSController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Rol entities that are
     * retrieved from Permiso?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Permiso entities that are
     * retrieved from Permiso?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Permiso page
     */
    public String navigatePermisoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Permiso_items", this.getSelected().getPermisoList());
        }
        return "/protegido/pages/permiso/index";
    }

    /**
     * Sets the "selected" attribute of the Permiso controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePERMISOSidPERMISOS(ActionEvent event) {
        if (this.getSelected() != null && pERMISOSidPERMISOSController.getSelected() == null) {
            pERMISOSidPERMISOSController.setSelected(this.getSelected().getPERMISOSidPERMISOS());
        }
    }
}
