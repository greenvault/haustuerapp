package de.gruene.haustuer.topic;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public List<String> getAll() {
        return topicRepo.findAll().stream().map(topic -> topic.getDescription()).collect(Collectors.toList());
    }

    public Topic save(Topic topic) {
        return topicRepo.save(topic);        
    }

}
