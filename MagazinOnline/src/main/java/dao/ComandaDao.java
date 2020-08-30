package dao;
import magazinConfig.MagazinConfing;
import modele.Comanda;
import modele.Producator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ComandaDao {

    // CRUD => CREATE

    public Comanda create(Comanda comanda) {
        Transaction transaction = null;
        try {
            Session session = MagazinConfing.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // using cast because it is needed Serializable implementation
            Comanda salvareComanda = (Comanda) session.save(comanda);

            transaction.commit();
            session.close();

            return salvareComanda;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Comanda aleasa nu a fost salvata!");
            e.printStackTrace();
        }

        return null;
    }

    // CRUD => READ

    public Comanda findById(Long id) {
        try {
            Session session = MagazinConfing.getSessionFactory().openSession();

            Comanda comandaGasita = session.find(Comanda.class, id);

            session.close();
            return comandaGasita;
        } catch (Exception e) {
            System.out.println("Comanda " + id + " nu a fost gasita!");
            e.printStackTrace();
        }

        return null;
    }

    public List<Comanda> findAll() {
        Session session = MagazinConfing.getSessionFactory().openSession();

        List<Comanda> comenzi = (List<Comanda>) session.createQuery("from order").list();
        return comenzi;
    }

    // CRUD => UPDATE

    public boolean update(Comanda comanda) {
        Transaction transaction = null;
        try {
            Session session = MagazinConfing.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.update(comanda);

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Comanda " + comanda.getId() + " nu a fost actualizata!");
            e.printStackTrace();
        }

        return false;
    }

    // CRUD => DELETE

    public boolean delete(Comanda comanda) {
        Transaction transaction = null;
        try {
            Session session = MagazinConfing.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(comanda);

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Comanda " + comanda.getId() + " nu a fost stearsa!");
            e.printStackTrace();
        }

        return false;
    }
}


