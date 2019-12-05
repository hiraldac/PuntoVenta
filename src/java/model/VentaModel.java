/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 *
 */
package model;

import entity.Detalle;
import entity.DetalleId;
import entity.Producto;
import entity.Venta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VentaModel implements IVentaModel{

    private SessionFactory sessionFactory;
    private Session session;
    
    @Override
    public void CrearVenta(Venta venta) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(venta);
            session.getTransaction().commit();
            session.close();
            
            session = sessionFactory.openSession();
            session.beginTransaction();
            Iterator it = venta.getDetalles().iterator();
            while(it.hasNext()){
              Detalle d = (Detalle) it.next();
              System.out.println("Clave: " + d.getProducto().getNombre() + " -> Valor: " + d.getProducto().getPrecio());
              session.save(d);
            }
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ActualizarVenta(Venta venta) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(venta);
            Iterator it = venta.getDetalles().iterator();
            while(it.hasNext()){
              Detalle d = (Detalle) it.next();
              System.out.println("Clave: " + d.getProducto().getNombre() + " -> Valor: " + d.getProducto().getPrecio());
              session.update(d);
            }
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void EliminarVenta(Venta venta) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(venta);
            Iterator it = venta.getDetalles().iterator();
            while(it.hasNext()){
              Detalle d = (Detalle) it.next();
              System.out.println("Clave: " + d.getProducto().getNombre() + " -> Valor: " + d.getProducto().getPrecio());
              session.delete(d);
            }
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Venta ObtenerRegistro(long idventa) {
        
        Venta venta = null;
        ArrayList<Detalle> lista = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            venta = (Venta) session.get(Venta.class, idventa);
            session.close();
            session = sessionFactory.openSession();
            lista = (ArrayList<Detalle>) session.createQuery("FROM Detalle WHERE ventaid='"+idventa+"'").list();
            for (Detalle d : lista) {
                DetalleId id= new DetalleId();
                id.setVentaid(idventa);
                //id.setProductoid(d.getProducto().getIdproducto());
                d.setId(id);
                venta.getDetalles().add(d);
            }
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return venta;
    }

    @Override
    public List<Venta> ObtenerRegistros() {
        ArrayList<Venta> lista = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            lista = (ArrayList<Venta>) session.createQuery("FROM venta").list();
            for (Venta v : lista) {
                System.out.println("Detalle: " + v.getDetalles());
            }
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    /*
    public static void main(String[] args) {
        VentaModel vm=new VentaModel();
        Venta venta=new Venta();
        //venta.setFecha(new Date());
        
        Producto p=new ProductoModel().ObtenerProducto("1234");
        Producto p2=new ProductoModel().ObtenerProducto("1233");
        BigDecimal bigDecimal=p.getPrecio().add(p2.getPrecio());
        venta.setTotal(bigDecimal);
        venta.setUsuarioid(1);
        
        Detalle d=new Detalle();
        d.setProducto(p);
        d.setCantidad(1);
        d.setVenta(venta);
        DetalleId id=new DetalleId();
        id.setProductoid(p.getIdproducto());
        id.setVentaid(venta.getIdventa());
        d.setId(id);

        Detalle d2=new Detalle();
        d2.setProducto(p2);
        d2.setCantidad(1);
        d.setVenta(venta);
        DetalleId id2=new DetalleId();
        id2.setProductoid(p2.getIdproducto());
        id2.setVentaid(venta.getIdventa());
        
        d2.setId(id2);
        
        venta.getDetalles().add(d);
        venta.getDetalles().add(d2);
        
        System.out.println(((Detalle)venta.getDetalles().toArray()[0]).getProducto().getNombre());
        System.out.println(venta.getIdventa()+"---------------"+venta.hashCode()+"---------------"+id.hashCode());
        vm.CrearVenta(venta);
//        venta = vm.ObtenerRegistro(4);
//        Iterator it = venta.getDetalles().iterator();
//            while(it.hasNext()){
//              Detalle d = (Detalle) it.next();
//              System.out.println("Clave: " + d.getProducto().getNombre() + " -> Valor: " + d.getProducto().getPrecio());
//        }
                   
    }*/
}
