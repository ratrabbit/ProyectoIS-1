package beans;

import DAO.EditarEliminarDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import DAO.PublicacionDAO;
import DAO.PublicarDAO;
import DAO.RegistroDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mapeo.DatosUsuario;
import mapeo.Publicacion;
import mapeo.Usuario;
import org.primefaces.event.FileUploadEvent;

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
    private int precioFinal;
    private Usuario usuario;
    private int idUsuario;
    private String nombreUsuario;
    private String contraseniaUsuario;
    private String contraVieja;
    private int identificadorUsuario;

    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;
    private String sesionUsuario;
    
    private final String destination= "/home/jonathan/Documentos/Ingeniería de Software/ProyectoIS-1/ProyectoIS/web/publicaciones/";
    
    
    /**
     * Creates a new instance of PublicarBean
     */
    public PublicarBean() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            sesionUsuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }

    public void upload (FileUploadEvent event) {
      FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
      FacesContext.getCurrentInstance().addMessage(null, msg);
      // Do what you want with the file
        try {
            PublicacionDAO ld = new PublicacionDAO();
            copyFile(String.valueOf(ld.maxIndice("publicacion", "id_publicacion")), event.getFile().getInputstream());
        } catch (IOException e) {
            FacesMessage msg2 = new FacesMessage("Is NOT Succesful", event.getFile().getFileName() + " is not uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    
    public void copyFile(String fileName, InputStream in) {
       try {
         OutputStream out = new FileOutputStream(new File(destination + fileName+".jpg"));
         int read = 0; 
         byte[] bytes = new byte[1024]; 
         while ((read = in.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
                 this.setImagenes("publicaciones/" + fileName+".jpg");

      in.close();
      out.flush();
      out.close();
      System.out.println("New file created!");
      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
    }   
    
    public void addPublicacion() {
        RegistroDAO registroDAO = new RegistroDAO();
        Usuario usu = registroDAO.getRegistroUsuarioByID(getSesionUsuario());

        Publicacion publicacion = new Publicacion(usu, getNombreProducto(), getDescripcion(), getImagenes(), getPrecioInical());
        PublicarDAO publicarDAO = new PublicarDAO();
        publicarDAO.addPublicacion(publicacion);
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

    /**
     * @return the precioFinal
     */
    public int getPrecioFinal() {
        return precioFinal;
    }

    /**
     * @param precioFinal the precioFinal to set
     */
    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

    /**
     * @return the sesionUsuario
     */
    public String getSesionUsuario() {
        return sesionUsuario;
    }

    /**
     * @param sesionUsuario the sesionUsuario to set
     */
    public void setSesionUsuario(String sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
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
     * @return the contraVieja
     */
    public String getContraVieja() {
        return contraVieja;
    }

    /**
     * @param contraVieja the contraVieja to set
     */
    public void setContraVieja(String contraVieja) {
        this.contraVieja = contraVieja;
    }

    /**
     * @return the identificadorUsuario
     */
    public int getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    /**
     * @param identificadorUsuario the identificadorUsuario to set
     */
    public void setIdentificadorUsuario(int identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }
    
    
    


}
