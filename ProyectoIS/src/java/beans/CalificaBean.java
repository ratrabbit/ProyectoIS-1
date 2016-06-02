/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.CalificaDAO;
import javax.inject.Named;
import java.io.Serializable;
import org.primefaces.event.RateEvent; 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mapeo.Calificacion;
import mapeo.CalificacionId;
import mapeo.Compra;
import mapeo.Usuario;

/**
 *
 * @author francisco
 */
@Named(value = "calificaBean")
@ManagedBean
@RequestScoped
public class CalificaBean implements Serializable {
    private String nombre;
    private String nombreCalif;
    private Usuario busquedaUsuario;
    private double calificacionTotal;
    private CalificacionId id;
    private Usuario usuarioByIdUsuarioCalificado;
    private Usuario usuarioByIdUsuarioCalifica;
    private int idCalif;
    private int calificaion;
    private int idCompra;
    private Compra compra;
    private FacesMessage message;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    /**
     * Creates a new instance of CalificaBean
     */
    public CalificaBean() {
        /*
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        */
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            nombre = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
        System.out.println("este es el nombre x "+nombre);
        CalificaDAO c = new CalificaDAO();
        usuarioByIdUsuarioCalifica = c.getUsuarioByNombre(nombre);
        
    }
    
    public void califica(){
        try{
            id = new CalificacionId(usuarioByIdUsuarioCalificado.getIdUsuario(),usuarioByIdUsuarioCalifica.getIdUsuario(),compra.getIdCompra());
            Calificacion c = new Calificacion(getId(),compra,getUsuarioByIdUsuarioCalificado(),getUsuarioByIdUsuarioCalifica(),getIdCalif(),getCalificaion());
            CalificaDAO calificaDAO = new CalificaDAO();
            calificaDAO.addCalificacion(c);
        } catch (org.hibernate.exception.ConstraintViolationException e) {     
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Debes escoger una calificacion", null);
            faceContext.addMessage(null, message);
        }
        catch(Exception e){
            e.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Algo salio mal, intentalo de nuevo", null);
            faceContext.addMessage(null, message);
        }
    }
    
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificacion", "Asignaste:" + ((Integer) rateEvent.getRating())+"");
        FacesContext.getCurrentInstance().addMessage(null, message);
        nombreCalif = faceContext.getExternalContext().getRequestParameterMap().get("selectedObj");
        idCompra = Integer.parseInt(faceContext.getExternalContext().getRequestParameterMap().get("selectedObj1"));
        System.out.println("este es el nombre del calificado "+nombreCalif);
        //System.out.println("este es el id de la compra "+idCompra);
        CalificaDAO c = new CalificaDAO();
        usuarioByIdUsuarioCalificado = c.getUsuarioByNombre(nombreCalif);
        compra = c.getCompraById(idCompra);
        califica();
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelar", "Se cancelo la calificacion");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    public Integer getCalificacion1() {
        return calificaion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCalif() {
        return nombreCalif;
    }

    public void setNombreCalif(String nombreCalif) {
        this.nombreCalif = nombreCalif;
    }

    public Usuario getBusquedaUsuario() {
        return busquedaUsuario;
    }

    public void setBusquedaUsuario(Usuario busquedaUsuario) {
        this.busquedaUsuario = busquedaUsuario;
    }

    public double getCalificacionTotal() {
        return calificacionTotal;
    }

    public void setCalificacionTotal(double calificacionTotal) {
        this.calificacionTotal = calificacionTotal;
    }
 
    public void setCalificacion1(Integer calificaion) {
        this.calificaion = calificaion;
        califica();
    }
    
    public String obtenNombreInfo(){
        CalificaDAO c = new CalificaDAO();
        nombre = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        return nombre; 
    }
    
    public String obtenCalifInfo(){
        CalificaDAO c = new CalificaDAO();
        nombre = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        busquedaUsuario = c.getUsuarioByNombre(nombre);
        calificacionTotal = c.getCalificacionTotal(busquedaUsuario); 
        return String.valueOf(calificacionTotal);
    }

    public CalificacionId getId() {
        return id;
    }

    public void setId(CalificacionId id) {
        this.id = id;
    }

    public Usuario getUsuarioByIdUsuarioCalificado() {
        return usuarioByIdUsuarioCalificado;
    }

    public void setUsuarioByIdUsuarioCalificado(Usuario usuarioByIdUsuarioCalificado) {
        this.usuarioByIdUsuarioCalificado = usuarioByIdUsuarioCalificado;
    }

    public Usuario getUsuarioByIdUsuarioCalifica() {
        return usuarioByIdUsuarioCalifica;
    }

    public void setUsuarioByIdUsuarioCalifica(Usuario usuarioByIdUsuarioCalifica) {
        this.usuarioByIdUsuarioCalifica = usuarioByIdUsuarioCalifica;
    }

    public int getIdCalif() {
        return idCalif;
    }

    public void setIdCalif(int idCalif) {
        this.idCalif = idCalif;
    }

    public int getCalificaion() {
        return calificaion;
    }

    public void setCalificaion(int calificaion) {
        this.calificaion = calificaion;
    }

    public FacesMessage getMessage() {
        return message;
    }

    public void setMessage(FacesMessage message) {
        this.message = message;
    }
    
}
