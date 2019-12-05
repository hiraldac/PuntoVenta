/* 
 * Autor:  Pedro Eliezer García Ramírez
 * Email: pedro.e.garcia.ramirez@gmail.com
 * Creación: 26/11/2019
 *
 */
package model;

import entity.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Usuario ObtenerRegistro(long idusuario) {

        Usuario usuario = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            usuario = (Usuario) session.get(Usuario.class, idusuario);
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    @Override
    public List<Usuario> ObtenerRegistros() {
        ArrayList<Usuario> lista = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            lista = (ArrayList<Usuario>) session.createQuery("FROM Usuario").list();
            for (Usuario u : lista) {
                System.out.println("ID: " + u.getIdusuario());
                System.out.println("Nombre: " + u.getNombre());

            }
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public boolean Consulta(String nombre, String contraseña) throws IOException {
        boolean v = false;
        ArrayList<Usuario> lista = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            lista = (ArrayList<Usuario>) session.createQuery("FROM Usuario").list();
            for (Usuario u : lista) {
                if (u.getNombre().equals(nombre) && u.getContrasena().equals(contraseña)) {
                    v = true;
                    System.out.println("ID: " + u.getNombre());
                    System.out.println("Nombre: " + u.getContrasena());
                }
            }
            session.close();
            sessionFactory.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        if (!v) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrecto!",
                            "Intente de nuevo!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Biebvenido!",
                            "Biebvenido!"));
            String url = "http://localhost:8080/PuntoVenta/faces/pages/producto/ListarProductos.xhtml";

            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        }
        return v;
    }
}
