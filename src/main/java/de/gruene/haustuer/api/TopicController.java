package de.gruene.haustuer.api;

import de.gruene.haustuer.topic.Topic;
import de.gruene.haustuer.topic.TopicService;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/topic")
public class TopicController {

    private static Logger logger = LoggerFactory.getLogger(DoorController.class);

    @Autowired
    private TopicService topicService;

    @PostMapping
    public Topic createTopic(@Valid @RequestBody final Topic topic) {
        return this.topicService.save(topic);
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return this.topicService.getAll();
    }

}
