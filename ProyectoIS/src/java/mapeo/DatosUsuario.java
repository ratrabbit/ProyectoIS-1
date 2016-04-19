package mapeo;

import java.util.HashSet;
import java.util.Set;

public class DatosUsuario  implements java.io.Serializable {


     private int idDatosUsuario;
     private NombreUsuario nombreUsuario;
     private Usuario usuario;
     private String email;
     private String imagenUsuario;
     private String telefono;
     private int edad;
     private String sexo;
     private Set<DireccionUsuario> direccionUsuarios = new HashSet<DireccionUsuario>(0);

    public DatosUsuario() {
    }

	
    public DatosUsuario(int idDatosUsuario, NombreUsuario nombreUsuario, Usuario usuario, String imagenUsuario, String telefono, int edad) {
        this.idDatosUsuario = idDatosUsuario;
        this.nombreUsuario = nombreUsuario;
        this.usuario = usuario;
        this.imagenUsuario = imagenUsuario;
        this.telefono = telefono;
        this.edad = edad;
    }
    public DatosUsuario(int idDatosUsuario, NombreUsuario nombreUsuario, Usuario usuario, String email, String imagenUsuario, String telefono, int edad, String sexo, Set<DireccionUsuario> direccionUsuarios) {
       this.idDatosUsuario = idDatosUsuario;
       this.nombreUsuario = nombreUsuario;
       this.usuario = usuario;
       this.email = email;
       this.imagenUsuario = imagenUsuario;
       this.telefono = telefono;
       this.edad = edad;
       this.sexo = sexo;
       this.direccionUsuarios = direccionUsuarios;
    }

    public DatosUsuario(int idDatosUsuario, Usuario nombreUsuario, String email, String imagenUsuario, String telefono, int edad, String sexo, Set<DireccionUsuario> direccionUsuarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public int getIdDatosUsuario() {
        return this.idDatosUsuario;
    }
    
    public void setIdDatosUsuario(int idDatosUsuario) {
        this.idDatosUsuario = idDatosUsuario;
    }
    public NombreUsuario getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(NombreUsuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImagenUsuario() {
        return this.imagenUsuario;
    }
    
    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Set<DireccionUsuario> getDireccionUsuarios() {
        return this.direccionUsuarios;
    }
    
    public void setDireccionUsuarios(Set<DireccionUsuario> direccionUsuarios) {
        this.direccionUsuarios = direccionUsuarios;
    }




}


