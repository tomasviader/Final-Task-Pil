package com.example.FinalPil.service;

import com.example.FinalPil.model.Report;
import com.example.FinalPil.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService{

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Report saveReport(Report report){
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    @Override
    public Report getReportById(Long id) {
        return reportRepository.findById(id).get();
    }
}
