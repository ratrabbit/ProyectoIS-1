package mapeo;

public class Calificacion  implements java.io.Serializable {


     private CalificacionId id;
     private Usuario usuarioByIdUsuarioCalificado;
     private Usuario usuarioByIdUsuarioCalifica;
     private int idCalif;
     private int calificaion;

    public Calificacion() {
    }

    public Calificacion(CalificacionId id, Usuario usuarioByIdUsuarioCalificado, Usuario usuarioByIdUsuarioCalifica, int idCalif, int calificaion) {
       this.id = id;
       this.usuarioByIdUsuarioCalificado = usuarioByIdUsuarioCalificado;
       this.usuarioByIdUsuarioCalifica = usuarioByIdUsuarioCalifica;
       //this.idCalif = idCalif;
       this.calificaion = calificaion;
    }
   
    public CalificacionId getId() {
        return this.id;
    }
    
    public void setId(CalificacionId id) {
        this.id = id;
    }
    public Usuario getUsuarioByIdUsuarioCalificado() {
        return this.usuarioByIdUsuarioCalificado;
    }
    
    public void setUsuarioByIdUsuarioCalificado(Usuario usuarioByIdUsuarioCalificado) {
        this.usuarioByIdUsuarioCalificado = usuarioByIdUsuarioCalificado;
    }
    public Usuario getUsuarioByIdUsuarioCalifica() {
        return this.usuarioByIdUsuarioCalifica;
    }
    
    public void setUsuarioByIdUsuarioCalifica(Usuario usuarioByIdUsuarioCalifica) {
        this.usuarioByIdUsuarioCalifica = usuarioByIdUsuarioCalifica;
    }
    public int getIdCalif() {
        return this.idCalif;
    }
    
    public void setIdCalif(int idCalif) {
        this.idCalif = idCalif;
    }
    public int getCalificaion() {
        return this.calificaion;
    }
    
    public void setCalificaion(int calificaion) {
        this.calificaion = calificaion;
    }
    @Override
    public String toString(){
        return "Usuario "+usuarioByIdUsuarioCalificado.getNombreUsuario()+" Calificacion "+calificaion+"";
    }



}


