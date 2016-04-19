package beans;

import DAO.EditarEliminarDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mapeo.DatosUsuario;

@Named(value = "editarEliminarBean")
@SessionScoped
public class EditarEliminarBean implements Serializable {

    private int idDatosUsuario;
    private String email;
    private String telefono;
    private int edad;
    private String sexo;

    /**
     * Creates a new instance of EditarEliminarBean
     */
    public EditarEliminarBean() {
    }

    public void returnUsuarioById() {
        EditarEliminarDAO editarEliminarDAO = new EditarEliminarDAO();
        DatosUsuario cliente = editarEliminarDAO.getUsuarioByID(getIdDatosUsuario());
        if (cliente != null) {
            setIdDatosUsuario(cliente.getIdDatosUsuario());
            setEmail(cliente.getEmail());
            setTelefono(cliente.getTelefono());
            setEdad(cliente.getEdad());
            setSexo(cliente.getSexo());

        } else {
            setEmail("");
            setTelefono("");
            setEdad(0);
            setSexo("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente NO encontrado "));
        }
    }

    public void deleteUsuario() {
        EditarEliminarDAO editarEliminarDAO = new EditarEliminarDAO();
        editarEliminarDAO.deleteDatosUsuario(getIdDatosUsuario());
        setEmail("");
        setTelefono("");
        setEdad(0);
        setSexo("");

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cliente con ID: " + getIdDatosUsuario() + " eliminado"));
    }

    public void updateUsuario() {
        DatosUsuario datosUsuario = new DatosUsuario(getIdDatosUsuario(), getEmail(), getTelefono(), getEdad(), getSexo());
        EditarEliminarDAO editarEliminarDAO = new EditarEliminarDAO();
        editarEliminarDAO.updateDatosUsuario(getIdDatosUsuario(), datosUsuario);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cliente actualizado correctamente"));
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

}
