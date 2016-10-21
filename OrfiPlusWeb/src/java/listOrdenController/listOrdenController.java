/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listOrdenController;

import com.orfi.Facades.OrdenFacade;
import com.orfi.entity.Orden;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author USUARIO
 */
@Named(value = "listOrdenController")
@RequestScoped
public class listOrdenController implements Serializable {
    @EJB
    private OrdenFacade ordenFacade;
    
     public List<Orden> verOrdenes() {
        List<Orden> ord = ordenFacade.consultarOrden();
        return ord;
    }
    
}
