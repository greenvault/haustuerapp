package de.gruene.haustuer.door;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoorService {

  public Door getDoorById(Long id) {
    Door door = new Door();
    door.setId(1L);
    return door;
  }

  public void save(Door door) {

  }
}
