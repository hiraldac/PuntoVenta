/* 
 * Autor:  Eber Martínez García
 * Email: eber.mtzg.dev@gmail.com
 * Creación: 28/11/2019
 * Modificacion: 28/11/2019
 */
package service;

import entity.Producto;
import java.util.List;

public interface IProductoService {
    public void CrearProducto(Producto producto);

    public void ActualizarProducto(Producto producto);

    public void EliminarProducto(Producto producto);

    public Producto ObtenerProducto(Producto producto);

    public List<Producto> ObtenerProductos();
}
