import edu.uth.childvaccinesystem.models.Vaccine;
import edu.uth.childvaccinesystem.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

package edu.uth.childvaccinesystem.services;

public class VaccineService {
    @Service
    public class VaccineService {

        @Autowired
        private VaccineRepository vaccineRepository;

        public List<Vaccine> getAllVaccines() {
            return vaccineRepository.findAll();
        }

        public Optional<Vaccine> getVaccineById(Long id) {
            return vaccineRepository.findById(id);
        }

        public Vaccine saveVaccine(Vaccine vaccine) {
            return vaccineRepository.save(vaccine);
        }

        public void deleteVaccine(Long id) {
            vaccineRepository.deleteById(id);
        }
    }
}
