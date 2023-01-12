package com.example.FinalPil.controller;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;
import com.example.FinalPil.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supervisors")
@RequiredArgsConstructor
public class SupervisorController {
    @Autowired
    SupervisorService supervisorService;

    @PostMapping
    public Supervisor saveSupervisor(@RequestBody Supervisor supervisor){
        return supervisorService.saveSupervisor(supervisor);
    }

    @PutMapping("/{id}")
    public Supervisor modifySupervisor(@PathVariable Long id, @RequestBody Supervisor supervisor) {
        return supervisorService.modifySupervisor(id, supervisor);
    }

    @DeleteMapping("{id}")
    public String deleteSupervisor(@PathVariable Long id){
        boolean ok = supervisorService.deleteSupervisor(id);
        if (ok){
           return "Supervisor with id " + id + " deleted";
        }else {
            return "Cannot delete Supervisor with id " + id;
        }
    }

    @GetMapping
    public List<Supervisor> getSupervisors(){
        return supervisorService.getSupervisors();
    }

    @GetMapping("/{id}")
    public Supervisor getSupervisorById(@PathVariable Long id){
        return supervisorService.getSupervisorById(id);
    }
}
