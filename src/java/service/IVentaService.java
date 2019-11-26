/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 *
 */
package service;

import entity.Venta;


public interface IVentaService{
    public void CrearVenta(Venta venta);
    public void ActualizarVenta(Venta venta);
    public void EliminarVEnta(Venta venta);
}
