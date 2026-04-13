/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioCarritoMockRemote;
import jakarta.ejb.EJB;
import java.util.List;


public class CarroComprasService {
 
    /**
     * Referencia al Ejb de carritos encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioCarritoMockRemote carroEjb;
    /**
     * Servicio que recibe un objeto JSON con un mueble que se desea agregar al carrito de compras. Este servicio es el que se va a probar en 
     * JMeter. Ejecución sin problemas hasta los 5000 usuarios en 10 segundos.)
     *
     * @param mb Mueble en formato JSON, que automáticamente se parsea a un objeto Mueble por el API REST.
     */
   
 
    public List<Mueble> agregarMuebles(List<Mueble> mb) {
        for (Mueble mueble : mb) {
            carroEjb.agregarItem(mueble);
        }
        
        return mb;
    }
    
    public void eliminarMuebles(List<Mueble> mb) {
        for (Mueble mueble : mb) {
            carroEjb.removerItem(mueble, true);
        }
    }
 
    /**
     * Servicio que ofrece una lista JSON con los elementos que estan actualmente en el carrito.
     * @return la lista JSON con los muebles actuales del carrito.
  
     */
    
    public List<Mueble> getTodosLosMuebles() {
        return carroEjb.getInventario();
 
    }
 
}
