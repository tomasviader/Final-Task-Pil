package com.example.FinalPil.service;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;

public interface SupervisorService {

    Supervisor saveSupervisor(Supervisor supervisor);

    Supervisor modifySupervisor(Long id, Supervisor supervisor);

    boolean deleteSupervisor(Long id);

}
