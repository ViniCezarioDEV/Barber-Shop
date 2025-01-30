package solutionscorp.barbershop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutionscorp.barbershop.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
