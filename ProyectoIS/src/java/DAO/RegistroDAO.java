package DAO;

import org.hibernate.Transaction;
import mapeo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import util.NewHibernateUtil;

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
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Usuario usuario = (Usuario) session.load(Usuario.class, new Integer(idRegistro));
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateRegistro(int idUsuario, Usuario newUsuario) {
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Usuario oldCliente = (Usuario) session.load(Usuario.class, new Integer(idUsuario));
            oldCliente.setNombreUsuario(newUsuario.getNombreUsuario());
            oldCliente.setContraseniaUsuario(newUsuario.getContraseniaUsuario());
            session.update(oldCliente);
            trns.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public Usuario getRegistroUsuarioByID(String nombreUsuario) {
        Usuario usuario = null;
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Usuario where nombre_usuario = :idToFind";
            Query query = session.createQuery(queryString);
            query.setString("idToFind", nombreUsuario);
            //query.setInteger("idToFind", nombreUsuario);
            usuario = (Usuario) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return usuario;
    }

}
