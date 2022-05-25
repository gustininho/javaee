package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "Doctor.findAll", query = "select a from Doctor as a")
})
@Entity
@Table(name="DOCTOR")
public class Doctor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="CLINIC_ID")
    private Clinic clinic;

    public String sakykLabas() {
        return "Labas " + new Date() + " " + toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}