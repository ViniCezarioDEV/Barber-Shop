package solutionscorp.barbershop.Models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "professional")
@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professional_id")
    private Integer professionalId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules = new ArrayList<>();

    //no args constructor
    public Professional() {
    }

    //all args constructor
    public Professional(Integer professionalId, String name, String lastName, List<Schedule> schedules) {
        this.professionalId = professionalId;
        this.name = name;
        this.lastName = lastName;
        this.schedules = schedules;
    }

    //setters & getters
    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
