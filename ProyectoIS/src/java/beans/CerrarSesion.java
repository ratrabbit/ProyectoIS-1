package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Managed Bean para manejar el cierre de sesión de la aplicación.
 */
@ManagedBean
@RequestScoped


public class CerrarSesion {
    
    private String usuario; // Representa el nombre de usuario.
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista.

    /**
     * Constructor para inicializar los valores de faceContext y
     * httpServletRequest, además de la sesión de usuario.
     */
    public CerrarSesion() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            usuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }

    /**
     * Método encargado de cerrar la sesión de la aplicación.
     *
     * @return El nombre de la vista que va a responder.
     */
    public String cerrarSession() {
        imprime();
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, message);
        return "index";
    }
    
    private void imprime(){
        System.out.println(getNombreUsuario());
    }

    /**
     * Regresa el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usuario El nombre de usuario a establecer.
     */
    public void setNombreUsuario(String usuario) {
        this.usuario = usuario;
    }

}

