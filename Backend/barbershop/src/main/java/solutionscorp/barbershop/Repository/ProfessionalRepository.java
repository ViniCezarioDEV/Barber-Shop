package solutionscorp.barbershop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutionscorp.barbershop.Models.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {
}
