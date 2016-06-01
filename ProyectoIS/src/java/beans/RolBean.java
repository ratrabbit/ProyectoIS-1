package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped

public class RolBean implements Serializable {

    private String rolEscogido;
    private String nombreUsuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;

    /**
     * Creates a new instance of RolBean
     */
    public RolBean() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            nombreUsuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }

    public String rolEscogido() {
        try{
        //httpServletRequest.getSession().removeAttribute("rolEscogido");
        if (rolEscogido != null) {
            if (rolEscogido.equals("Remitente")) {
                httpServletRequest.getSession().setAttribute("rolEscogido", rolEscogido);
                return "InicioRemitente";
            } else if (rolEscogido.equals("Transportador")) {
                httpServletRequest.getSession().setAttribute("rolEscogido", rolEscogido);
                return "InicioTransportador";
            }
        }
        return "Rol";
        } catch (Exception e){
               return "Rol";
        }
    }

    /**
     * @return the rolEscogido
     */
    public String getRolEscogido() {
        return rolEscogido;
    }

    /**
     * @param rolEscogido the rolEscogido to set
     */
    public void setRolEscogido(String rolEscogido) {
        this.rolEscogido = rolEscogido;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
