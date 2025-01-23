package solutionscorp.barbershop.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solutionscorp.barbershop.DTO.ScheduleDTO;
import solutionscorp.barbershop.Services.ScheduleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Get all available times
    @PostMapping("/available-times")
    public ResponseEntity<List<LocalTime>> getAvailableTimes(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<LocalTime> availableTimes = scheduleService.getAvailableTimes(date);
        return ResponseEntity.ok(availableTimes);
    }

    // make a schedule
    @PostMapping("/book")
    public ResponseEntity<String> bookSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.bookSchedule(scheduleDTO);
        return ResponseEntity.ok("Scheduling completed successfully");
    }

}
