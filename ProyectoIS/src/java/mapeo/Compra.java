package mapeo;

public class Compra  implements java.io.Serializable {


     private int idCompra;
     private Publicacion publicacion;
     private Usuario usuario;

    public Compra() {
    }

    public Compra(int idCompra, Publicacion publicacion, Usuario usuario) {
       this.idCompra = idCompra;
       this.publicacion = publicacion;
       this.usuario = usuario;
    }
   
    public int getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public Publicacion getPublicacion() {
        return this.publicacion;
    }
    
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }




}


