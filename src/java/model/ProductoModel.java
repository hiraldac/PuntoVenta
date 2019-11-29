/* 
 * Autor:  Eber Martínez García
 * Email: eber.mtzg.dev@gmail.com
 * Creación: 26/11/2019
 * Modificacion: 26/11/2019
 */
package model;

import entity.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductoModel implements IProductoModel{
    
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public void CrearProducto(Producto producto) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void ActualizarProducto(Producto producto) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void EliminarProducto(Producto producto) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public Producto ObtenerProducto(int idproducto) {
        Producto producto = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            producto = (Producto) session.get(Producto.class, idproducto);
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return producto; 
    }

    @Override
    public List<Producto> ObtenerProductos() {
        ArrayList<Producto> listaproducto = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            listaproducto = (ArrayList<Producto>) session.createQuery("FROM usuario").list();
            for (Producto p : listaproducto) {
                //System.out.println("Nombre: " + u.getNombre());
             
            }
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {        
            System.out.println(e);
        }
        return listaproducto;
    }
    
}
