/* 
 * Autor:  Eber Martínez García
 * Email: eber.mtzg.dev@gmail.com
 * Creación: 26/11/2019
 * Modificacion: 26/11/2019
 */
package model;

import entity.Producto;
import java.util.List;

public interface IProductoModel {
    public void CrearProducto(Producto producto);
    public void ActualizarProducto(Producto producto);
    public void EliminarProducto(Producto producto);
    public Producto ObtenerProducto(int idproducto);
    public List<Producto> ObtenerProductos();
}
