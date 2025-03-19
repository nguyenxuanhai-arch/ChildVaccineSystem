package edu.uth.childvaccinesystem.repositories;

import edu.uth.childvaccinesystem.models.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    
}
