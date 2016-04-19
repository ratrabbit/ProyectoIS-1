package mapeo;

import java.util.HashSet;
import java.util.Set;


public class NombreUsuario  implements java.io.Serializable {


     private int idNombreUsuario;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private Set<DatosUsuario> datosUsuarios = new HashSet<DatosUsuario>(0);

    public NombreUsuario() {
    }

	
    public NombreUsuario(int idNombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.idNombreUsuario = idNombreUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    public NombreUsuario(int idNombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, Set<DatosUsuario> datosUsuarios) {
       this.idNombreUsuario = idNombreUsuario;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.datosUsuarios = datosUsuarios;
    }
   
    public int getIdNombreUsuario() {
        return this.idNombreUsuario;
    }
    
    public void setIdNombreUsuario(int idNombreUsuario) {
        this.idNombreUsuario = idNombreUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public Set<DatosUsuario> getDatosUsuarios() {
        return this.datosUsuarios;
    }
    
    public void setDatosUsuarios(Set<DatosUsuario> datosUsuarios) {
        this.datosUsuarios = datosUsuarios;
    }




}


