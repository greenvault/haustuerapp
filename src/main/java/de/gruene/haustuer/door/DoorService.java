package de.gruene.haustuer.door;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import de.gruene.haustuer.NotFoundException;
import de.gruene.haustuer.topic.TopicRepository;

@Service
@Transactional
public class DoorService {

    private final DoorRepository doorRepo;
    private final TopicRepository topicRepo;

    public DoorService(final DoorRepository doorRepo,
            final TopicRepository topicRepo) {
        this.doorRepo = doorRepo;
        this.topicRepo = topicRepo;
    }

    public Door create(final Door door, final String user) {
        if (door.getId() != null) {
            door.setId(null);
        }

        door.setCreator(user);
        // System.out.println(door.get);
        this.doorRepo.save(door);

        door.setTopics(new HashSet<>(this.topicRepo
                .findAll(door.getTopics().stream().map(topic -> topic.getId()).collect(Collectors.toList()))));
        return door;
    }

    public List<Door> getAll() {
        return this.doorRepo.findAll();
    }

    public Door getDoorById(final Long id) {
        return this.doorRepo.findOne(id);
    }
}
