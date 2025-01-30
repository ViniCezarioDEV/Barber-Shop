package solutionscorp.barbershop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutionscorp.barbershop.Models.BarberService;

@Repository
public interface ServiceRepository extends JpaRepository<BarberService, Integer> {
}
