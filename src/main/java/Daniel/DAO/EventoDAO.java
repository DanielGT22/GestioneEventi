package Daniel.DAO;

import Daniel.Entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();

        System.out.println("Evento salvato " + evento.getTitolo());
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }


    public void findByIdAndDelete(long id) {

        Evento current = this.getById(id);

        if (current != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(current);
            transaction.commit();
            System.out.println("Eventoi " + current.getTitolo() + " ca!");
        } else {
            System.out.println("L'evento con il id: " + id + " non esiste");
        }


    }
}