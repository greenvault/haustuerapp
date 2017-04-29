package de.gruene.haustuer.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import de.gruene.haustuer.door.Door;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
