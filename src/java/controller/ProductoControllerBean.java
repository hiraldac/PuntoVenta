/* 
 * Autor:  Eber Martínez García
 * Email: eber.mtzg.dev@gmail.com
 * Creación: 03/12/2019
 * Modificacion: 03/12/2019
 */

package controller;

import entity.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
import service.IProductoService;

@ManagedBean(name = "productoBean")
@ViewScoped
public class ProductoControllerBean implements Serializable{
    @ManagedProperty("#{productoService}")
    private IProductoService service;
    
    private List<Producto> listaProducto;
    
    private Producto producto;
    
    @PostConstruct
    public void init(){
        this.producto=new Producto();
        this.listaProducto=service.ObtenerProductos();
    }
    
    public void setService(IProductoService service){
        this.service=service;
    }
    //CRUD
    public void crearProducto(){
        this.service.CrearProducto(producto);
        FacesMessage mensaje = new FacesMessage("Producto creado exitósamente", producto.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminarProducto(Producto producto){
        this.service.EliminarProducto(producto);
        this.listaProducto = service.ObtenerProductos();
    }
    // Eventos on Row
    public void onRowEdit(RowEditEvent event){
        Producto productoSelected = ((Producto) event.getObject());
        service.ActualizarProducto(productoSelected);
        FacesMessage msg = new FacesMessage("Registro de Producto editado exitósamente",
                productoSelected.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    public void onRowCancel(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Actualización Cancelada",
                ((Producto) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //SET AND GET DE PRODUCTO
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public List<Producto> getListaProducto(){
        return listaProducto;
    }
    
}
