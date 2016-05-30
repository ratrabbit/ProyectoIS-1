package mapeo;


import java.util.HashSet;
import java.util.Set;

public class Publicacion  implements java.io.Serializable {


     private int idPublicacion;
     private Usuario usuario;
     private String nombreProducto;
     private String descripcion;
     private String imagenes;
     private int precioInical;
     private int precioFinal;
     private int precioActual;
     private Set<Compra> compras = new HashSet<Compra>(0);

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
    
    public Publicacion(int idPublicacion, Usuario usuario, String nombreProducto, String descripcion, String imagenes, int precioInical, int precioFinal, int precioActual, Set<Compra> compras) {
       this.idPublicacion = idPublicacion;
       this.usuario = usuario;
       this.nombreProducto = nombreProducto;
       this.descripcion = descripcion;
       this.imagenes = imagenes;
       this.precioInical = precioInical;
       this.precioFinal = precioFinal;
       this.precioActual = precioActual;
       this.compras = compras;
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
    public Set<Compra> getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return nombreProducto + " " + usuario.getNombreUsuario();

    }


}


