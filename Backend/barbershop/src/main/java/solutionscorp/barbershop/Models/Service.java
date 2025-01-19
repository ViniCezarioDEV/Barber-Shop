package solutionscorp.barbershop.Models;


import jakarta.persistence.*;

@Table(name = "service")
@Entity
public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int serviceId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Float price;

    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Schedule schedule;

    //no args constructor
    public Service() {
    }

    //all args constructor
    public Service(int serviceId, String title, Float price, Schedule schedule) {
        this.serviceId = serviceId;
        this.title = title;
        this.price = price;
        this.schedule = schedule;
    }

    //setters & getters
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
