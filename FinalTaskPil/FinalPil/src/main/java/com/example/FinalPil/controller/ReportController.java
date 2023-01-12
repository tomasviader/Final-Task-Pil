package com.example.FinalPil.controller;

import com.example.FinalPil.model.Report;
import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
