/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import DAO.PublicacionesDAO;
import mapeo.GaleriaPublicacion;

/**
 *
 * @author adolfo
 */
@Named(value = "publicacionBean")
@SessionScoped
public class PublicacionesBean implements Serializable {

    private int idGaleria;
    private byte[] urlImagen;
    private String varcharoImagen;

    public void getGaleria() {
        PublicacionesDAO publicacionesDAO = new PublicacionesDAO();
        List<GaleriaPublicacion> galeria = publicacionesDAO.getGaleria();
        if (galeria != null) {
            for (GaleriaPublicacion product : galeria) {
                setIdGaleria(product.getIdGaleria());
                setUrlImagen(product.getUrlImagen());
                setVarcharoImagen(product.getVarcharoImagen());
            }
        } else {
            System.out.println("No existen publicaciones");
        }
    }

    /**
     * @return the idGaleria
     */
    public int getIdGaleria() {
        return idGaleria;
    }

    /**
     * @param idGaleria the idGaleria to set
     */
    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    /**
     * @return the varcharoImagen
     */
    public String getVarcharoImagen() {
        return varcharoImagen;
    }

    /**
     * @param varcharoImagen the varcharoImagen to set
     */
    public void setVarcharoImagen(String varcharoImagen) {
        this.varcharoImagen = varcharoImagen;
    }

    /**
     * @return the urlImagen
     */
    public byte[] getUrlImagen() {
        return urlImagen;
    }

    /**
     * @param urlImagen the urlImagen to set
     */
    public void setUrlImagen(byte[] urlImagen) {
        this.urlImagen = urlImagen;
    }

}
