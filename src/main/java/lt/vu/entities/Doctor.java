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

@Entity
@Table(name="DOCTOR")
public class Doctor implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", length=50, nullable=false, unique=false)
    private String name;

    public String sakykLabas() {
        return "Labas " + new Date() + " " + toString();
    }

    public void init() {
        System.out.println(toString() + " constructed.");
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}