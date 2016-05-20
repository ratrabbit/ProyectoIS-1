package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import DAO.PublicacionDAO;
import DAO.PublicarDAO;
import DAO.RegistroDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mapeo.Publicacion;
import mapeo.Usuario;

@Named(value = "publicarBean")
@SessionScoped
@ManagedBean
@RequestScoped

public class PublicarBean implements Serializable {

    private int idPublicacion;
    private String nombreProducto;
    private String descripcion;
    private String imagenes;
    private int precioActual;
    private int precioInical;
    private Usuario usuario;
    private FacesMessage message;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    DatosUsuarioBean perfil = new DatosUsuarioBean();



    /**
     * Creates a new instance of PublicarBean
     */
    public PublicarBean() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
    }

    public String addPublicacion(){
        try{
        Publicacion publicacion = new Publicacion(getIdPublicacion(), getUsuario(), getNombreProducto(),getDescripcion(),getImagenes(),getPrecioInical());
        PublicarDAO publicarDAO = new PublicarDAO();
        publicarDAO.addPublicacion(publicacion);
        //perfil.datosUsuario(registro);
            //FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            return "publicado";
        } catch (org.hibernate.exception.ConstraintViolationException e) {     
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro incorrecto, verifica tus campos", null);
            faceContext.addMessage(null, message);
            return "Registro";
        }
        catch(Exception e){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Algo salio mal, intentalo de nuevo", null);
            faceContext.addMessage(null, message);
            return "index";
        }
    }

    
    /**
     * @return the idPublicacion
     */
    public int getIdPublicacion() {
        return idPublicacion;
    }

    /**
     * @param idPublicacion the idPublicacion to set
     */
    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the imagenes
     */
    public String getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * @return the precioActual
     */
    public int getPrecioActual() {
        return precioActual;
    }

    /**
     * @param precioActual the precioActual to set
     */
    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the precioInical
     */
    public int getPrecioInical() {
        return precioInical;
    }

    /**
     * @param precioInical the precioInical to set
     */
    public void setPrecioInical(int precioInical) {
        this.precioInical = precioInical;
    }

}
