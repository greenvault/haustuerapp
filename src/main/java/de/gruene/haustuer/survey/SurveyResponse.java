package de.gruene.haustuer.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.gruene.haustuer.topic.Topic;
import java.time.Instant;
import java.util.Set;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Entity
public class SurveyResponse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Valid
  @Embedded
  private StreetLevelAddress address;
  @JsonIgnore
  private Instant createdAt;
  @NotNull(groups = {Default.class})
  @JsonIgnore
  private String creator;
  @Valid
  @Embedded
  private Geolocation geolocation;

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
  private boolean doorOpened;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public StreetLevelAddress getAddress() {
    return address;
  }

  public void setAddress(StreetLevelAddress address) {
    this.address = address;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Geolocation getGeolocation() {
    return geolocation;
  }

  public void setGeolocation(Geolocation geolocation) {
    this.geolocation = geolocation;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Integer getProbabilityToVote() {
    return probabilityToVote;
  }

  public void setProbabilityToVote(Integer probabilityToVote) {
    this.probabilityToVote = probabilityToVote;
  }

  public Integer getReaction() {
    return reaction;
  }

  public void setReaction(Integer reaction) {
    this.reaction = reaction;
  }

  public Set<Topic> getTopics() {
    return topics;
  }

  public void setTopics(Set<Topic> topics) {
    this.topics = topics;
  }

  public boolean isDoorOpened() {
    return doorOpened;
  }

  public void setDoorOpened(boolean doorOpened) {
    this.doorOpened = doorOpened;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    SurveyResponse that = (SurveyResponse) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "SurveyResponse{" +
      "id=" + id +
      '}';
  }
}
