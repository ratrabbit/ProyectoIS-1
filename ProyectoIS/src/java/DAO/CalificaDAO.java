/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Transaction;
import mapeo.Calificacion;
import mapeo.CalificacionId;
import mapeo.Compra;
import mapeo.Usuario;
import org.hibernate.Session;
import util.NewHibernateUtil;
/**
 *
 * @author francisco
 */
public class CalificaDAO {
    public void addCalificacion(Calificacion calificacion) {
        Transaction tx = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = sesion.beginTransaction();
            sesion.save(calificacion);
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
    
    public Compra getCompraById(int id){
        Compra c = new Compra();
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Compra where id_compra = :idToFind";
            Query query = session.createQuery(queryString);
            //query.setString("idToFind", Integer.toString(id));
            query.setInteger("idToFind", id);
            c = (Compra) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return c;
    }
    
    public double getCalificacionTotal(Usuario a){
        double calif = 0;
        Transaction trns = null;
        ArrayList<Calificacion> lista = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Calificacion where id_usuario_calificado = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", a.getIdUsuario());
            lista = (ArrayList<Calificacion>) query.list();
            System.out.println(lista);
            for(Calificacion c1 : lista){
                calif += c1.getCalificaion();
            }
            System.out.println(calif);
            System.out.println(lista.size());
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return calif/lista.size();
    }
}
