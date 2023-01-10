package com.example.FinalPil.service;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;
import com.example.FinalPil.repository.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupervisorServiceImpl implements SupervisorService{

    @Autowired
    SupervisorRepository supervisorRepository;

    @Override
    public Supervisor saveSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }
}
