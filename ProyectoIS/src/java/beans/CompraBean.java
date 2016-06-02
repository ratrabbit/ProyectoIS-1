/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.CompraDAO;
import DAO.RegistroDAO;
import static com.sun.javafx.logging.PulseLogger.addMessage;
import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import mapeo.Compra;
import mapeo.Publicacion;
import mapeo.Usuario;

/**
 *
 * @author adolfo
 */

@Named(value = "compraBean")
@ManagedBean
@RequestScoped
public class CompraBean {
    private int idCompra;
    private Publicacion publicacion;
    private Usuario usuario;
    private String nombrePub;
    private String usuar;
    private String sesionUsuario;
    private Compra compra;
    private FacesMessage message;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
     
    public CompraBean() {
     faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            sesionUsuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
     }
     
    public void compra(){
            RegistroDAO registroDAO = new RegistroDAO();
            Usuario usu = registroDAO.getRegistroUsuarioByID(getSesionUsuario());
            
            CompraDAO ld = new CompraDAO();
            idCompra = ld.maxIndice("compra", "id_compra");
            compra = new Compra(idCompra,getPublicacion(),usu);
            CompraDAO compraDAO = new CompraDAO();
            compraDAO.addCompra(compra);
            
            
    }
    
    
    public int getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public Publicacion getPublicacion() {
        return this.publicacion;
    }
    
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
     /**
     * @return the sesionUsuario
     */
    public String getSesionUsuario() {
        return sesionUsuario;
    }

    /**
     * @param sesionUsuario the sesionUsuario to set
     */
    public void setSesionUsuario(String sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }
    
    public String obtenNombrePub(){
        CompraDAO c = new CompraDAO();
        nombrePub = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        publicacion = c.getPublicacionByNombre(nombrePub);
        this.setPublicacion(publicacion);
        compra();
        return nombrePub; 
    }
    
    public String obtenNombreInfo(){
        CompraDAO c = new CompraDAO();
        usuar = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id2");
        return usuar; 
    }
    
    
}
