package solutionscorp.barbershop.Models;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "barber_service")
@Entity
public class BarberService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barber_service_id")
    private Integer barberServiceId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Float price;

    @OneToMany(mappedBy = "barberService", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)  // Alterei de OneToOne para OneToMany
    private List<Schedule> schedules;

    //no args constructor
    public BarberService() {
    }

    //all args constructor
    public BarberService(Integer barberServiceId, String title, Float price, List<Schedule> schedules) {
        this.barberServiceId = barberServiceId;
        this.title = title;
        this.price = price;
        this.schedules = schedules;
    }

    //setters & getters
    public Integer getBarberServiceId() {
        return barberServiceId;
    }

    public void setBarberServiceId(Integer barberServiceId) {
        this.barberServiceId = barberServiceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
