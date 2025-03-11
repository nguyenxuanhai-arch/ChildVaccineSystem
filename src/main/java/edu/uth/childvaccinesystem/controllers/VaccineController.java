import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uth.childvaccinesystem.models.Vaccine;
import edu.uth.childvaccinesystem.services.VaccineService;
import java.util.List;

package edu.uth.childvaccinesystem.controllers;



@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    public List<Vaccine> getAllVaccines() {
        return vaccineService.getAllVaccines();
    }

    @GetMapping("/{id}")
    public Vaccine getVaccineById(@PathVariable Long id) {
        return vaccineService.getVaccineById(id);
    }

    @PostMapping
    public Vaccine createVaccine(@RequestBody Vaccine vaccine) {
        return vaccineService.createVaccine(vaccine);
    }

    @PutMapping("/{id}")
    public Vaccine updateVaccine(@PathVariable Long id, @RequestBody Vaccine vaccine) {
        return vaccineService.updateVaccine(id, vaccine);
    }

    @DeleteMapping("/{id}")
    public void deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
    }
}