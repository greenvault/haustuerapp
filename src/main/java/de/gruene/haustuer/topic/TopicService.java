package de.gruene.haustuer.topic;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TopicService {
    
    private TopicRepository topicRepo;
    
    @Autowired
    public TopicService(TopicRepository topicRepo) {
        super();
        this.topicRepo = topicRepo;
    }

    public List<Topic> getAll() {
        return topicRepo.findAll();
    }

    public Topic save(Topic topic) {
        return topicRepo.save(topic);        
    }

}
