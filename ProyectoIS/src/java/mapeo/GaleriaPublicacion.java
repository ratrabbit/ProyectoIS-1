package mapeo;


public class GaleriaPublicacion  implements java.io.Serializable {


     private int idGaleria;
     private String urlImagen;
     private String varcharoImagen;

    public GaleriaPublicacion() {
    }

	
    public GaleriaPublicacion(int idGaleria, String urlImagen) {
        this.idGaleria = idGaleria;
        this.urlImagen = urlImagen;
    }
    public GaleriaPublicacion(int idGaleria, String urlImagen, String varcharoImagen) {
       this.idGaleria = idGaleria;
       this.urlImagen = urlImagen;
       this.varcharoImagen = varcharoImagen;
    }
   
    public int getIdGaleria() {
        return this.idGaleria;
    }
    
    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }
    public String getUrlImagen() {
        return this.urlImagen;
    }
    
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    public String getVarcharoImagen() {
        return this.varcharoImagen;
    }
    
    public void setVarcharoImagen(String varcharoImagen) {
        this.varcharoImagen = varcharoImagen;
    }




}


