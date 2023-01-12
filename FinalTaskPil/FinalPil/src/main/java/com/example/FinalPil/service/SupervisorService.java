package com.example.FinalPil.service;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SupervisorService  {

    Supervisor saveSupervisor(Supervisor supervisor);

    Supervisor modifySupervisor(Long id, Supervisor supervisor);

    boolean deleteSupervisor(Long id);

    List<Supervisor> getSupervisors();

    Supervisor getSupervisorById(Long id);
}
