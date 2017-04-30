package de.gruene.haustuer.door;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import de.gruene.haustuer.NotFoundException;
import de.gruene.haustuer.topic.TopicRepository;
import de.gruene.haustuer.user.User;
import de.gruene.haustuer.user.UserRepository;

@Service
@Transactional
public class DoorService {

    private final DoorRepository doorRepo;
    private final TopicRepository topicRepo;
    private final UserRepository userRepository;

    public DoorService(final DoorRepository doorRepo, final UserRepository userRepository,
            final TopicRepository topicRepo) {
        this.doorRepo = doorRepo;
        this.userRepository = userRepository;
        this.topicRepo = topicRepo;
    }

    public Door create(final Door door, final String email) {
        if (door.getId() != null) {
            door.setId(null);
        }

        final User user = this.userRepository.findByEmail(email);
        if (user == null)
            throw new NotFoundException();

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
