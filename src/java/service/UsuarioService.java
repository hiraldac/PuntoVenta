/* 
 * Autor:  Pedro Eliezer García Ramírez
 * Email: pedro.e.garcia.ramirez@gmail.com
 * Creación: 26/11/2019
 *
 */
package service;

import entity.Usuario;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.IUsuarioModel;
import model.UsuarioModel;

@ManagedBean(name = "usuarioService")
@ApplicationScoped
public class UsuarioService implements IUsuarioService{

    IUsuarioModel um = new UsuarioModel();
    @Override
    public void CrearUsuario(Usuario usuario) {
        um.CrearUsuario(usuario);
    }

    @Override
    public void ActualizarUsuario(Usuario usuario) {
        um.ActualizarUsuario(usuario);
    }

    @Override
    public void EliminarRegistro(Usuario usuario) {
        um.EliminarRegistro(usuario);
    }

    @Override
    public Usuario ObtenerRegistro(long idusuario) {
        return um.ObtenerRegistro(idusuario);
    }

    @Override
    public List<Usuario> ObtenerRegistros() {
        return um.ObtenerRegistros();
    }
    
}
