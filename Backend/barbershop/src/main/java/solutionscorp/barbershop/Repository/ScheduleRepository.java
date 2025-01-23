package solutionscorp.barbershop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import solutionscorp.barbershop.Models.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query("SELECT a.time FROM Schedule a WHERE a.date = :date")
    List<LocalTime> findBookedTimesByDate(@Param("date") LocalDate date);

}
