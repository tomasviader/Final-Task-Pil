package com.example.FinalPil.service;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.repository.SupervisorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SupervisorServiceImpl implements SupervisorService{

    @Autowired
    SupervisorRepository supervisorRepository;

    @Override
    public Supervisor saveSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public Supervisor modifySupervisor(Long id, Supervisor supervisor) {
        Supervisor supervisorDB = supervisorRepository.findById(id).get();

        if (Objects.nonNull(supervisor.getSupervisorName())) {
            supervisorDB.setSupervisorName(supervisor.getSupervisorName());
        }

        return supervisorRepository.save(supervisorDB);
    }

    @Override
    public boolean deleteSupervisor(Long id){
        try {
            supervisorRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Supervisor> getSupervisors(){
        return supervisorRepository.findAll();
    }

    @Override
    public Supervisor getSupervisorById(Long id){
        return supervisorRepository.findById(id).get();
    }
}
