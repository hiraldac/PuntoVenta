/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author labtw04
 */
import entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
import service.IUsuarioService;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioController implements Serializable {



    @ManagedProperty("#{usuarioService}")
    private IUsuarioService service;
    private List<Usuario> listaLiga;

    private Usuario usr;

    @PostConstruct
    public void init() {
        usr = new Usuario();
        this.listaLiga = service.ObtenerRegistros();
    }

    public void setService(IUsuarioService service) {
        this.service = service;
    }

    public void crearRegistro() {
        System.out.println("---------------");
        this.service.CrearUsuario(usr);
    }

    public void eliminarRegistro(Usuario usr) {
        service.EliminarRegistro(usr);
        FacesMessage mensaje = new FacesMessage("Registro eliminado exitósamente",
                usr.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        this.listaLiga= service.ObtenerRegistros();
    }
/*
    public void onRowEdit(RowEditEvent event) {
        Liga ligaSelected = ((Liga) event.getObject());
        service.actualizararRegistro(ligaSelected);
        FacesMessage mensaje = new FacesMessage("Registro editado exitósamente",
                ligaSelected.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Actualización cancelada",
                ((Liga) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
*/
    public List<Usuario> getListaLiga() {
        return listaLiga;
    }

    public void setListaLiga(List<Usuario> listaLiga) {
        this.listaLiga = listaLiga;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

}
