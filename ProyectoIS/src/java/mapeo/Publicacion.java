package mapeo;
// Generated 19/04/2016 08:52:48 PM by Hibernate Tools 4.3.1

/**
 * Publicacion generated by hbm2java
 */
public class Publicacion implements java.io.Serializable {

    private int idPublicacion;
    private Usuario usuario;
    private String nombreProducto;
    private String descripcion;
    private String imagenes;
    private int precioInical;
    private int precioFinal;
    private int precioActual;

    public Publicacion() {
    }

    public Publicacion(int idPublicacion, Usuario usuario, String nombreProducto, String descripcion, String imagenes, int precioInical, int precioFinal, int precioActual) {
        this.idPublicacion = idPublicacion;
        this.usuario = usuario;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.precioInical = precioInical;
        this.precioFinal = precioFinal;
        this.precioActual = precioActual;

    }

    public Publicacion(Usuario usuario, String nombreProducto, String descripcion, String imagenes, int precioInical) {
        this.usuario = usuario;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.precioInical = precioInical;
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

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenes() {
        return this.imagenes;
    }

    public void setImagenes(String imagenes) {
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
