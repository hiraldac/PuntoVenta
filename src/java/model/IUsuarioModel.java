/* 
 * Autor:  Pedro Eliezer García Ramírez
 * Email: pedro.e.garcia.ramirez@gmail.com
 * Creación: 26/11/2019
 *
 */
package model;

import entity.Usuario;
import java.util.List;


public interface IUsuarioModel {

    public void CrearUsuario(Usuario usuario);

    public void ActualizarUsuario(Usuario usuario);

    public void EliminarRegistro(Usuario usuario);

    public Usuario ObtenerRegistro(int idusuario);

    public List<Usuario> ObtenerRegistros();
}
