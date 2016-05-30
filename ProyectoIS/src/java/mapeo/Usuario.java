package mapeo;

import mapeo.Compra;
import java.util.HashSet;
import java.util.Set;

public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String nombreUsuario;
     private String contraseniaUsuario;
     private Set<DatosUsuario> datosUsuarios = new HashSet<DatosUsuario>(0);
     private Set<Publicacion> publicacions = new HashSet<Publicacion>(0);
     private Set<Compra> compras = new HashSet<Compra>(0);

    public Usuario() {
    }

	
    public Usuario(int idUsuario, String nombreUsuario, String contraseniaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
    }
    public Usuario(int idUsuario, String nombreUsuario, String contraseniaUsuario, Set<DatosUsuario> datosUsuarios, Set<Publicacion> publicacions, Set<Compra> compras) {
       this.idUsuario = idUsuario;
       this.nombreUsuario = nombreUsuario;
       this.contraseniaUsuario = contraseniaUsuario;
       this.datosUsuarios = datosUsuarios;
       this.publicacions = publicacions;
       this.compras = compras;
    }

    public Usuario(String nombreUsuario, String contraseniaUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContraseniaUsuario() {
        return this.contraseniaUsuario;
    }
    
    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }
    public Set<DatosUsuario> getDatosUsuarios() {
        return this.datosUsuarios;
    }
    
    public void setDatosUsuarios(Set<DatosUsuario> datosUsuarios) {
        this.datosUsuarios = datosUsuarios;
    }
    public Set<Publicacion> getPublicacions() {
        return this.publicacions;
    }
    
    public void setPublicacions(Set<Publicacion> publicacions) {
        this.publicacions = publicacions;
    }
    public Set<Compra> getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }




}


