package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.AutenticacionException;
import jakarta.ejb.Local; // O Remote según el archivo
import java.util.List;

@Local
public interface IServicioSeguridadMockLocal {
    public Usuario ingresar(String nombre, String contraseña) throws AutenticacionException;
    
    // Métodos CRUD adicionales
    public List<Usuario> darUsuarios();
    public void agregarUsuario(Usuario u);
    public void eliminarUsuario(String login);
    public void actualizarUsuario(Usuario u);
}