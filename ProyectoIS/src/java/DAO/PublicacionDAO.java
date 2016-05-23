/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import mapeo.Publicacion;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
        }catch(RuntimeException e){
        }finally{
            session.flush();
            session.close();
        }
        return lista;
    }
     
     
     
      public int maxIndice(String tabla,String atributo){
      SessionFactory factory;
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        int max=-1;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "SELECT max("+atributo+") FROM "+tabla;
            SQLQuery query = session.createSQLQuery(sql);
            //System.out.println("hola"+sql);
            if(query.uniqueResult() != null){
                max = (int)query.uniqueResult();
            }
            //System.out.println(max);
            tx.commit();
            //return max;
        }catch(HibernateException e){
            System.out.println("error"+e);
            
        }finally{
            session.close();
        }
      //System.out.println(max);
      return max+1;
    }
     
    
}
