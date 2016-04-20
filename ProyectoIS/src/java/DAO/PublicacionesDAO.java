/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.PublicacionesBean;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import util.NewHibernateUtil;

/**
 *
 * @author adolfo
 */


public class PublicacionesDAO{
    
    private List<GaleriaPublicacion> lista;      

    
    public List<GaleriaPublicacion> getGaleria() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            lista =  (List<GaleriaPublicacion>)session.createQuery("from galeria_publicacion").list();
        }catch(RuntimeException e){
        }finally{
            session.flush();
            session.close();
        }
        return lista;
    }
}
    

