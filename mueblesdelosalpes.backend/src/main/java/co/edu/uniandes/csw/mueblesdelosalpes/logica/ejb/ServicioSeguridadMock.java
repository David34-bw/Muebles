package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.AutenticacionException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioSeguridadMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioSeguridadMockRemote;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ServicioSeguridadMock implements IServicioSeguridadMockLocal, IServicioSeguridadMockRemote {

    @EJB
    private IServicioPersistenciaMockLocal persistencia;

    @Override
    public Usuario ingresar(String nombre, String contraseña) throws AutenticacionException {
        Usuario u = (Usuario) persistencia.findById(Usuario.class, nombre);
        if (u != null && u.getContraseña().equals(contraseña)) {
            return u;
        }
        throw new AutenticacionException("Credenciales inválidas.");
    }

    @Override
    public List<Usuario> darUsuarios() {
        return persistencia.findAll(Usuario.class);
    }

    @Override
    public void agregarUsuario(Usuario u) {
        try {
            persistencia.create(u);
        } catch (Exception e) {
            // Manejar excepción de creación
        }
    }

    @Override
    public void eliminarUsuario(String login) {
        Usuario u = (Usuario) persistencia.findById(Usuario.class, login);
        if (u != null) {
            try {
                persistencia.delete(u);
            } catch (Exception e) { }
        }
    }

    @Override
    public void actualizarUsuario(Usuario u) {
        persistencia.update(u);
    }
}