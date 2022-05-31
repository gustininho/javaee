package lt.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Clinic;
import lt.vu.entities.Doctor;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.ClinicsDAO;
import lt.vu.persistence.DoctorsDAO;

@Model
public class DoctorsForClinic implements Serializable {

    @Inject
    private ClinicsDAO clinicsDAO;

    @Inject
    private DoctorsDAO doctorsDAO;

    @Getter @Setter
    private Clinic clinic;

    @Getter @Setter
    private Doctor doctorToCreate = new Doctor();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer clinicId = Integer.parseInt(requestParameters.get("clinicId"));
        this.clinic = clinicsDAO.findOne(clinicId);
    }

    @Transactional
    @LoggedInvocation
    public void createDoctor() {
        doctorToCreate.setClinic(this.clinic);
        doctorsDAO.persist(doctorToCreate);
    }

}
