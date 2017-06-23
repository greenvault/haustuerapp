package de.gruene.haustuer.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Topic {

  @Id
  @Size(min = 1, max = 255)
  private String key;

  @NotNull
  @Size(min = 1, max = 10000)
  private String description;

  public Topic() {
  }

  public Topic(String key, String description) {
    this.key = key;
    this.description = description;
  }

  public Topic(Topic other) {
    this.key = other.key;
    this.description = other.description;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Topic topic = (Topic) o;

    return key.equals(topic.key);
  }

  @Override
  public int hashCode() {
    return key.hashCode();
  }
}
