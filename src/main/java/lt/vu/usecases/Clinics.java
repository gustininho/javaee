package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Clinic;
import lt.vu.persistence.ClinicsDAO;
import lt.vu.persistence.TeamsDAO;
import lt.vu.entities.Team;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Clinics {

    @Inject
    private ClinicsDAO clinicsDAO;

    @Getter @Setter
    private Clinic clinicToCreate = new Clinic();

    @Getter
    private List<Clinic> allClinics;

    @PostConstruct
    public void init(){
        loadAllClinics();
    }

    @Transactional
    public void createClinic(){
        this.clinicsDAO.persist(clinicToCreate);
    }

    private void loadAllClinics(){
        this.allClinics = clinicsDAO.loadAll();
    }
}
