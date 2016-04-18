package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mapeo.Usuario;
import util.NewHibernateUtil;

public class InicioSesionDAO {

    private Session sesion;

    public InicioSesionDAO() {
        sesion = NewHibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Usuario getLoginPorNombreUsuario(String nombreUsuario) {
        try {
            Transaction t = sesion.beginTransaction();
            Query query = sesion.getNamedQuery("BuscaPorNombreUsuario").setString("nombre_usuario", nombreUsuario);
            return (Usuario) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
