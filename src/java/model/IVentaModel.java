/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 *
 */
package model;

import entity.Venta;
import java.util.List;

public interface IVentaModel{
    public void CrearVenta(Venta venta);
    public void ActualizarVenta(Venta venta);
    public void EliminarVEnta(Venta venta);
    public Venta ObtenerRegistro(long idventa);
    public List<Venta> ObtenerRegistros();
}
