/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import DAO.DatosUsuarioDAO;
import DAO.RegistroDAO;
import mapeo.DatosUsuario;
import mapeo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author francisco
 */
@Named(value = "datosUsuarioBean")
@SessionScoped
public class DatosUsuarioBean implements Serializable {

    /**
     * Creates a new instance of DatosUsuarioBean
     */
    private int idDatosUsuario;
     private int nombreUsuario;
     private String email;
     private int direccion;
     private byte[] imagenUsuario;
     private String telefono;
     private int edad;

    public DatosUsuarioBean() {
    }
    public void datosUsuario(){
        DatosUsuario usuario = new DatosUsuario(getIdDatosUsuario(),getNombreUsuario(),getEmail(), getDireccion(),getImagenUsuario(), getTelefono(), getEdad());
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
    public int getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(int nombreUsuario) {
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
    public byte[] getImagenUsuario() {
        return imagenUsuario;
    }

    /**
     * @param imagenUsuario the imagenUsuario to set
     */
    public void setImagenUsuario(byte[] imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
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
    
    
}
