package services;

import dao.ProdusDao;
import modele.Produs;
import modele.Utilizator;

import java.util.List;

public class ProdusService {
//    produs DAO
    ProdusDao dao = new ProdusDao();

//    metode CREATE/SAVE
    public boolean saveProdus(Produs produs) {
        Produs produsSalvat = dao.create(produs);

        if (produsSalvat != null) {
            System.out.println("Produsul " + produsSalvat.getNume()
                    + " a fost salvat!");

            return true;
        }

        return false;
    }

    public void saveProduse(List<Produs> list) {
        System.out.println("Se salveaza lista!");

        for (Produs produs : list) {
            Produs produsSalvat = dao.create(produs);
        }
    }

    //    METODE READ/FIND
    public Produs getProdusById(Long id) {
        System.out.println("Se cauta produs " + id);

        Produs produsGasit = dao.findById(id);

        return produsGasit;
    }

    public List<Produs> getAll() {
        System.out.println("Se afiseaza toate produsele!");

        List<Produs> list = dao.findAll();

        return list;
    }

    //    METODE UPDATE
    public boolean updateProdus(Produs produs) {
        System.out.println("Se realizeaza update-ul produsului!");

        boolean isProdusUpdated = dao.update(produs);

        return isProdusUpdated;
    }

    //    METODE DELETE
    public boolean deleteProdus(Produs produs) {
        System.out.println("Se sterge produsul!");
        boolean isProdusDeleted = dao.delete(produs);

        return isProdusDeleted;
    }
}



