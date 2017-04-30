package de.gruene.haustuer.door;

import de.gruene.haustuer.NotFoundException;
import de.gruene.haustuer.user.User;
import de.gruene.haustuer.user.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoorService {

  private final DoorRepository doorRepo;
  private final UserRepository userRepository;

  public DoorService(DoorRepository doorRepo, UserRepository userRepository) {
    this.doorRepo = doorRepo;
    this.userRepository = userRepository;
  }

  public Door getDoorById(Long id) {
    return doorRepo.findOne(id);
  }

  public Door create(Door door, String email) {
    if (door.getId() != null) {
      door.setId(null);
    }

    User user = userRepository.findByEmail(email);
    if(user == null)
      throw new NotFoundException();

    door.setCreator(user);
    doorRepo.save(door);
    return door;
  }

  public List<Door> getAll() {
    return doorRepo.findAll();
  }
}
