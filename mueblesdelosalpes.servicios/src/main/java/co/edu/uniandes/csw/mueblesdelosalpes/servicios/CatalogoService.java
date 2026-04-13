package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioCatalogoMockLocal;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces; // Corregido: Import de Jakarta, no de java.enterprise
import jakarta.ws.rs.core.MediaType; // Corregido: Import de JAX-RS, no de java.awt
import java.util.List;

@Path("/Catalogo")
// SE ELIMINÓ EL @EJB DE AQUÍ (Nivel de clase) para evitar el error "Invalid TYPE-level @EJB"
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CatalogoService {
 
    /**
     * Referencia al Ejb del catalogo encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioCatalogoMockLocal catalogoEjb;
   
    /**
     * Servicio que ofrece una lista JSON con el catálogo de Muebles.
     * @return la lista JSON con los muebles.
     */
    @GET
    @Path("muebles/")
    public List<Mueble> getTodosLosMuebles() {
        return catalogoEjb.darMuebles();
    }
}