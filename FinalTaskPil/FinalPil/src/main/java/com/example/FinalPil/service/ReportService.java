package com.example.FinalPil.service;

import com.example.FinalPil.model.Report;

import java.util.List;

public interface ReportService {

    Report saveReport(Report report);

    List<Report> getReports();

    Report getReportById(Long id);

    Report modifyReport(Long id, Report report);
}
