package DAO;

import mapeo.Usuario;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import util.NewHibernateUtil;

public class InicioSesionDAO {
    
    private Session sesion;

    public InicioSesionDAO() {
        sesion = NewHibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Usuario getLoginPorNombreUsuario(String nombreUsuario) {
        try {
            Transaction t = sesion.beginTransaction();
            Query query = sesion.getNamedQuery("BuscaPorNombreUsuario Usuario").setString("nombre_usuario", nombreUsuario);
            return (Usuario)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}