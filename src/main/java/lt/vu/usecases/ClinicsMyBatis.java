package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.model.Clinic;
import lt.vu.mybatis.dao.ClinicMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ClinicsMyBatis {
    private ClinicMapper clinicMapper;

    @Getter
    private List<Clinic> allClinics;

    @Getter @Setter
    private Clinic clinicToCreate = new Clinic();

    @PostConstruct
    public void init() {
        this.loadAllClinics();
    }

    private void loadAllClinics() {
        this.allClinics = clinicMapper.selectAll();
    }

    @Transactional
    public String createClinic() {
        clinicMapper.insert(clinicToCreate);
        return "/myBatis/clinics?faces-redirect=true";
    }
}
