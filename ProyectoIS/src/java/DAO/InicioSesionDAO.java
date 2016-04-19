package DAO;

import java.util.List;
import mapeo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InicioSesionDAO {

    private Session session;

    public InicioSesionDAO() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Usuario getLoginPorNombreUsuario(String nombreUsuario) {
         try {
              Transaction t = session.beginTransaction();
              Query query = session.getNamedQuery("BuscaPorNombreUsuario").setString("nombreUsuario", nombreUsuario);
              return (Usuario) query.uniqueResult();
          } catch (Exception e) {
              e.printStackTrace();
        }   
        return null;
    }
    
}