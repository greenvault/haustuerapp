package de.gruene.haustuer.door;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoorService {

  @Autowired
  DoorRepository doorRepo;

  public Door getDoorById(Long id) {
    return doorRepo.findOne(id);
  }

  public Door create(Door door) {
    if (door.getId() != null) {
      door.setId(null);
    }
    doorRepo.save(door);
    return door;
  }

  public List<Door> getAll() {
    return doorRepo.findAll();
  }
}
