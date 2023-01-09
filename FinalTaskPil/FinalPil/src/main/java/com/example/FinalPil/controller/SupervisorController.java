package com.example.FinalPil.controller;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;
import com.example.FinalPil.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
