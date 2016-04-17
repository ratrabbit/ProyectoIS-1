package mapeo;
// Generated 14/04/2016 09:44:17 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String nombreUsuario;
     private String contraseniaUsuario;
     private Set<DatosUsuario> datosUsuarios = new HashSet<DatosUsuario>(0);
     private Set<Publicacion> publicacions = new HashSet<Publicacion>(0);

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseniaUsuarioatosUsuarios, Set<Publicacion> publicacions) {
       this.idUsuario = idUsuario;
       this.nombreUsuario = nombreUsuario;
       this.contraseniaUsuario = contraseniaUsuario;
       this.datosUsuarios = datosUsuarios;
       this.publicacions = publicacions;
    }
    public Usuario(String nombreUsuario, String contraseniaUsuario) {
       this.nombreUsuario = nombreUsuario;
       this.contraseniaUsuario = contraseniaUsuario;
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




}

