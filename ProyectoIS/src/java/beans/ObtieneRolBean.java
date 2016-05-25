/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jonathan
 */
@Named(value = "obtieneRolBean")
@SessionScoped
@ManagedBean
@RequestScoped

public class ObtieneRolBean implements Serializable {

    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;
    private String rol;

    /**
     * Creates a new instance of RolBean
     */
    public ObtieneRolBean() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("rolEscogido") != null) {
            rol = httpServletRequest.getSession().getAttribute("rolEscogido").toString();
        }
        System.out.println("Tu rol es : " + rol);
    }

    public void dameRol() {
        setRol(rol);
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

}
