package solutionscorp.barbershop.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import solutionscorp.barbershop.DTO.ScheduleDTO;
import solutionscorp.barbershop.Models.BarberService;
import solutionscorp.barbershop.Models.Professional;
import solutionscorp.barbershop.Models.Schedule;
import solutionscorp.barbershop.Models.User;
import solutionscorp.barbershop.Repository.ProfessionalRepository;
import solutionscorp.barbershop.Repository.ScheduleRepository;
import solutionscorp.barbershop.Repository.ServiceRepository;
import solutionscorp.barbershop.Repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    private static final LocalTime START_TIME = LocalTime.of(9, 0); // Starting work
    private static final LocalTime END_TIME = LocalTime.of(18, 0); // Ending Work
    private static final int SLOT_DURATION = 30; // Duration of each time (in minutes)

    public List<LocalTime> getAvailableTimes(LocalDate date) {

        // Times has schedule on database using date
        List<LocalTime> bookedTimes = scheduleRepository.findBookedTimesByDate(date);

        // Generate all schedules possible
        List<LocalTime> allTimes = new ArrayList<>();
        LocalTime time = START_TIME;
        while (time.isBefore(END_TIME)) {
            allTimes.add(time);
            time = time.plusMinutes(SLOT_DURATION);
        }

        // Filter Availables Schedules
        return allTimes.stream()
                .filter(t -> !bookedTimes.contains(t))
                .collect(Collectors.toList());
    }



    public void bookSchedule(ScheduleDTO scheduleDTO) {

        Professional professional = professionalRepository.findById(scheduleDTO.getProfessional().getProfessionalId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professional not found"));

        User user = userRepository.findById(scheduleDTO.getUser().getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        BarberService barberService = serviceRepository.findById(scheduleDTO.getBarberService().getBarberServiceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Barber service not found"));


        Optional<Schedule> existingSchedule = scheduleRepository
                .findByBarberService_BarberServiceIdAndDateAndTime(
                        scheduleDTO.getBarberService().getBarberServiceId(),
                        scheduleDTO.getDate(),
                        scheduleDTO.getTime()
                );

        if (existingSchedule.isPresent()) {
            throw new RuntimeException("Already a schedule for this service, date and time.");
        }



        // Saving Schedule on database
        Schedule schedule = new Schedule();
        schedule.setUser(scheduleDTO.getUser());
        schedule.setProfissional(scheduleDTO.getProfessional());
        schedule.setBarberService(scheduleDTO.getBarberService());
        schedule.setDate(scheduleDTO.getDate());
        schedule.setTime(scheduleDTO.getTime());

        scheduleRepository.save(schedule);
    }


}
