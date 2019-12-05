/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 *
 */
package service;

import entity.Venta;


public class VentaService implements IVentaService{
    IVentaService ivs =new VentaService();

    @Override
    public void CrearVenta(Venta venta) {
        ivs.CrearVenta(venta);
    }

    @Override
    public void ActualizarVenta(Venta venta) {
        ivs.ActualizarVenta(venta);
    }

    @Override
    public void EliminarVEnta(Venta venta) {
        ivs.EliminarVEnta(venta);
    }
    
}
