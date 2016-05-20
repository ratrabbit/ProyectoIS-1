package DAO;

import org.hibernate.Transaction;
import mapeo.Publicacion;
import org.hibernate.Session;
import util.NewHibernateUtil;

public class PublicarDAO {

    public void addPublicacion(Publicacion publicacion) {
        Transaction tx = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = sesion.beginTransaction();
            sesion.save(publicacion);
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

}
