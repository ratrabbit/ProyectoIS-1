/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mapeo.DatosUsuario;
import util.NewHibernateUtil;

/**
 *
 * @author francisco
 */
public class DatosUsuarioDAO {

    public void datosUsuario(DatosUsuario usuario) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteUsuario(int idUsuario) {

    }

    public void updateUsuario(DatosUsuario usuario) {

    }

    public DatosUsuario getDatosUsuarioById() {
        return null;
    }
}
