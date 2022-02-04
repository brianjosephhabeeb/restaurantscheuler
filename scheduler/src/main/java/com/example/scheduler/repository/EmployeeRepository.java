package com.example.scheduler.repository;

import com.example.scheduler.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    List<Employee> findByEmployeeId(Long employeeId);
    List<Employee> findByScheduleId(Long scheduleId);
}
