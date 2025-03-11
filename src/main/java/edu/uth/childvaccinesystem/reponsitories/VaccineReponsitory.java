import edu.uth.childvaccinesystem.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

package edu.uth.childvaccinesystem.repositories;


@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    // Add custom query methods if needed
}