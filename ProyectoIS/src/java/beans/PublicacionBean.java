package beans;

import DAO.PublicacionDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mapeo.Publicacion;

@ManagedBean
@RequestScoped

public class PublicacionBean implements Serializable {
    
     private int idPublicacion;
     private String nombreProducto;
     private String descripcion;
     private String imagenes;
     private int precioActual;
     
     public  List<Publicacion> getGaleria() {
        PublicacionDAO publicacionDAO = new PublicacionDAO();
        List <Publicacion> galeria = publicacionDAO.getGaleria();
        return galeria;
    }
     
     /**
     * @return the idPublicacion
     */
    public int getidPublicacion() {
        return idPublicacion;
    }

    /**
     * @param idPublicacion the idPublicacion to set
     */
    public void setidPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    /**
     * @return the nombreProducto
     */
    public String getnombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setnombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcion
     */
    public String getdescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     /**
     * @return the imagenes
     */
    public String getimagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setimagenes(String imagenes) {
        this.imagenes = imagenes;
    }
    
     /**
     * @return the precioActual
     */
    public int getprecioActual() {
        return precioActual;
    }

    /**
     * @param precioActual the precioActual to set
     */
    public void setprecioActual(int precioActual) {
        this.precioActual = precioActual;
    }
}
