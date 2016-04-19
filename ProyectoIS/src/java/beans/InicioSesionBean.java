/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.InicioSesionDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
@Named(value = "inicioSesionBean")
//@SessionScoped
public class InicioSesionBean implements Serializable {
    private String nombreUsuario;
    private String contraseniaUser;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;
    private InicioSesionDAO dao;

    public InicioSesionBean() {faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
        dao = new InicioSesionDAO();
    }

    public String inicioSesionBean() {
        mapeo.Usuario usuario = dao.getLoginPorNombreUsuario(getNombreUsuario());
        System.out.println(nombreUsuario);
        System.out.println(contraseniaUser);
        if (usuario != null) {
            if (getContraseniaUser().equals(usuario.getContraseniaUsuario())) {
                httpServletRequest.getSession().setAttribute("sessionUsuario", nombreUsuario);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El acceso fue correcto", null);
                faceContext.addMessage(null, message);
                System.out.println("null");
                return "bienvenida";
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña invalido", null);
                faceContext.addMessage(null, message);
                System.out.println("null2");
                return "inicioSesion";
            }
        }
        return "bienvenido";
    }
    
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContraseniaUser() {
        return this.contraseniaUser;
    }
    
    public void setContraseniaUser(String contraseniaUsuario) {
        this.contraseniaUser = contraseniaUsuario;
    }   
}