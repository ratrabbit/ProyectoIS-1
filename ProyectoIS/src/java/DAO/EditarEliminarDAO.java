package DAO;

import mapeo.DatosUsuario;
import mapeo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

public class EditarEliminarDAO {

    public EditarEliminarDAO() {

    }

    public void deleteDatosUsuario(int idDatosUsuario) {
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            DatosUsuario datosUsuario = (DatosUsuario) session.load(DatosUsuario.class, new Integer(idDatosUsuario));
            session.delete(datosUsuario);
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

    public void updateDatosUsuario(int idDatosUsuario, DatosUsuario newCliente) {
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            DatosUsuario oldCliente = (DatosUsuario) session.load(DatosUsuario.class, new Integer(idDatosUsuario));
            oldCliente.setNombre(newCliente.getNombre());
            oldCliente.setApellidoPaterno(newCliente.getApellidoPaterno());
            oldCliente.setApellidoMaterno(newCliente.getApellidoMaterno());
            oldCliente.setEmail(newCliente.getEmail());
            oldCliente.setTelefono(newCliente.getTelefono());
            oldCliente.setEdad(newCliente.getEdad());
            oldCliente.setSexo(newCliente.getSexo());
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
    
    public void updateContraUsuario(int idUsuario, String pass) {
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Usuario oldUsuario = (Usuario) session.load(Usuario.class, new Integer(idUsuario));
            oldUsuario.setContraseniaUsuario(pass);
            session.update(oldUsuario);
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
    
      public DatosUsuario getUsuarioByID(int idDatosUsuario) {
        DatosUsuario datosUsuario = null;
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from DatosUsuario where id_usuario_fk = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idDatosUsuario);
            datosUsuario = (DatosUsuario) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return datosUsuario;
    }
}
