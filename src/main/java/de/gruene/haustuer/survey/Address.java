package de.gruene.haustuer.survey;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address {

  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String street;
  @Size(max = 255)
  private String number;
  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String city;
  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String zip;
  @NotNull
  @NotEmpty
  @Size(max = 255)
  private String country;

  public Address() {}

  public Address(Address other) {
    street = other.street;
    number = other.number;
    city = other.city;
    zip = other.zip;
    country = other.country;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
