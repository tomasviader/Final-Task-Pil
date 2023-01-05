package com.example.FinalPil.repository;

import com.example.FinalPil.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {

    Zone findByName(String name);


    Zone findByNeighborhood(String neighborhood);

}
