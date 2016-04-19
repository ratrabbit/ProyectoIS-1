package beans;

import DAO.DatosUsuarioDAO;
import DAO.RegistroDAO;
import mapeo.DatosUsuario;
import mapeo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 *
 * @author francisco
 */
@Named(value = "registroBean")
@SessionScoped
public class RegistroBean implements Serializable {

    private int idUsuario;
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String contraseniaUsuario;
    private int idDatosUsuario;
    private int idnombreUsuario;
    private String email;
    private int direccion;
    private byte[] imagenUsuario;
    private String telefono;
    private int edad;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;
    
    public void addRegistro(){
        try{
        Usuario registro = new Usuario(getNombreUsuario(),getContraseniaUsuario());
        RegistroDAO registroDAO = new RegistroDAO();
        registroDAO.addRegistro(registro);
        if(!registro.getNombreUsuario().trim().equals("") &&  !registro.getContraseniaUsuario().trim().equals("")){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro se realizo de manera exitosa", null);
            faceContext.addMessage(null, message);
        }
        else{
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acceso incorrecto, verifica tus campos", null);
            faceContext.addMessage(null, message);
        }
        //FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }catch(Exception e){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso incorrecto, verifica tus campos", null);
            faceContext.addMessage(null, message);
        }
    }
    /**
     * Creates a new instance of RegistroBean
     */
    public RegistroBean() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest)faceContext.getExternalContext().getRequest();
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    /**
     * @return the contraseniaUsuario
     */
    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    /**
     * @param contraseniaUsuario the contraseniaUsuario to set
     */
    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    /**
     * @return the idDatosUsuario
     */
    public int getIdDatosUsuario() {
        return idDatosUsuario;
    }

    /**
     * @param idDatosUsuario the idDatosUsuario to set
     */
    public void setIdDatosUsuario(int idDatosUsuario) {
        this.idDatosUsuario = idDatosUsuario;
    }

    /**
     * @return the idnombreUsuario
     */
    public int getIdnombreUsuario() {
        return idnombreUsuario;
    }

    /**
     * @param idnombreUsuario the idnombreUsuario to set
     */
    public void setIdnombreUsuario(int idnombreUsuario) {
        this.idnombreUsuario = idnombreUsuario;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the imagenUsuario
     */
    public byte[] getImagenUsuario() {
        return imagenUsuario;
    }

    /**
     * @param imagenUsuario the imagenUsuario to set
     */
    public void setImagenUsuario(byte[] imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
