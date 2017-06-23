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
public class SurveyService {

  private final DoorRepository doorRepo;
  private final TopicRepository topicRepo;
  private final SurveyResponseRepository surveyResponseRepository;

  public SurveyService(DoorRepository doorRepo, TopicRepository topicRepo,
    SurveyResponseRepository surveyResponseRepository) {
    this.doorRepo = doorRepo;
    this.topicRepo = topicRepo;
    this.surveyResponseRepository = surveyResponseRepository;
  }

  public CreateResult create(SurveyResponse survey, Door door, String user) {
    if (survey.getId() != null) {
      survey.setId(null);
    }

    survey.setCreator(user);
    // we don't save house numbers for responses
    survey.getAddress().setNumber(null);
    surveyResponseRepository.save(survey);

    door.setCreator(user);
    doorRepo.save(door);

    return new CreateResult(door.getId(), survey.getId());
  }

  public List<SurveyResponse> getAll() {
    return surveyResponseRepository.findAll();
  }

  public SurveyResponse getSurveyResponseById(final Long id) {
    return surveyResponseRepository.findOne(id);
  }

  public static class CreateResult {

    long surveyId;
    long doorId;

    public CreateResult(long surveyId, long doorId) {
      this.surveyId = surveyId;
      this.doorId = doorId;
    }

    public long getSurveyId() {
      return surveyId;
    }

    public long getDoorId() {
      return doorId;
    }
  }
}
