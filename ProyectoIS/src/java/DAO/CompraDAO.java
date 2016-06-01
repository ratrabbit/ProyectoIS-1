/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import mapeo.Compra;
import mapeo.Publicacion;
import mapeo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
public class CompraDAO {
    public void addCompra(Compra compra) {
        Transaction tx = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = sesion.beginTransaction();
            sesion.save(compra);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            sesion.flush();
            sesion.close();
        }
    }
    public Usuario getUsuarioByNombre(String nombre){
        Usuario usuario = new Usuario();
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Usuario where nombre_usuario = :idToFind";
            Query query = session.createQuery(queryString);
            query.setString("idToFind", nombre);
            usuario = (Usuario) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return usuario;
    }
    
    public Publicacion getPublicacionByNombre(String nombre){
        Publicacion pub = new Publicacion();
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Publicacion where nombre_producto = :idToFind";
            Query query = session.createQuery(queryString);
            query.setString("idToFind", nombre);
            pub = (Publicacion) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return pub;
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
