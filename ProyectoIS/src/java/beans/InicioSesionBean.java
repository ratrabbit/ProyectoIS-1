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


@Named(value = "inicioSesionBean")
@SessionScoped
public class InicioSesionBean implements Serializable {
    private int idUsuario;
    private String nombreUsuario;
    private String contraseniaUsuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;
    private InicioSesionDAO dao;

    public InicioSesionBean() {faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
        dao = new InicioSesionDAO();
    }

    public String inicioSesionBean() {
        mapeo.Usuario usuario;
        usuario = dao.getLoginPorNombreUsuario(getNombreUsuario());
        if (usuario != null) {
            if (getContraseniaUsuario().equals(usuario.getContraseniaUsuario())) {
                httpServletRequest.getSession().setAttribute("sessionUsuario", nombreUsuario);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El acceso fue correcto", null);
                faceContext.addMessage(null, message);
                return "bienvenido";
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña invalido", null);
                faceContext.addMessage(null, message);
                return "inicioSesion";
            }
        }
        return "bienvenido";
    }
    
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContraseniaUsuario() {
        return this.contraseniaUsuario;
    }
    
    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }   
}