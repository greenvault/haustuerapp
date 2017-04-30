package de.gruene.haustuer.report;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

  private ReportRepository reportRepository;

  @Autowired
  public ReportService(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  public List<Map<String, Object>> reportTopTen() {
    return reportRepository.getTopTenReport();
  }
}
