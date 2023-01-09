package com.example.FinalPil.controller;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;
import com.example.FinalPil.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
