package jeroen.school.dea.DataSource.DAO;

import jeroen.school.dea.Domain.PlaylistDTOS.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistsDTO;
import jeroen.school.dea.Domain.PlaylistEntity;
import jeroen.school.dea.Domain.PlaylistsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class HibernatePlaylistDAO implements IHibernatePlaylistDAO {
    private static SessionFactory factory;

    private HibernatePlaylistDAO() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public boolean createNewPlaylist(CreatePlaylistDTO newPlaylist, int userId) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer eUserId = null;

        try {
            tx = session.beginTransaction();

            PlaylistEntity pEntity = new PlaylistEntity(newPlaylist.getName(), userId);

            eUserId = (Integer) session.save(pEntity);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            session.close();
        }

        return true;
    }

    @Override
    public PlaylistsEntity getAllPlayListsByToken(int userId) {
        Session session = factory.openSession();
        Transaction tx = null;
        PlaylistsEntity playlists = new PlaylistsEntity();

        try {
            tx = session.beginTransaction();

            String hql = "FROM PlaylistEntity p WHERE p.owner = :userId";

            List pl = session.createQuery(hql).setParameter("userId", userId).list();

            for (Iterator i = pl.iterator(); i.hasNext();) {
                playlists.getPlaylists().add((PlaylistEntity) i.next());
//                PlaylistEntity pe = (PlaylistEntity) i.next();
//                System.out.println(pe.getName());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            session.close();
        }

        return playlists;
    }
}
