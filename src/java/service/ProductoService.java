/* 
 * Autor:  Eber Martínez García
 * Email: eber.mtzg.dev@gmail.com
 * Creación: 28/11/2019
 * Modificacion: 29/11/2019
 */
package service;

import entity.Producto;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.IProductoModel;
import model.ProductoModel;

@ManagedBean(name = "productoService")
@ApplicationScoped
public class ProductoService implements IProductoService{
    
    IProductoModel ips= new ProductoModel();

    @Override
    public void CrearProducto(Producto producto) {
        ips.CrearProducto(producto);
    }

    @Override
    public void ActualizarProducto(Producto producto) {
        ips.ActualizarProducto(producto);
    }

    @Override
    public void EliminarProducto(Producto producto) {
        ips.EliminarProducto(producto);
    }

    @Override
    public Producto ObtenerProducto(String idproducto) {
        return ips.ObtenerProducto(idproducto);
    }

    @Override
    public List<Producto> ObtenerProductos() {
        return ips.ObtenerProductos();
    }
    
    public static void main(String[] args) {
        ProductoService ps = new ProductoService();
        ps.ObtenerProductos();
    }
    
}
