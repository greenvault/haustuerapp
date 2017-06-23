package de.gruene.haustuer.survey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Door {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Valid
  @Embedded
  private Address address;
  @JsonIgnore
  private Instant createdAt = Instant.now();
  @NotNull
  @JsonIgnore
  private String creator;
  @Valid
  @Embedded
  private Geolocation geolocation;

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

  public String getCreator() {
    return this.creator;
  }

  public Geolocation getGeolocation() {
    return this.geolocation;
  }

  public Long getId() {
    return this.id;
  }

  @Override
  public int hashCode() {
    return this.id != null ? this.id.hashCode() : 0;
  }

  public void setAddress(final Address address) {
    this.address = address;
  }

  public void setCreatedAt(final Instant createdAt) {
    this.createdAt = createdAt;
  }

  public void setCreator(final String creator) {
    this.creator = creator;
  }

  public void setGeolocation(final Geolocation geolocation) {
    this.geolocation = geolocation;
  }

  void setId(final Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Door{" + "id=" + this.id + '}';
  }
}
