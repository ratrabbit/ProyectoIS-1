/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import mapeo.Publicacion;
import org.hibernate.Session;
import util.NewHibernateUtil;

/**
 *
 * @author adolfo
 */
public class PublicacionDAO {
    private List<Publicacion> lista;
    
     public List<Publicacion> getGaleria() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            lista =  (List<Publicacion>) session.getNamedQuery("BuscaPublicaciones").list();
            System.out.println(lista);
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }catch(RuntimeException e){
        }finally{
            session.flush();
            session.close();
        }
        return lista;
    }
    
}
