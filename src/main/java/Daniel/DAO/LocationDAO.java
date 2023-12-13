package Daniel.DAO;

import Daniel.Entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();

        System.out.println("Location salvata " + location.getNome());
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }


    public void findByIdAndDelete(long id) {

        Location current = this.getById(id);

        if (current != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(current);
            transaction.commit();
            System.out.println("Location " + current.getNome() + " cancelata!");
        } else {
            System.out.println("La location con il id: " + id + " non esiste");
        }


    }
}