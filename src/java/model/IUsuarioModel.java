/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Usuario;
import java.util.List;

/**
 *
 * @author labtw04
 */
public interface IUsuarioModel {
    public void CrearUsuario(Usuario usuario);
    public void ActualizarUsuario(Usuario usuario);
    public void EliminarRegistro(Usuario usuario);
    public Usuario ObtenerRegistro(int usuario);
    public List<Usuario> ObtenerRegistros();
}
