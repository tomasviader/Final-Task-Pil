package com.example.FinalPil.controller;

import com.example.FinalPil.model.Report;
import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.repository.ZoneRepository;
import com.example.FinalPil.service.ReportService;
import com.example.FinalPil.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
@RequiredArgsConstructor
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping
    public Report saveReport(@RequestBody Report report){
        return reportService.saveReport(report);
    }

    @GetMapping
    public List<Report> getReports(){
        return reportService.getReports();
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id){
        return reportService.getReportById(id);
    }

    @PutMapping("/{id}")
    public Report modifyReport(@PathVariable Long id, @RequestBody Report report){
        return reportService.modifyReport(id,report);
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
        return "Report deleted succefully.";
    }
}
