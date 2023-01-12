package com.example.FinalPil.service;

import com.example.FinalPil.model.Report;
import com.example.FinalPil.model.Zone;
import com.example.FinalPil.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService{

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Report saveReport(Report report){
        return reportRepository.save(report);
    }
}
