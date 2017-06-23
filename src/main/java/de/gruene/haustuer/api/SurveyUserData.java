package de.gruene.haustuer.api;

import de.gruene.haustuer.survey.Address;
import de.gruene.haustuer.survey.Door;
import de.gruene.haustuer.survey.Geolocation;
import de.gruene.haustuer.survey.SurveyResponse;
import de.gruene.haustuer.topic.Topic;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SurveyUserData {

  @NotNull
  @Valid
  private Address address;
  private String notes;
  @Min(1)
  @Max(10)
  private int probabilityToVote;
  @Min(1)
  @Max(5)
  @NotNull
  private Integer reaction;
  private Set<Topic> topics = new HashSet<>();
  private boolean doorOpened;
  private Geolocation geolocation;

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public int getProbabilityToVote() {
    return probabilityToVote;
  }

  public void setProbabilityToVote(int probabilityToVote) {
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

  public Geolocation getGeolocation() {
    return geolocation;
  }

  public void setGeolocation(Geolocation geolocation) {
    this.geolocation = geolocation;
  }

  public Door toDoor() {
    Door door = new Door();
    if (geolocation != null) {
      door.setGeolocation(new Geolocation(geolocation));
    }
    if (address != null) {
      door.setAddress(new Address(address));
    }
    return door;
  }

  public SurveyResponse toSurveyResponse() {
    SurveyResponse surveyResponse = new SurveyResponse();
    surveyResponse.setDoorOpened(doorOpened);
    surveyResponse.setNotes(notes);
    surveyResponse.setProbabilityToVote(probabilityToVote);
    surveyResponse.setReaction(reaction);
    if (topics != null) {
      surveyResponse.setTopics(topics.stream().map(Topic::new).collect(Collectors.toSet()));
    }
    if (address != null) {
      surveyResponse.setAddress(new Address(address));
    }
    return surveyResponse;
  }
}
