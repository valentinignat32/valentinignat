package services;
import dao.ComandaDao;
import modele.Comanda;

import java.util.List;

public class ComandaService {
    ComandaDao comandaDao = new ComandaDao();

    // CRUD => CREATE

    public boolean saveComanda(Comanda comanda) {
        Comanda comandaSalvata = comandaDao.create(comanda);

        if (comandaSalvata != null) {
            System.out.println("Comanda a fost salvata!");

            return true;
        }

        return false;
    }

    public void saveComenzi(List<Comanda> listaComenzi) {
        System.out.println("Se salveaza comenzile din lista de comenzi!");

        for (Comanda comanda : listaComenzi) {
            Comanda comandaSalvata = comandaDao.create(comanda);
        }
    }

    // CRUD => READ

    public Comanda getComandaById(Long id) {
        System.out.println("Se cauta comanda cu id-ul " + id);

        Comanda comandaGasita = comandaDao.findById(id);

        return comandaGasita;
    }


    public List<Comanda> getAll() {
        System.out.println("Se cauta toate comenzile pentru a fi afisate!");

        List<Comanda> listaComenzi = comandaDao.findAll();

        return listaComenzi;
    }

    // CRUD => UPDATE

    public boolean updateComanda(Comanda comanda) {
        System.out.println("Comanda se va actualiza!");
        boolean isComandaUpdated = comandaDao.update(comanda);
        return isComandaUpdated;
    }

    // CRUD => DELETE

    public boolean deleteComanda(Comanda comanda) {
        System.out.println("Comanda va fi stearsa!");
        boolean isComandaDeleted = comandaDao.delete(comanda);
        return isComandaDeleted;
    }
}



