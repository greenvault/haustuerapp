package de.gruene.haustuer.door;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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

  public Door save(Door door) {
    doorRepo.save(door);
    return door;
  }

  public List<Door> getAll() {
    return doorRepo.findAll();
  }
}
