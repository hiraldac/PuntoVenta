/* 
 * Autor:  Eber Martínez García
 * Email: eber.mtzg.dev@gmail.com
 * Creación: 28/11/2019
 * Modificacion: 29/11/2019
 */
package service;

import entity.Producto;
import java.util.List;

public class ProductoService implements IProductoService{
    
    IProductoService ips= new ProductoService();

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
    
}
