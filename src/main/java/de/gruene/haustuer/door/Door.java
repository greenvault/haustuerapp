package de.gruene.haustuer.door;

import java.time.Instant;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Door {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Valid
  @Embedded
  private Geolocation geolocation;

  @NotNull
  @Valid
  @Embedded
  private Address address;

  private boolean doorOpened;
  @Min(1)
  @Max(5)
  @NotNull
  private Integer reaction;
  @Min(1)
  @Max(10)
  @NotNull
  private Integer probabilityToVote;
  private String notes;
  private Instant createdAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Geolocation getGeolocation() {
    return geolocation;
  }

  public void setGeolocation(Geolocation geolocation) {
    this.geolocation = geolocation;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public boolean isDoorOpened() {
    return doorOpened;
  }

  public void setDoorOpened(boolean doorOpened) {
    this.doorOpened = doorOpened;
  }

  public int getReaction() {
    return reaction;
  }

  public void setReaction(int reaction) {
    this.reaction = reaction;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public int getProbabilityToVote() {
    return probabilityToVote;
  }

  public void setProbabilityToVote(int probabilityToVote) {
    this.probabilityToVote = probabilityToVote;
  }

  @Override
  public String toString() {
    return "Door{" +
        "id=" + id +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Door door = (Door) o;

    return id != null ? id.equals(door.id) : door.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
