/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import DAO.DatosUsuarioDAO;
import mapeo.DatosUsuario;
import mapeo.DireccionUsuario;
import mapeo.Usuario;

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
    private Usuario nombreUsuario;
    private String email;
    private int direccion;
    private byte[] imagenUsuario;
    private String telefono;
    private int edad;
    private String sexo;
    private Set<DireccionUsuario> direccionUsuarios = new HashSet<>(0);

    public DatosUsuarioBean() {
    }

    public void datosUsuario() {
        DatosUsuario usuario;
        usuario = new DatosUsuario(getIdDatosUsuario(), getNombreUsuario(), getEmail(), getImagenUsuario(), getTelefono(), getEdad(), getSexo(), getDireccionUsuarios());
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

    public Set<DireccionUsuario> getDireccionUsuarios() {
        return this.direccionUsuarios;
    }

    public void setDireccionUsuarios(Set<DireccionUsuario> direccionUsuarios) {
        this.direccionUsuarios = direccionUsuarios;
    }

}
