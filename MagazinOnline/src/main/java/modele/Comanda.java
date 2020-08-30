package modele;
  

import javax.persistence.*;
import java.util.Objects;

import static java.util.Objects.hash;


@Entity(name = "Comanda")
    @Table(name = "comanda")
    public class Comanda{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "metoda_livrare")
        private String metodaLivrare;

        @Column(name = "metoda_plata")
        private String metodaPlata;

        @Column(name = "id_utilizator")
        private Long idUtilizator;

        @Column(name = "id_produs")
        private Long idProdus;

        @Column(name = "stare_comanda")
        private String stareComanda;

        public Comanda() {
            // empty constructor by default
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }



        public Long getIdUtilizator() {
            return idUtilizator;
        }

        public void setIdUtilizator(Long idUtilizator) {
            this.idUtilizator = idUtilizator;
        }

        public String getMetodaLivrare() {
            return metodaLivrare;
        }

        public void setMetodaLivrare(String metodaLivrare) {
            this.metodaLivrare = metodaLivrare;
        }

        public String getMetodaPlata() {
            return metodaPlata;
        }

        public void setMetodaPlata(String metodaPlata) {
            this.metodaPlata = metodaPlata;
        }

        public Long getIdProdus() {
            return idProdus;
        }

        public void setIdProdus(Long idProdus) {
            this.idProdus = idProdus;
        }

        public String getStareComanda() {
            return stareComanda;
        }

        public void setStareComanda(String stareComanda) {
            this.stareComanda = stareComanda;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Comanda comanda = (Comanda) o;
            return Objects.equals(id, comanda.id) &&
                    Objects.equals(metodaLivrare, comanda.metodaLivrare) &&
                    Objects.equals(metodaPlata, comanda.metodaPlata) &&
                    Objects.equals(idUtilizator, comanda.idUtilizator) &&
                    Objects.equals(idProdus, comanda.idProdus) &&
                    Objects.equals(stareComanda, comanda.stareComanda);
        }

        @Override
        public int hashCode() {
            return hash(id, metodaLivrare, metodaPlata, idUtilizator, idProdus, stareComanda);
        }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", metodaLivrare='" + metodaLivrare + '\'' +
                ", metodaPlata='" + metodaPlata + '\'' +
                ", idUtilizator=" + idUtilizator +
                ", idProdus=" + idProdus +
                ", stareComanda='" + stareComanda + '\'' +
                '}';
    }
}


