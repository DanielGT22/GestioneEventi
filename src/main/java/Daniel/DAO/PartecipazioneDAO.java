package Daniel.DAO;

import Daniel.Entities.Evento;
import Daniel.Entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {

    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();

        System.out.println("Partecipazione di " + partecipazione.getPersona() + "è stata regisstrata");
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }


    public void findByIdAndDelete(long id) {

        Partecipazione current = this.getById(id);

        if (current != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(current);
            transaction.commit();
            System.out.println(current.getPersona() + "non è più partecipe");
        } else {
            System.out.println("Partecipazione con il id(" + id + ") non esiste");
        }


    }
}