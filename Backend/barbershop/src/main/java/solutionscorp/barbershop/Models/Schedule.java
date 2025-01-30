package solutionscorp.barbershop.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "schedule")
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;

    @ManyToOne
    @JoinColumn(name = "barber_service_id")
    private BarberService barberService;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    //no args constructor
    public Schedule() {
    }

    //all args constructor
    public Schedule(Integer scheduleId, User user, Professional professional, BarberService barberService, LocalDate date, LocalTime time) {
        this.scheduleId = scheduleId;
        this.user = user;
        this.professional = professional;
        this.barberService = barberService;
        this.date = date;
        this.time = time;
    }

    //setters & getters
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfissional(Professional professional) {
        this.professional = professional;
    }

    public BarberService getBarberService() {
        return barberService;
    }

    public void setBarberService(BarberService barberService) {
        this.barberService = barberService;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
