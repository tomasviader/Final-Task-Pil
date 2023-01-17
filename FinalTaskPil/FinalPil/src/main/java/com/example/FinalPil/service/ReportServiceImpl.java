package com.example.FinalPil.service;

import com.example.FinalPil.model.Report;
import com.example.FinalPil.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Report modifyReport(Long id, Report report) {
        Report reportDB = reportRepository.findById(id).get();

        if (Objects.nonNull(report.getSupervisor())){
            reportDB.setSupervisor(report.getSupervisor());
        }

        if (Objects.nonNull(report.getZone())){
            reportDB.setZone(report.getZone());
        }

        if (Objects.nonNull(report.getCapacity())){
            reportDB.setCapacity(report.getCapacity());
        }

        if (Objects.nonNull(report.isNeedResorting())){
            reportDB.setNeedResorting(report.isNeedResorting());
        }

        if (Objects.nonNull(report.getZoneState())){
            reportDB.setZoneState(report.getZoneState());
        }

        if (Objects.nonNull(report.getComplaint())){
            reportDB.setComplaint(report.getComplaint());
        }

        return reportRepository.save(reportDB);
    }

    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
