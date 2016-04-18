/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mapeo.Usuario;
import util.NewHibernateUtil;

/**
 *
 * @author francisco
 */
public class RegistroDAO {

    public void addRegistro(Usuario registro) {
        Transaction tx = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = sesion.beginTransaction();
            sesion.save(registro);
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

    public void deleteRegistro(int idRegistro) {

    }

    public void updateRegistro(Usuario registro) {

    }

    public Usuario getUsuarioById() {
        return null;
    }
}
