package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Doctor;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.DoctorsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateDoctor implements Serializable {

    private Doctor doctor;

    @Inject
    private DoctorsDAO doctorsDAO;

    @PostConstruct
    private void init() {
        System.out.println("Update Doctor INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(requestParameters.get("doctorId"));
        this.doctor = doctorsDAO.findOne(id);
    }

    @Transactional
    @LoggedInvocation
    public String updateName() {
        try{
            doctorsDAO.update(this.doctor);
        } catch (OptimisticLockException e) {
            return "/doctorDetails.xhtml?faces-redirect=true&doctorId=" + this.doctor.getId() + "&error=optimistic-lock-exception";
        }
        return "doctors.xhtml?clinicId=" + this.doctor.getClinic().getId() + "&faces-redirect=true";
    }
}