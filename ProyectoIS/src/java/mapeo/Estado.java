package mapeo;
// Generated 14/04/2016 09:44:17 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado  implements java.io.Serializable {


     private int idEstado;
     private String estadoEstado;
     private Set<DireccionUsuario> direccionUsuarios = new HashSet<DireccionUsuario>(0);

    public Estado() {
    }

	
    public Estado(int idEstado, String estadoEstado) {
        this.idEstado = idEstado;
        this.estadoEstado = estadoEstado;
    }
    public Estado(int idEstado, String estadoEstado, Set<DireccionUsuario> direccionUsuarios) {
       this.idEstado = idEstado;
       this.estadoEstado = estadoEstado;
       this.direccionUsuarios = direccionUsuarios;
    }
   
    public int getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public String getEstadoEstado() {
        return this.estadoEstado;
    }
    
    public void setEstadoEstado(String estadoEstado) {
        this.estadoEstado = estadoEstado;
    }
    public Set<DireccionUsuario> getDireccionUsuarios() {
        return this.direccionUsuarios;
    }
    
    public void setDireccionUsuarios(Set<DireccionUsuario> direccionUsuarios) {
        this.direccionUsuarios = direccionUsuarios;
    }




}


