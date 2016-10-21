package com.orfi.controladores;

import com.orfi.entity.Joya;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "joyaController")
@ViewScoped
public class JoyaController extends AbstractController<Joya> {

    @Inject
    private DisenioController idDisenioController;
    @Inject
    private EstadoController idEstadoController;
    @Inject
    private MaterialController idMaterialController;
    @Inject
    private OrdenController idOrdenController;
    @Inject
    private TipoController idTipoController;

    public JoyaController() {
        // Inform the Abstract parent controller of the concrete Joya Entity
        super(Joya.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDisenioController.setSelected(null);
        idEstadoController.setSelected(null);
        idMaterialController.setSelected(null);
        idOrdenController.setSelected(null);
        idTipoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Disenio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDisenio(ActionEvent event) {
        if (this.getSelected() != null && idDisenioController.getSelected() == null) {
            idDisenioController.setSelected(this.getSelected().getIdDisenio());
        }
    }

    /**
     * Sets the "selected" attribute of the Estado controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstado(ActionEvent event) {
        if (this.getSelected() != null && idEstadoController.getSelected() == null) {
            idEstadoController.setSelected(this.getSelected().getIdEstado());
        }
    }

    /**
     * Sets the "selected" attribute of the Material controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMaterial(ActionEvent event) {
        if (this.getSelected() != null && idMaterialController.getSelected() == null) {
            idMaterialController.setSelected(this.getSelected().getIdMaterial());
        }
    }

    /**
     * Sets the "selected" attribute of the Orden controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdOrden(ActionEvent event) {
        if (this.getSelected() != null && idOrdenController.getSelected() == null) {
            idOrdenController.setSelected(this.getSelected().getIdOrden());
        }
    }

    /**
     * Sets the "selected" attribute of the Tipo controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipo(ActionEvent event) {
        if (this.getSelected() != null && idTipoController.getSelected() == null) {
            idTipoController.setSelected(this.getSelected().getIdTipo());
        }
    }
}
