package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioSeguridadMockLocal;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/Seguridad")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SeguridadService {

    @EJB
    private IServicioSeguridadMockLocal seguridadEjb;

    // GET: Obtener todos los usuarios
    @GET
    @Path("usuarios")
    public List<Usuario> getTodosLosUsuarios() {
        return seguridadEjb.darUsuarios();
    }

    // POST: Crear un nuevo usuario (O login si se prefiere)
    @POST
    @Path("usuarios")
    public Response crearUsuario(Usuario u) {
        seguridadEjb.agregarUsuario(u);
        return Response.status(Response.Status.CREATED).entity(u).build();
    }

    // PUT: Actualizar usuario existente
    @PUT
    @Path("usuarios")
    public Response actualizarUsuario(Usuario u) {
        seguridadEjb.actualizarUsuario(u);
        return Response.ok(u).build();
    }

    // DELETE: Eliminar usuario por su login
    @DELETE
    @Path("usuarios/{login}")
    public Response eliminarUsuario(@PathParam("login") String login) {
        seguridadEjb.eliminarUsuario(login);
        return Response.noContent().build();
    }

    // Método extra: Login (POST para enviar credenciales de forma segura)
    @POST
    @Path("login")
    public Response login(Usuario credenciales) {
        try {
            Usuario u = seguridadEjb.ingresar(credenciales.getLogin(), credenciales.getContraseña());
            return Response.ok(u).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }
}