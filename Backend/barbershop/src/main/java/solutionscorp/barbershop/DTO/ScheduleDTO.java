package solutionscorp.barbershop.DTO;




import jakarta.validation.constraints.NotNull;

import solutionscorp.barbershop.Models.Professional;
import solutionscorp.barbershop.Models.BarberService;
import solutionscorp.barbershop.Models.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDTO {

    @NotNull(message = "User is required")
    private User user;

    @NotNull(message = "Professional is required")
    private Professional professional;

    @NotNull(message = "BarberService is required")
    private BarberService barberService;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Time is required")
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
