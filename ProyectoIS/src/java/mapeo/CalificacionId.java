package mapeo;



public class CalificacionId  implements java.io.Serializable {


     private int idUsuarioCalificado;
     private int idUsuarioCalifica;

    public CalificacionId() {
    }

    public CalificacionId(int idUsuarioCalificado, int idUsuarioCalifica) {
       this.idUsuarioCalificado = idUsuarioCalificado;
       this.idUsuarioCalifica = idUsuarioCalifica;
    }
   
    public int getIdUsuarioCalificado() {
        return this.idUsuarioCalificado;
    }
    
    public void setIdUsuarioCalificado(int idUsuarioCalificado) {
        this.idUsuarioCalificado = idUsuarioCalificado;
    }
    public int getIdUsuarioCalifica() {
        return this.idUsuarioCalifica;
    }
    
    public void setIdUsuarioCalifica(int idUsuarioCalifica) {
        this.idUsuarioCalifica = idUsuarioCalifica;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CalificacionId) ) return false;
		 CalificacionId castOther = ( CalificacionId ) other; 
         
		 return (this.getIdUsuarioCalificado()==castOther.getIdUsuarioCalificado())
 && (this.getIdUsuarioCalifica()==castOther.getIdUsuarioCalifica());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUsuarioCalificado();
         result = 37 * result + this.getIdUsuarioCalifica();
         return result;
   }   


}


