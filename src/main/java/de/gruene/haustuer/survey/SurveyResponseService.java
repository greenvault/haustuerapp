package de.gruene.haustuer.survey;

import de.gruene.haustuer.topic.Topic;
import de.gruene.haustuer.topic.TopicRepository;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SurveyResponseService {

  private final DoorRepository doorRepo;
  private final TopicRepository topicRepo;
  private final SurveyResponseRepository surveyResponseRepository;

  public SurveyResponseService(DoorRepository doorRepo, TopicRepository topicRepo,
    SurveyResponseRepository surveyResponseRepository) {
    this.doorRepo = doorRepo;
    this.topicRepo = topicRepo;
    this.surveyResponseRepository = surveyResponseRepository;
  }

  public SurveyResponse create(SurveyResponse survey, String user) {
    if (survey.getId() != null) {
      survey.setId(null);
    }

    survey.setCreator(user);
    createDoor(survey);

    // we don't save house numbers for responses
    survey.getAddress().setNumber(null);
    surveyResponseRepository.save(survey);

    survey.setTopics(new HashSet<>(
      topicRepo.findAll(survey.getTopics().stream().map(Topic::getId).collect(Collectors.toSet()))
    ));


    return survey;
  }

  private void createDoor(SurveyResponse survey) {
    Door door = new Door();
    door.setAddress(new Address(survey.getAddress()));
    door.setCreatedAt(survey.getCreatedAt());
    door.setCreator(survey.getCreator());
    door.setGeolocation(survey.getGeolocation());
    doorRepo.save(door);
  }

  public List<SurveyResponse> getAll() {
    return surveyResponseRepository.findAll();
  }

  public SurveyResponse getSurveyResponseById(final Long id) {
    return surveyResponseRepository.findOne(id);
  }
}
