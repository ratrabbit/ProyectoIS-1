package mapeo;


public class DatosUsuario  implements java.io.Serializable {


     private int idDatosUsuario;
     private Estado estado;
     private Usuario usuario;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String email;
     private String calle;
     private String numero;
     private String interior;
     private String colonia;
     private String ciudad;
     private String imagenUsuario;
     private String telefono;
     private int edad;
     private String sexo;

    public DatosUsuario() {
    }

	
    public DatosUsuario(int idDatosUsuario, Estado estado, Usuario usuario, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, String numero, String colonia, String ciudad, String imagenUsuario, String telefono, int edad) {
        this.idDatosUsuario = idDatosUsuario;
        this.estado = estado;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.imagenUsuario = imagenUsuario;
        this.telefono = telefono;
        this.edad = edad;
    }
    public DatosUsuario(int idDatosUsuario, Estado estado, Usuario usuario, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String calle, String numero, String interior, String colonia, String ciudad, String imagenUsuario, String telefono, int edad, String sexo) {
       this.idDatosUsuario = idDatosUsuario;
       this.estado = estado;
       this.usuario = usuario;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.email = email;
       this.calle = calle;
       this.numero = numero;
       this.interior = interior;
       this.colonia = colonia;
       this.ciudad = ciudad;
       this.imagenUsuario = imagenUsuario;
       this.telefono = telefono;
       this.edad = edad;
       this.sexo = sexo;
    }
    public DatosUsuario(int idDatosUsuario, Estado estado, Usuario usuario, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String imagenUsuario, String telefono, int edad, String sexo) {
       this.idDatosUsuario = idDatosUsuario;
       if(estado!=null)
        this.estado = estado;
       else{
        this.estado=new Estado(100, "Ciudad de Mexico");
       }
       this.usuario = usuario;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.email = email;
       this.calle = " ";
       this.numero = " ";
       this.interior = " ";
       this.colonia = " ";
       this.ciudad = " ";
       
       if(imagenUsuario!=null)
        this.imagenUsuario = imagenUsuario;
       else
           this.imagenUsuario = " ";
       if(telefono!=null)
        this.telefono = telefono;
       else
           this.telefono = " ";
       this.edad = edad;
       this.sexo = sexo;
    }
    public DatosUsuario(int idDatosUsuario, String email, String telefono, int edad, String sexo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DatosUsuario(int idDatosUsuario, Usuario nombreUsuario, String email, String imagenUsuario, String telefono, int edad, String sexo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public int getIdDatosUsuario() {
        return this.idDatosUsuario;
    }
    
    public void setIdDatosUsuario(int idDatosUsuario) {
        this.idDatosUsuario = idDatosUsuario;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getInterior() {
        return this.interior;
    }
    
    public void setInterior(String interior) {
        this.interior = interior;
    }
    public String getColonia() {
        return this.colonia;
    }
    
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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




}


