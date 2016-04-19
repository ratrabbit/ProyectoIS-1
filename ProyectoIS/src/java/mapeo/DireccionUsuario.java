package mapeo;



public class DireccionUsuario  implements java.io.Serializable {


     private int idDireccionUsuario;
     private DatosUsuario datosUsuario;
     private Estado estado;
     private String calle;
     private String numero;
     private String interior;
     private String colonia;
     private String ciudad;

    public DireccionUsuario() {
    }

	
    public DireccionUsuario(int idDireccionUsuario, DatosUsuario datosUsuario, Estado estado, String calle, String numero, String colonia, String ciudad) {
        this.idDireccionUsuario = idDireccionUsuario;
        this.datosUsuario = datosUsuario;
        this.estado = estado;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }
    public DireccionUsuario(int idDireccionUsuario, DatosUsuario datosUsuario, Estado estado, String calle, String numero, String interior, String colonia, String ciudad) {
       this.idDireccionUsuario = idDireccionUsuario;
       this.datosUsuario = datosUsuario;
       this.estado = estado;
       this.calle = calle;
       this.numero = numero;
       this.interior = interior;
       this.colonia = colonia;
       this.ciudad = ciudad;
    }
   
    public int getIdDireccionUsuario() {
        return this.idDireccionUsuario;
    }
    
    public void setIdDireccionUsuario(int idDireccionUsuario) {
        this.idDireccionUsuario = idDireccionUsuario;
    }
    public DatosUsuario getDatosUsuario() {
        return this.datosUsuario;
    }
    
    public void setDatosUsuario(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
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




}


