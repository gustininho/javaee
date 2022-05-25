package lt.vu.persistence;

import lt.vu.entities.Doctor;
import lt.vu.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class DoctorsDAO {

    @Inject
    private EntityManager em;

    public void persist(Doctor doctor){
        this.em.persist(doctor);
    }

    public Doctor findOne(Integer id){
        return em.find(Doctor.class, id);
    }

    public Doctor update(Doctor doctor){
        return em.merge(doctor);
    }
}
