package de.gruene.haustuer.api;

import de.gruene.haustuer.survey.SurveyResponse;
import de.gruene.haustuer.survey.SurveyResponseService;
import de.gruene.haustuer.survey.UserWritable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/survey")
public class SurveyResponseController {

  private static Logger logger = LoggerFactory.getLogger(SurveyResponseController.class);

  @Autowired
  SurveyResponseService surveyResponseService;

  @GetMapping
  public List<SurveyResponse> getSurveyResponses(@RequestParam(required = false) String district) {
    logger.info("Value of district={}", district);

    return surveyResponseService.getAll();
  }

  @GetMapping("{id}")
  public SurveyResponse getSurveyResponse(@PathVariable Long id) {
    return surveyResponseService.getSurveyResponseById(id);
  }

  @PostMapping
  public SurveyResponse recordSurveyResponse(@Validated({UserWritable.class}) @RequestBody SurveyResponse surveyResponse,
      Authentication authentication) {
    return surveyResponseService.create(surveyResponse, authentication.getName());
  }

}
