package com.example.scheduler.service;


import com.example.scheduler.exceptions.InformationExistException;
import com.example.scheduler.exceptions.InformationNotFoundException;
import com.example.scheduler.model.Employee;
import com.example.scheduler.model.Schedule;
import com.example.scheduler.repository.EmployeeRepository;
import com.example.scheduler.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Schedule> getSchedule() {
        return scheduleRepository.findAll();
    }

    public Optional getSchedule(Long scheduleId) {
        Optional schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            return schedule;
        } else {
            throw new InformationNotFoundException("schedule with id " + scheduleId + " not found");
        }
    }

    public Schedule createSchedule(Schedule scheduleObject) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleObject.getId());
        if (schedule.isPresent()) {
            throw new InformationExistException("schedule with id " + schedule.get() + " already exists");
        } else {
            return scheduleRepository.save(scheduleObject);
        }
    }

    public Schedule updateSchedule(Long scheduleId, Schedule scheduleObject) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            if (scheduleObject.getId().equals(schedule.get().getId())) {
                throw new InformationExistException("schedule " + schedule.get().getId() + " is already exists");
            } else {
                Schedule updateSchedule = scheduleRepository.findById(scheduleId).get();
                updateSchedule.setId(scheduleObject.getId());
                return scheduleRepository.save(updateSchedule);
            }
        } else {
            throw new InformationNotFoundException("schedule with id " + scheduleId + " not found");
        }
    }

    public Optional<Schedule> deleteSchedule(Long scheduleId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);

        if (schedule.isPresent()) {
            scheduleRepository.deleteById(scheduleId);
            return schedule;
        } else {
            throw new InformationNotFoundException("schedule with id " + scheduleId + " not found");
        }
    }

    public Employee createScheduleEmployee(Long scheduleId, Employee employeeObject) {
        try {
            Optional schedule = scheduleRepository.findById(scheduleId);
            employeeObject.setSchedule((Schedule) schedule.get());
            return employeeRepository.save(employeeObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("schedule with id " + scheduleId + " not found");
        }
    }

    public List<Employee> getScheduleEmployees(Long scheduleId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            return schedule.get().getEmployeeList();
        } else {
            throw new InformationNotFoundException("schedule with id " + scheduleId + " not found");
        }
    }

    public Employee getScheduleEmployee(Long scheduleId, Long employeeId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            Optional<Employee> employee = employeeRepository.findByScheduleId(scheduleId).stream().filter(
                    p -> p.getId().equals(employeeId)).findFirst();
            if (employee.isEmpty()) {
                throw new InformationNotFoundException("employee with id " + employeeId + " not found");
            } else {
                return employee.get();
            }
        } else {
            throw new InformationNotFoundException("schedule with id " + scheduleId + " not found");
        }
    }


    public Employee updateScheduleEmployee(Long scheduleId, Long employeeId, Employee employeeObject) {
        try {
            Employee employee = (employeeRepository.findByScheduleId(
                    scheduleId).stream().filter(p -> p.getId().equals(employeeId)).findFirst()).get();
            employee.setName(employeeObject.getName());
            employee.setWage(employeeObject.getWage());
            employee.setAvailable(employeeObject.getAvailable());
            return employeeRepository.save(employee);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("employee or schedule not found");
        }
    }

    public void deleteScheduleEmployee(Long scheduleId, Long employeeId) {
        try {
            Employee employee = (employeeRepository.findByScheduleId(
                    scheduleId).stream().filter(p -> p.getId().equals(employeeId)).findFirst()).get();
            employeeRepository.deleteById(employee.getId());
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("employee or schedule not found");
        }
    }
}
