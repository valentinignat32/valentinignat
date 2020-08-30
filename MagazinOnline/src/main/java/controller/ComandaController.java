package controller;

import modele.Comanda;
import modele.Producator;
import services.ComandaService;
import services.ProducatorService;

import java.util.logging.Logger;

public class ComandaController {

    private static final Logger logger = Logger.getLogger(ComandaController.class.getName());
    ComandaService comandaService = new ComandaService();

    public boolean saveComanda(Comanda comanda) {
        logger.info("Comanda cu id-ul" + comanda.getId() + " se salveaza...");
        return comandaService.saveComanda(comanda);
    }
    public Comanda findComandaById(Long id) {
        Comanda comandaGasita = comandaService.getComandaById(id);
        logger.info("Comanda gasita: " + comandaGasita.toString());
        return comandaGasita;
    }

    public boolean updateComanda(Comanda comanda) {
        boolean isComandaUpdated = comandaService.updateComanda(comanda);
        if (isComandaUpdated) {
            logger.info("Comanda " + comanda.getId() + " a fost actualizata");
        } else {
            logger.info("Comanda " + comanda.getId() + " nu a fost actualizata!");
        }
        return isComandaUpdated;
    }

    public boolean deleteComanda(Long id) {

        logger.info("Comanda se anuleaza...");
        Comanda comandaGasita= comandaService.getComandaById(id);
        boolean isComandaDeleted = comandaService.deleteComanda(comandaGasita);
        if (isComandaDeleted) {
            logger.info("Comanda cu id-ul " + comandaGasita.getId() + " a fost anulata");
        } else {
            logger.info("Eroare la anularea comenzii cu id-ul " + comandaGasita.getId());
        }
        return isComandaDeleted;
    }


}
