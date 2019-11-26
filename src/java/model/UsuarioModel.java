/* 
 * Autor:  Pedro Eliezer García Ramírez
 * Email: pedro.e.garcia.ramirez@gmail.com
 * Creación: 26/11/2019
 *
 */
package model;

import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuarioModel implements IUsuarioModel {

    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public void CrearUsuario(Usuario usuario) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void ActualizarUsuario(Usuario usuario) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void EliminarRegistro(Usuario usuario) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        }
    }
    @Override
    public Usuario ObtenerRegistro(int idusuario) {

       Usuario usuario = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            usuario = (Usuario) session.get(Usuario.class, idusuario);
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return usuario;    
    }

    @Override
    public List<Usuario> ObtenerRegistros() {
        ArrayList<Usuario> lista = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            lista = (ArrayList<Usuario>) session.createQuery("FROM usuario").list();
            for (Usuario u : lista) {
             //   System.out.println("Nombre: " + u.getNombre());
            }
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
          //  System.out.println("Error de actualización del Jugador");
            System.out.println(e);
        }
        return lista;
    }



}
