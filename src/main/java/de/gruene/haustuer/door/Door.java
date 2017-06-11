package de.gruene.haustuer.door;


import com.fasterxml.jackson.annotation.JsonIgnore;
import de.gruene.haustuer.topic.Topic;
import de.gruene.haustuer.user.User;
import java.time.Instant;
import java.util.Set;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Entity
public class Door {

  public interface UserWritable {

  }

  @NotNull
  @Valid
  @Embedded
  private Address address;

  private Instant createdAt;

  @ManyToOne
  @NotNull(groups = {Default.class})
  @JsonIgnore
  private User creator;

  private boolean doorOpened;
  @Valid
  @Embedded
  private Geolocation geolocation;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String notes;
  @Min(1)
  @Max(10)
  @NotNull(groups = {Default.class, UserWritable.class})
  private Integer probabilityToVote;

  @Min(1)
  @Max(5)
  @NotNull(groups = {Default.class, UserWritable.class})
  private Integer reaction;

  @ManyToMany(targetEntity = Topic.class, fetch = FetchType.EAGER)
  private Set<Topic> topics;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    final Door door = (Door) o;

    return this.id != null ? this.id.equals(door.id) : door.id == null;
  }

  public Address getAddress() {
    return this.address;
  }

  public Instant getCreatedAt() {
    return this.createdAt;
  }

  public User getCreator() {
    return this.creator;
  }

  public Geolocation getGeolocation() {
    return this.geolocation;
  }

  public Long getId() {
    return this.id;
  }

  public String getNotes() {
    return this.notes;
  }

  public int getProbabilityToVote() {
    return this.probabilityToVote;
  }

  public int getReaction() {
    return this.reaction;
  }

  public Set<Topic> getTopics() {
    return this.topics;
  }

  @Override
  public int hashCode() {
    return this.id != null ? this.id.hashCode() : 0;
  }

  public boolean isDoorOpened() {
    return this.doorOpened;
  }

  public void setAddress(final Address address) {
    this.address = address;
  }

  public void setCreatedAt(final Instant createdAt) {
    this.createdAt = createdAt;
  }

  public void setCreator(final User creator) {
    this.creator = creator;
  }

  public void setDoorOpened(final boolean doorOpened) {
    this.doorOpened = doorOpened;
  }

  public void setGeolocation(final Geolocation geolocation) {
    this.geolocation = geolocation;
  }

  void setId(final Long id) {
    this.id = id;
  }

  public void setNotes(final String notes) {
    this.notes = notes;
  }

  public void setProbabilityToVote(final int probabilityToVote) {
    this.probabilityToVote = probabilityToVote;
  }

  public void setReaction(final int reaction) {
    this.reaction = reaction;
  }

  public void setTopics(final Set<Topic> topics) {
    this.topics = topics;
  }

  @Override
  public String toString() {
    return "Door{" + "id=" + this.id + '}';
  }
}
