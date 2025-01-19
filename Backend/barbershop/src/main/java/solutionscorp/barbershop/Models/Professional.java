package solutionscorp.barbershop.Models;


import jakarta.persistence.*;

@Table(name = "professional")
@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professional_id")
    private int professionalId;

    @Column(name = "name")
    String name;

    @Column(name = "last_name")
    String lastName;

    @OneToOne(mappedBy = "professional", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Schedule schedule;

    //no args constructor
    public Professional() {
    }

    //all args constructor
    public Professional(int professionalId, String name, String lastName, Schedule schedule) {
        this.professionalId = professionalId;
        this.name = name;
        this.lastName = lastName;
        this.schedule = schedule;
    }

    //setters & getters
    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
