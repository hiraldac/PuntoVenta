/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 *
 */
package model;

import entity.Venta;
import java.util.ArrayList;
import java.util.List;
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
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void EliminarVEnta(Venta venta) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(venta);
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
        
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            venta = (Venta) session.get(Venta.class, idventa);
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
            for (Venta u : lista) {
                System.out.println("Detalle: " + u.getDetalles());
            }
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public static void main(String[] args) {
        VentaModel vm=new VentaModel();
        Venta venta=new Venta();
        
    }
    
}
