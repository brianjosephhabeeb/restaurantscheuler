package com.example.scheduler.controller;

import com.example.scheduler.model.Employee;
import com.example.scheduler.model.Schedule;
import com.example.scheduler.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ScheduleController {

    private ScheduleService scheduleService;


    @GetMapping("/hello-world/")
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping("/schedules")
    public Schedule createSchedule(@RequestBody Schedule scheduleObject){
        return scheduleService.createSchedule(scheduleObject);
    }

    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules/")
    public List<Schedule> getSchedule(){
        return scheduleService.getSchedule();
    }

    @GetMapping("/schedules/{scheduleId}")
    public Optional getSchedule(@PathVariable Long scheduleId){
        return scheduleService.getSchedule(scheduleId);
    }

    @PutMapping("/schedules/{scheduleId}")
    public Schedule updateSchedule(@PathVariable(
            value = "scheduleId") Long scheduleId, @RequestBody Schedule scheduleObject) {
        return scheduleService.updateSchedule(scheduleId, scheduleObject);
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public Optional<Schedule> deleteSchedule(@PathVariable(value = "scheduleId") Long scheduleId) {
        return scheduleService.deleteSchedule(scheduleId);
    }

    @PostMapping("/schedules/{scheduleId}/employees/")
    public Employee createScheduleEmployee(@PathVariable(value = "scheduleId")Long scheduleId, @RequestBody Employee employeeObject){
        return scheduleService.createScheduleEmployee(scheduleId, employeeObject);
    }

    @GetMapping("/schedules/{scheduleId}/employees")
    public List<Employee> getScheduleEmployees(@PathVariable(value = "scheduleId") Long scheduleId) {
        return scheduleService.getScheduleEmployees(scheduleId);
    }

    @GetMapping("/schedules/{scheduleId}/employees/{employeeId}/")
    public Employee getScheduleEmployee(@PathVariable(value = "scheduleId") Long scheduleId, @PathVariable(value = "employeeId") Long employeeId){
        return scheduleService.getScheduleEmployee(scheduleId, employeeId);
    }

    @PutMapping("/schedules/{scheduleId}/employees/{employeeId}/")
    public Employee updateScheduleEmployee(@PathVariable(value = "scheduleId") Long scheduleId,
                                       @PathVariable(value = "employeeId") Long employeeId,
                                       @RequestBody Employee employeeObject) {
        return scheduleService.updateScheduleEmployee(scheduleId, employeeId, employeeObject);
    }

    @DeleteMapping("/schedules/{scheduleId}/employees/{employeeId}/")
    public ResponseEntity<HashMap> deleteScheduleEmployee(
            @PathVariable(value = "scheduleId") Long scheduleId, @PathVariable(value = "employeeId") Long employeeId) {
        scheduleService.deleteScheduleEmployee(scheduleId, employeeId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "employee with id: " + employeeId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }

}
