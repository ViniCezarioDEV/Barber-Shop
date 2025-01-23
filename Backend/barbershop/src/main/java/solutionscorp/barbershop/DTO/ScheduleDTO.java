package solutionscorp.barbershop.DTO;

import solutionscorp.barbershop.Models.Professional;
import solutionscorp.barbershop.Models.Service;
import solutionscorp.barbershop.Models.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDTO {

    private User user;
    private Professional professional;
    private Service service;
    private LocalDate date;
    private LocalTime time;


    //setters & getters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
