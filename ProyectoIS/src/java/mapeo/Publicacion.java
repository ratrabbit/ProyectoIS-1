package mapeo;


public class Publicacion  implements java.io.Serializable {


     private int idPublicacion;
     private Usuario usuario;
     private String descripcion;
     private int imagenes;
     private int precioInical;
     private int precioFinal;
     private int precioActual;

    public Publicacion() {
    }

    public Publicacion(int idPublicacion, Usuario usuario, String descripcion, int imagenes, int precioInical, int precioFinal, int precioActual) {
       this.idPublicacion = idPublicacion;
       this.usuario = usuario;
       this.descripcion = descripcion;
       this.imagenes = imagenes;
       this.precioInical = precioInical;
       this.precioFinal = precioFinal;
       this.precioActual = precioActual;
    }
   
    public int getIdPublicacion() {
        return this.idPublicacion;
    }
    
    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getImagenes() {
        return this.imagenes;
    }
    
    public void setImagenes(int imagenes) {
        this.imagenes = imagenes;
    }
    public int getPrecioInical() {
        return this.precioInical;
    }
    
    public void setPrecioInical(int precioInical) {
        this.precioInical = precioInical;
    }
    public int getPrecioFinal() {
        return this.precioFinal;
    }
    
    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }
    public int getPrecioActual() {
        return this.precioActual;
    }
    
    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }




}


