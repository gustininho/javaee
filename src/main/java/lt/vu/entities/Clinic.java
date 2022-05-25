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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Clinic.findAll", query = "select c from Clinic as c")
})
@Table(name="CLINIC")
@Getter @Setter
public class Clinic {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Size(max = 50)
    @Column(name="TITLE")
    private String title;

    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctors = new ArrayList<>();

    public void init() {
        System.out.println(toString() + " constructed.");
    }

    public void setId(int id) {
        this.id = id;
    }
}