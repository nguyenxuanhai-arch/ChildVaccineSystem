package edu.uth.childvaccinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.uth.childvaccinesystem.models.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
