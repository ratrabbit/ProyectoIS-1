package beans;

import DAO.EditarEliminarDAO;
import DAO.RegistroDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mapeo.DatosUsuario;
import mapeo.Usuario;

@Named(value = "editarEliminarBean")
//@SessionScoped
@ManagedBean
@RequestScoped

public class EditarEliminarBean implements Serializable {

    private int idDatosUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String telefono;
    private int edad;
    private String sexo;

    private Usuario usuario;
    private int idUsuario;
    private String nombreUsuario;
    private String contraseniaUsuario;
    private String contraVieja;
    private int identificadorUsuario;
    private int contraNueva;

    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage message;
    private String sesionUsuario;

    public EditarEliminarBean() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            nombreUsuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
            returnUsuarioById();
        }
    }

    public void returnUsuarioById() {
        EditarEliminarDAO editarEliminarDAO = new EditarEliminarDAO();
        RegistroDAO registroDAO = new RegistroDAO();
        Usuario usu = new Usuario();
        usu = registroDAO.getRegistroUsuarioByID(getSesionUsuario());
        DatosUsuario cliente;

        if (usu != null) {

            //Campos de datos de la tabla Usuario
            setIdUsuario(usu.getIdUsuario());
            setNombreUsuario(usu.getNombreUsuario());
            setContraVieja(usu.getContraseniaUsuario());

            //obtiene el PK de Usuario para usarlo en el FK  de DATOSUSUARIO
            setIdentificadorUsuario(usu.getIdUsuario());
            cliente = editarEliminarDAO.getUsuarioByID(usu.getIdUsuario());
            //Campos de datos de la tabla DatosUsuario
            setIdDatosUsuario(cliente.getIdDatosUsuario());
            setNombre(cliente.getNombre());
            setApellidoPaterno(cliente.getApellidoPaterno());
            setApellidoMaterno(cliente.getApellidoMaterno());
            setEmail(cliente.getEmail());
            setTelefono(cliente.getTelefono());
            setEdad(cliente.getEdad());
            setSexo(cliente.getSexo());
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente NO encontrado "));
        }
    }
    public String dirigeConfirmacionElimina(){
        return "ConfirmarEliminar";
    }
    
    public String regresaInicio(){
        return "index";
    }
    
    public String cancelaEliminar(){
        return "EditarEliminarPerfil";
    }
    public String deleteUsuario() {
        RegistroDAO registroDAO = new RegistroDAO();
        //Usuario usu = registroDAO.getRegistroUsuarioByID(getNombreUsuario());
        Usuario usu = registroDAO.getRegistroUsuarioByID(getSesionUsuario());

        EditarEliminarDAO editarEliminarDAO = new EditarEliminarDAO();
        editarEliminarDAO.deleteDatosUsuario(getIdDatosUsuario());

        registroDAO.deleteRegistro(getIdentificadorUsuario());
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario eliminado satisfactoriamente "));

        return "index";

    }

    public String updateUsuario() {
        DatosUsuario datosUsuario = new DatosUsuario(getIdDatosUsuario(), usuario, getNombre(), getApellidoPaterno(), getApellidoMaterno(), getEmail(), getTelefono(), getEdad(), getSexo());
        EditarEliminarDAO editarEliminarDAO = new EditarEliminarDAO();
        Usuario u = new Usuario(getNombreUsuario(), getContraseniaUsuario());
        RegistroDAO registroDAO = new RegistroDAO();

        Usuario usu = registroDAO.getRegistroUsuarioByID(getSesionUsuario());
        if (usu == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Ingresa tu nombre de usuario y consulta primero antes de eliminar"));
            return "EditarEliminarPerfil";
        } else if (getNombreUsuario().equals("") || getNombre().equals("") || getApellidoPaterno().equals("") || getApellidoMaterno().equals("") || getEmail().equals("") || getSexo().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Debes diligenciar todos los campos obligatorios"));
            return "EditarEliminarPerfil";
        } else if (getEdad() < 18) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Debes ser mayor de edad"));
            return "EditarEliminarPerfil";

        } else {
            editarEliminarDAO.updateDatosUsuario(getIdDatosUsuario(), datosUsuario);
            if(getContraseniaUsuario()!=null)
                if(!getContraseniaUsuario().equals(""))
                    editarEliminarDAO.updateContraUsuario(usu.getIdUsuario(), contraseniaUsuario);
            ObtieneRolBean rol = new ObtieneRolBean();
            String rolEscogido = rol.getRol();
            if (rolEscogido != null) {
                if (rolEscogido.equals("Remitente")) {
                    FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Datos editados correctamente"));
            
                    return "InicioRemitente";

                } else if (rolEscogido.equals("Transportador")) {
                    FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Datos editados correctamente"));
            
                    return "InicioTransportador";
                }
            }

            if (!getContraseniaUsuario().equals("")) {
                registroDAO.updateRegistro(getIdUsuario(), u);
            } else {
                u.setContraseniaUsuario(contraVieja);
                registroDAO.updateRegistro(getIdUsuario(), u);
            }
        }
        return "InicioTransportador";
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

    public String getContraVieja() {
        return contraVieja;
    }

    public void setContraVieja(String contraVieja) {
        this.contraVieja = contraVieja;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the contraseniaUsuario
     */
    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    /**
     * @param contraseniaUsuario the contraseniaUsuario to set
     */
    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    /**
     * @return the identificadorUsuario
     */
    public int getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    /**
     * @param identificadorUsuario the identificadorUsuario to set
     */
    public void setIdentificadorUsuario(int identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }

    /**
     * @return the contraNueva
     */
    public int getContraNueva() {
        return contraNueva;
    }

    /**
     * @param contraNueva the contraNueva to set
     */
    public void setContraNueva(int contraNueva) {
        this.contraNueva = contraNueva;
    }

    /**
     * @return the sesionUsuario
     */
    public String getSesionUsuario() {
        return nombreUsuario;
    }

    /**
     * @param sesionUsuario the sesionUsuario to set
     */
    public void setSesionUsuario(String sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }

}
