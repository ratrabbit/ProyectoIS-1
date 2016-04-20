package mapeo;


import java.util.HashSet;
import java.util.Set;


public class Estado  implements java.io.Serializable {


     private int idEstado;
     private String estadoEstado;
     private Set<DatosUsuario> datosUsuarios = new HashSet<DatosUsuario>(0);

    public Estado() {
    }

	
    public Estado(int idEstado, String estadoEstado) {
        this.idEstado = idEstado;
        this.estadoEstado = estadoEstado;
    }
    public Estado(int idEstado, String estadoEstado, Set<DatosUsuario> datosUsuarios) {
       this.idEstado = idEstado;
       this.estadoEstado = estadoEstado;
       this.datosUsuarios = datosUsuarios;
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
    public Set<DatosUsuario> getDatosUsuarios() {
        return this.datosUsuarios;
    }
    
    public void setDatosUsuarios(Set<DatosUsuario> datosUsuarios) {
        this.datosUsuarios = datosUsuarios;
    }




}


