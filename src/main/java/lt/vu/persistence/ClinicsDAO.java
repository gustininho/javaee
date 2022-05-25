package lt.vu.persistence;

import lt.vu.entities.Clinic;
import lt.vu.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ClinicsDAO {

    @Inject
    private EntityManager em;

    public List<Clinic> loadAll() {
        return em.createNamedQuery("Clinic.findAll", Clinic.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Clinic clinic){
        this.em.persist(clinic);
    }

    public Clinic findOne(Integer id) {
        return em.find(Clinic.class, id);
    }
}
