package solutionscorp.barbershop.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutionscorp.barbershop.DTO.ScheduleDTO;
import solutionscorp.barbershop.Models.Schedule;
import solutionscorp.barbershop.Repository.ScheduleRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

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

        // Saving Schedule on database
        Schedule schedule = new Schedule();
        schedule.setUser(scheduleDTO.getUser());
        schedule.setProfissional(scheduleDTO.getProfessional());
        schedule.setService(scheduleDTO.getService());
        schedule.setDate(scheduleDTO.getDate());
        schedule.setTime(scheduleDTO.getTime());

        scheduleRepository.save(schedule);
    }


}
