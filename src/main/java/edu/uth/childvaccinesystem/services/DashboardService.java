package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.repositories.UserRepository;
import edu.uth.childvaccinesystem.repositories.AppointmentRepository;
import edu.uth.childvaccinesystem.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    public long getUserCount() {
        return userRepository.count();
    }

    public long getAppointmentCount() {
        return appointmentRepository.count();
    }

    public long getVaccineCount() {
        return vaccineRepository.count();
    }
}
