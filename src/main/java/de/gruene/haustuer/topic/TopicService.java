package de.gruene.haustuer.topic;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TopicService {

    private final TopicRepository topicRepo;

    @Autowired
    public TopicService(final TopicRepository topicRepo) {
        super();
        this.topicRepo = topicRepo;
    }

    public List<Topic> getAll() {
        return this.topicRepo.findAll();
    }

    public Topic save(final Topic topic) {
        return this.topicRepo.save(topic);
    }

}
