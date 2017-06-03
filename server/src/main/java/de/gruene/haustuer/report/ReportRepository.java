package de.gruene.haustuer.report;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ReportRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Map<String, Object>> getTopTenReport() {
    return jdbcTemplate.queryForList(
        "SELECT u.email, count(d.creator_id) FROM usr u INNER JOIN door d ON (u.id = d.creator_id) "
            + "GROUP BY u.email ORDER BY count(d.creator_id) DESC LIMIT 10");
  }
}
