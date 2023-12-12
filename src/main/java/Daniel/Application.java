package Daniel;

import Daniel.DAO.EventoDAO;
import Daniel.Entities.Evento;
import Daniel.Entities.tipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);
        Evento serataDnd = new Evento("DnD", LocalDate.of(2023, 12, 15),"Manuale di Tasha", tipoEvento.PRIVATO, 6);
        Evento proveTheFioys = new Evento("Prove Band",LocalDate.of(2023,12,16),"Finire next to me", tipoEvento.PRIVATO, 3);
        Evento pranzoPostNatale = new Evento("Pranzo Post Natale",LocalDate.of(2023,12,28),"Pranzo", tipoEvento.PRIVATO, 15);


        sd.save(serataDnd);
		sd.save(proveTheFioys);
		sd.save(pranzoPostNatale);

        long id = 1;
        Evento checkDb = sd.getById(id);
        if (checkDb != null) {
            System.out.println(checkDb);
        } else {
            System.out.println("Evento con  " + id + " non esiste");
        }


        em.close();
        emf.close();
    }
}