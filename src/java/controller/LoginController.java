/* 
 * Autor:  Pedro Eliezer García Ramírez
 * Email: pedro.e.garcia.ramirez@gmail.com
 * Creación: 26/11/2019
 *
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.UsuarioModel;

@ManagedBean(name = "loginBean")
@SessionScoped
 
public class LoginController implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String uname;
    private String password;
 
     
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public void loginProject() throws IOException {
        System.out.println("nombre--"+uname);
        System.out.println("contraseña---"+password);
        UsuarioModel um= new UsuarioModel();
        um.Consulta(uname,password);
        
    }

}