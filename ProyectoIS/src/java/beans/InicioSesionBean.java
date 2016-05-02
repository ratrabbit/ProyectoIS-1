package beans;

import DAO.InicioSesionDAO;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.inject.Named;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
@Named(value = "inicioSesionBean")

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
        if (usuario != null) {
            if (getContraseniaUser().equals(usuario.getContraseniaUsuario())) {
                httpServletRequest.getSession().setAttribute("sessionUsuario", nombreUsuario);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El acceso fue correcto", null);
                faceContext.addMessage(null, message);
                return "inicioCorrecto";
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña invalido", null);
                faceContext.addMessage(null, message);
                return "InicioSesion";
            }
        }
        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
        faceContext.addMessage(null, message);
        return "InicioSesion";
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