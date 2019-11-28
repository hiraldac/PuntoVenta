/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 *
 */
package service;

import entity.Venta;
import java.util.List;


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

    @Override
    public Venta ObtenerRegistro(long idventa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> ObtenerRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
