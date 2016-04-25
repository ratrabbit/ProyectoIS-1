package beans;

import DAO.DatosUsuarioDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import mapeo.DatosUsuario;
import mapeo.Estado;
import mapeo.Usuario;

@Named(value = "datosUsuarioBean")
@SessionScoped
public class DatosUsuarioBean implements Serializable {

    /**
     * Creates a new instance of DatosUsuarioBean
     */
    private int idDatosUsuario;
    private Usuario nombreUsuario;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String email;
    private int direccion;
    private String imagenUsuario;
    private String telefono;
    private int edad;
    private String sexo;
    private Estado estado;
    private int id_usuario;

    public DatosUsuarioBean() {
    }

    public void datosUsuario(Usuario u) {
        DatosUsuario usuario;
        usuario = new DatosUsuario(getIdDatosUsuario(), getEstado(), u, getNombre(), getaPaterno(), getaMaterno(), getEmail(), getImagenUsuario(), getTelefono(), getEdad(), getSexo());
        DatosUsuarioDAO usuarioDAO = new DatosUsuarioDAO();
        usuarioDAO.datosUsuario(usuario);
    }

    /**
     * @return the idDatosUsuario
     */
    public int getIdDatosUsuario() {
        return idDatosUsuario;
    }

    /**
     * @param idDatosUsuario the idDatosUsuario to set
     */
    public void setIdDatosUsuario(int idDatosUsuario) {
        this.idDatosUsuario = idDatosUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the imagenUsuario
     */
    public String getImagenUsuario() {
        return imagenUsuario;
    }

    /**
     * @param imagenUsuario the imagenUsuario to set
     */
    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the edad
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the edad to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
