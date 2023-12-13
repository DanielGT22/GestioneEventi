package Daniel.DAO;

import Daniel.Entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {

    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();

        System.out.println("Persona aggiunta " + persona.getNome());
    }

    public Persona getById(long id) {
        return em.find(Persona.class, id);
    }


    public void findByIdAndDelete(long id) {

        Persona current = this.getById(id);

        if (current != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(current);
            transaction.commit();
            System.out.println("Persona " + current.getNome() + " è stata rimossa");
        } else {
            System.out.println("Persona con il id: " + id + " non esiste");
        }


    }
}